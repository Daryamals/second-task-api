package tests;

import org.testng.annotations.Test;
import dtos.EntityResponse;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Получение сущности")
public class GetEntityTest extends BaseTest {
	@Test
	@Story("Получение сущности по ID")
	@Description("Тест проверяет корректность данных полученной сущности после создания")
	public void testGetEntity() {
		EntityResponse entityResponse = entitySteps.getEntity(testEntityId);
		Assert.assertEquals(entityResponse.getId(), testEntityId, "ID сущности не совпадает");
		Assert.assertEquals(entityResponse.getTitle(), testEntity.getTitle(), "Заголовок сущности не совпадает");
		Assert.assertEquals(entityResponse.isVerified(), testEntity.isVerified(), "Флаг verified не совпадает");
		entitySteps.deleteEntity(testEntityId);
	}
}
