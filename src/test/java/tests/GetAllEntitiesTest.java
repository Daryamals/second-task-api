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
		EntityResponse[] entities = entitySteps.getAllEntities();
		Assert.assertTrue(entities.length > 0, "Список тестовых сущностей пуст");
	}
}