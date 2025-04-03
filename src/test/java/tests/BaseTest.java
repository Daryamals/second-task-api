package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected static int createdEntityId;

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:8080/";
	}
}
