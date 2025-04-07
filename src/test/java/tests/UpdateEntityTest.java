package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import data.TestDataGeneration;
import dtos.EntityResponse;

@Feature("Обновление сущности")
public class UpdateEntityTest extends BaseTest {

	@Step("Подготовка сущности перед тестом")
	@BeforeMethod
	public void createTestEntity() {
		testEntity = TestDataGeneration.generateEntity();
		testEntityId = entitySteps.createEntity(testEntity);
	}

	@Test
	@Story("Частичное обновление сущности через API")
	@Description("Тест проверяет успешное частичное обновление сущности")
	public void testUpdateEntity() {
		testEntity = TestDataGeneration.generateEntity();
		entitySteps.updateEntity(testEntityId, testEntity);

		EntityResponse updatedResponse = entitySteps.getEntity(testEntityId);

		Assert.assertEquals(updatedResponse.getTitle(), testEntity.getTitle(), "Заголовки не совпадают");
		Assert.assertEquals(updatedResponse.isVerified(), testEntity.isVerified(), "Статусы верификации не совпадают");
	}

	@Step("Очистка тестовых данных после теста")
	@AfterMethod
	public void deleteTestEntity() {
		entitySteps.deleteEntity(testEntityId);
	}
}
