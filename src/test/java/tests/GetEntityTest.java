package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data.TestDataGeneration;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import dtos.EntityResponse;

@Feature("Получение сущности")
public class GetEntityTest extends BaseTest {

	@Step("Подготовка сущности перед тестом")
	@BeforeMethod
	public void createTestEntity() {
		testEntity = TestDataGeneration.generateEntity();
		testEntityId = entitySteps.createEntity(testEntity);
	}

	@Test
	@Story("Получение сущности по ID")
	@Description("Тест проверяет корректность данных полученной сущности после создания")
	public void testGetEntity() {
		EntityResponse entityResponse = entitySteps.getEntity(testEntityId);
		Assert.assertEquals(entityResponse.getId(), testEntityId, "ID сущности не совпадает");
		Assert.assertEquals(entityResponse.getTitle(), testEntity.getTitle(), "Заголовок сущности не совпадает");
		Assert.assertEquals(entityResponse.isVerified(), testEntity.isVerified(), "Флаг verified не совпадает");
	}

	@Step("Очистка тестовых данных после теста")
	@AfterMethod
	public void deleteTestEntity() {
		entitySteps.deleteEntity(testEntityId);
	}
}
