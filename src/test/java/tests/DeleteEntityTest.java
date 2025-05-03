package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.TestDataGeneration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import static jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Feature("Удаление сущности")
public class DeleteEntityTest extends BaseTest {
	
	@Step("Подготовка сущности перед тестом")
	@BeforeMethod
	public void createTestEntity() {
		testEntity = TestDataGeneration.generateEntity();
		testEntityId = entitySteps.createEntity(testEntity);
	}
	
	@Test
	@Story("Удаление сущности через API")
	@Description("Тест проверяет успешное удаление сущности")
	public void testDeleteEntity() {
		entitySteps.deleteEntity(testEntityId);
		int statusCode = entitySteps.getEntityStatus(testEntityId);
		Assert.assertEquals(statusCode, INTERNAL_SERVER_ERROR.getStatusCode(), "Сущность не была удалена. Ожидался 500, но получено:" + statusCode);
	}

}
