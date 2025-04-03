package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pogo.EntityResponse;

@Feature("Получение всех сущностей")
public class GetAllEntitiesTest extends BaseTest {

	@Test(dependsOnMethods = "testUpdateEntity")
	@Story("Получение списка сущностей")
	@Description("Тест проверяет получение списка сущностей")
	public void testGetAllEntities() {
		EntityResponse[] entities = given().queryParam("page", 1).queryParam("perPage", 10).when().get("/api/getAll")
				.then().statusCode(200).extract().jsonPath().getObject("entity", EntityResponse[].class);
		assert entities.length > 0;
	}
}