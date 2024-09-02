package org.example;

import static io.restassured.RestAssured.given;

import java.io.DataInput;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.DataInputs;
import resources.APIMethods;

import resources.Utils;

public class Testcases extends Utils {

    RequestSpecification request;
    APIMethods apiMethod;
    DataInputs dataInputs = new DataInputs();
    ;

    // Get All Products
    @Test(priority = 1)
    public void getAllProducts() {
        apiMethod = APIMethods.valueOf("AllProducts");
        System.out.println(apiMethod.getResourceMethod());
        request = given().log().all().spec(requestSpecification());
        String getAllProductResponse = request.when().get(apiMethod.getResourceMethod()).then().assertThat()
                .statusCode(200).log().all().extract().response().asString();
    }

    // Get Product by ID - Path Parameter

    public void getProductById(int id) {
        apiMethod = APIMethods.valueOf("ProductByID");
        System.out.println(apiMethod.getResourceMethod());
        request = given().log().all().spec(requestSpecification()).pathParam("id", id);
        String getProductByIdResponse = request.when().get(apiMethod.getResourceMethod()).then().assertThat()
                .statusCode(200).log().all().extract().response().asString();
        JsonPath js = rowToJson(getProductByIdResponse);
        // Print price of product in console
        System.out.println(js.getInt("price"));
    }

    // Get Product by Category
    @Test(priority = 2)
    public void getProductByCategory() {
        apiMethod = APIMethods.valueOf("ProductByCategory");
        System.out.println(apiMethod.getResourceMethod());
        request = given().log().all().spec(requestSpecification()).queryParam("name", "Mobile");
        String response = request.when().get(apiMethod.getResourceMethod()).then().assertThat().statusCode(200).log()
                .all().extract().response().asString();
        JsonPath js = rowToJson(response);
        // print productID of second product
        System.out.println("The product of second product is " + js.getString("productId[1]"));
    }

    // Add Product
    @Test(priority=3)
    public void addProduct() {
        apiMethod=APIMethods.valueOf("AddProduct");
        request = given().log().all().spec(requestSpecification().body(dataInputs.addProduct()));
        String response = request.when().post(apiMethod.getResourceMethod()).then().assertThat().statusCode(201)
                .log().all().extract().response().asString();
        //verify the added product
        getProductById(dataInputs.id);
    }

    @Test(priority=4)
    public void updateProduct() {
        apiMethod = APIMethods.valueOf("UpdateProduct");
        request = given().log().all().spec(requestSpecification()).body(dataInputs.updateProduct());
        String response = request.when().put(apiMethod.getResourceMethod()).then().extract().response().asString();
        System.out.println(response);
        //Verify the updated product
        getProductById(dataInputs.id);
    }

    //Delete Product
    @Test(priority=5)
    public void deleteProduct() {
        apiMethod = APIMethods.valueOf("DeleteProduct");
        request = given().log().all().spec(requestSpecification()).pathParam("id", dataInputs.id);
        String response = request.when().delete(apiMethod.getResourceMethod()).then().extract().response().asString();
        System.out.println(response);

    }





}
