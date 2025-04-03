package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class DeleteEntityTest extends BaseTest {
	@Test(dependsOnMethods = "testGetAllEntities")
	public void testDeleteEntity() {
		given().pathParam("id", createdEntityId).when().delete("/api/delete/{id}").then().statusCode(204);
	}
}
