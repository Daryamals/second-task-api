package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data.TestDataGeneration;
import dtos.EntityResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Feature("Получение всех сущностей")
public class GetAllEntitiesTest extends BaseTest {

	@Step("Подготовка сущности перед тестом")
	@BeforeMethod
	public void createTestEntity() {
		testEntity = TestDataGeneration.generateEntity();
		testEntityId = entitySteps.createEntity(testEntity);
	}

	@Test
	@Story("Получение списка сущностей")
	@Description("Тест проверяет получение списка сущностей")
	public void testGetAllEntities() {
		EntityResponse[] entities = entitySteps.getAllEntities();
		Assert.assertTrue(entities.length > 0, "Список тестовых сущностей пуст");
	}

	@Step("Очистка тестовых данных после теста")
	@AfterMethod
	public void deleteTestEntity() {
		entitySteps.deleteEntity(testEntityId);
	}
}