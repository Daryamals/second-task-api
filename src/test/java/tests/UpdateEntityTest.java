package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import dtos.EntityRequest;
import dtos.EntityResponse;
import data.TestDataGeneration;
import helpers.APIEndpoints;
import helpers.BaseRequest;
import static data.ResponseCodes.OK;
import static data.ResponseCodes.NO_CONTENT;

@Feature("Обновление сущности")
public class UpdateEntityTest extends BaseTest {

	@Test
	@Story("Частичное обновление сущности через API")
	@Description("Тест проверяет успешное частичное обновление сущности")
	public void testUpdateEntity() {
		Allure.step("Создание тестовой сущности");
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = BaseRequest.createEntity(entity);
		Allure.step("Генерация обновленных данных");
		EntityRequest updatedEntity = TestDataGeneration.generateEntity();
		Allure.step("Отправка PATCH-запроса на частичное обновление сущности");
		given().pathParam("id", entityId).contentType(ContentType.JSON).body(updatedEntity).when().patch(UPDATE).then()
				.statusCode(NO_CONTENT);
		Allure.step("Проверка, что данные успешно обновлены");
		EntityResponse updatedResponse = BaseRequest.getEntity(entityId);
		assert updatedResponse.getTitle().equals(updatedEntity.getTitle());
		assert updatedResponse.isVerified() == updatedEntity.isVerified();
		Allure.step("Удаление тестовой сущности");
		BaseRequest.deleteEntity(entityId);
	}
}
