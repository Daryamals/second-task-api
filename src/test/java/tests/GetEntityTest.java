package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import dtos.EntityResponse;

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
	}
}
