package tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import dtos.EntityRequest;
import helpers.EntitySteps;
import data.TestDataGeneration;

@Feature("Создание сущности")
public class CreateEntityTest extends BaseTest {
	@Test
	@Story("Создание новой сущности через API")
	@Description("Тест проверяет успешное создание сущности")
	public void testCreateEntity() {
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = EntitySteps.createEntity(entity);
		EntitySteps.deleteEntity(entityId);
	}
}
