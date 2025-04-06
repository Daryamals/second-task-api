package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


@Feature("Создание сущности")
public class CreateEntityTest extends BaseTest {
	@Test
	@Story("Создание новой сущности через API")
	@Description("Тест проверяет успешное создание сущности")
	public void testCreateEntity() {
		Assert.assertTrue(testEntityId>0, "Сущность не была создана");
	}
}
