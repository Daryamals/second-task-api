package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import pogo.EntityResponse;

public class GetAllEntitiesTest extends BaseTest {
	@Test(dependsOnMethods = "testUpdateEntity")
	public void testGetAllEntities() {
		EntityResponse[] entities = given().queryParam("page", 1).queryParam("perPage", 10).when().get("/api/getAll")
				.then().statusCode(200).extract().as(EntityResponse[].class);
		assert entities.length > 0;

	}
}