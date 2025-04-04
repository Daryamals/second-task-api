package tests;

import static io.restassured.RestAssured.given;
import static data.ResponseCodes.OK;
import data.TestDataGeneration;
import dtos.EntityRequest;
import dtos.EntityResponse;
import helpers.BaseRequest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Получение всех сущностей")
public class GetAllEntitiesTest extends BaseTest {

	@Story("Получение списка сущностей")
	@Description("Тест проверяет получение списка сущностей")
	public void testGetAllEntities() {
		Allure.step("Создание тестовой сущности");
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = BaseRequest.createEntity(entity);
		Allure.step("Отправка запроса на получение всех сущностей");
		EntityResponse[] entities = given().queryParam("page", 1).queryParam("perPage", 10).when().get(GET_ALL).then()
				.statusCode(OK).extract().jsonPath().getObject("entity", EntityResponse[].class);
		Allure.step("Проверка, что в списке есть хотя бы одна сущность");
		assert entities.length > 0;
		Allure.step("Удаление тестовой сущности");
		BaseRequest.deleteEntity(entityId);
	}
}