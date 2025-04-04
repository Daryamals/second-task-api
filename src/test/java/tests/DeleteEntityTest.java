package tests;

import org.testng.annotations.Test;
import data.TestDataGeneration;
import dtos.EntityRequest;
import helpers.BaseRequest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Удаление сущности")
public class DeleteEntityTest extends BaseTest {
	@Test
	@Story("Удаление сущности через API")
	@Description("Тест проверяет успешное удаление сущности")
	public void testDeleteEntity() {
		Allure.step("Создание тестовой сущности перед удалением");
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = BaseRequest.createEntity(entity);
		Allure.step("Проверка, что сущность существует");
		BaseRequest.getEntity(entityId);
		Allure.step("Удаление сущности");
		BaseRequest.deleteEntity(entityId);
		Allure.step("Проверка, что сущность удалена");
	}

}
