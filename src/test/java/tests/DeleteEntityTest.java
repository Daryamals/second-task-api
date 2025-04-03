package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Удаление сущности")
public class DeleteEntityTest extends BaseTest {
	@Test(dependsOnMethods = "testGetAllEntities")
	@Story("Удаление сущности по ID")
	@Description("Тест проверяет успешное удаление существующей сущности")
	public void testDeleteEntity() {
		given().pathParam("id", createdEntityId).when().delete("/api/delete/{id}").then().statusCode(204);
	}
}
