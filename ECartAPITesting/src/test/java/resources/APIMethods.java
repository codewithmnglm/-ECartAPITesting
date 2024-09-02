package resources;

public enum APIMethods {
	AllProducts("/ecart/home"),
	ProductByID("/ecart/product/{id}"),
	ProductByCategory("/ecart/category"),
	AddProduct("/ecart/add"),
	UpdateProduct("/ecart/update"),
	DeleteProduct("/ecart/delete/{id}");
	
	private String resource;
	private APIMethods(String resource) {
		this.resource=resource;
	}
	public String getResourceMethod() {
		return resource;
	}
	
}
