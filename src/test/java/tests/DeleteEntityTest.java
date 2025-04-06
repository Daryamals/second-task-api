package tests;

import org.testng.annotations.Test;
import data.TestDataGeneration;
import dtos.EntityRequest;
import helpers.EntitySteps;
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
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = EntitySteps.createEntity(entity);
		EntitySteps.getEntity(entityId);
		EntitySteps.deleteEntity(entityId);
	}

}
