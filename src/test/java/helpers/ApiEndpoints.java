package helpers;

public class ApiEndpoints {
	public static final String BASE_URI = System.getProperty("base.url", "http://localhost:8080");
	public static final String CREATE = "/api/create";
	public static final String GET = "/api/get/{id}";
	public static final String UPDATE = "/api/patch/{id}";
	public static final String DELETE = "/api/delete/{id}";
	public static final String GET_ALL = "/api/getAll";
}