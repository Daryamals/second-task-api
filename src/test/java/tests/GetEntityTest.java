package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import data.TestDataGeneration;
import dtos.EntityRequest;
import dtos.EntityResponse;
import helpers.EntitySteps;
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
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = EntitySteps.createEntity(entity);
		
		EntityResponse entityResponse = EntitySteps.getEntity(entityId);
		
		assert entityResponse.getId() == entityId;
		assert entityResponse.getTitle().equals(entity.getTitle());
		assert entityResponse.isVerified();
		
		EntitySteps.deleteEntity(entityId);
	}
}
