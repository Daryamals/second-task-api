package tests;

import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import dtos.EntityRequest;
import helpers.BaseRequest;
import data.TestDataGeneration;

@Feature("Создание сущности")
public class CreateEntityTest extends BaseTest {
	@Test
	@Story("Создание новой сущности через API")
	@Description("Тест проверяет успешное создание сущности")
	public void testCreateEntity() {
		Allure.step("Генерация тестовых данных");
		EntityRequest entity = TestDataGeneration.generateEntity();
		Allure.step("Создание сущности через API");
		int entityId = BaseRequest.createEntity(entity);
		Allure.step("Удаление созданной сущности");
		BaseRequest.deleteEntity(entityId);
	}
}
