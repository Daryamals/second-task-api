package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pogo.EntityResponse;

@Feature("Получение сущности")
public class GetEntityTest extends BaseTest {
	@Test(dependsOnMethods = "testCreateEntity")
	@Story("Получение сущности по ID")
	@Description("Тест проверяет корректность данных полученной сущности после создания")
	public void testGetEntity() {
		Allure.step("Отправка GET запроса /api/get/{id}");
		EntityResponse entityResponse = given().pathParam("id", createdEntityId).log().all().when().get("/api/get/{id}")
				.then().log().all().statusCode(200).extract().as(EntityResponse.class);
		Allure.step("Проверка ответа");
		assert entityResponse.getId() == createdEntityId;
		assert entityResponse.getTitle().equals("Тестовая сущность");
		assert entityResponse.isVerified();
	}
}
