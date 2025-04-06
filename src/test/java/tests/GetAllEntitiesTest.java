package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import dtos.EntityResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Получение всех сущностей")
public class GetAllEntitiesTest extends BaseTest {
	@Test
	@Story("Получение списка сущностей")
	@Description("Тест проверяет получение списка сущностей")
	public void testGetAllEntities() {
		// Исправить через data и TestDataGeneration. Добавить генерацию страниц
		EntityResponse[] entities = entitySteps.getAllEntities(1, 10);
		boolean found = false;
		for (EntityResponse entity : entities) {
			if (entity.getId() == testEntityId) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found, "Созданная тестовая сущность не найдена в списке");
	}
}