package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;

@Feature("Удаление сущности")
public class DeleteEntityTest extends BaseTest {
	@Test
	@Story("Удаление сущности через API")
	@Description("Тест проверяет успешное удаление сущности")
	public void testDeleteEntity() {
		skipDelete = true;
		entitySteps.deleteEntity(testEntityId);
		int statusCode = entitySteps.getEntityStatus(testEntityId);
		Assert.assertEquals(statusCode, BAD_REQUEST, "Сущность не была удалена");
	}

}
