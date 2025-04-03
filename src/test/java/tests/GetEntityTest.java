package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import pogo.EntityResponse;

public class GetEntityTest extends BaseTest {
	@Test(dependsOnMethods = "testCreateEntity")
	public void testGetEntity() {
		EntityResponse entityResponse = given().pathParam("id", createdEntityId).log().all().when().get("/api/get/{id}")
				.then().log().all().statusCode(200).extract().as(EntityResponse.class);
		assert entityResponse.getId() == createdEntityId;
		assert entityResponse.getTitle().equals("Тестовая сущность");
		assert entityResponse.isVerified();
	}
}
