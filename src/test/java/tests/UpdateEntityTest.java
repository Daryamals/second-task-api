package tests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import dtos.EntityRequest;
import dtos.EntityResponse;
import data.TestDataGeneration;
import static helpers.APIEndpoints.UPDATE;
import helpers.EntitySteps;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;

@Feature("Обновление сущности")
public class UpdateEntityTest extends BaseTest {

	@Test
	@Story("Частичное обновление сущности через API")
	@Description("Тест проверяет успешное частичное обновление сущности")
	public void testUpdateEntity() {
		EntityRequest entity = TestDataGeneration.generateEntity();
		int entityId = EntitySteps.createEntity(entity);
		EntityRequest updatedEntity = TestDataGeneration.generateEntity();
		given().pathParam("id", entityId).contentType(ContentType.JSON).body(updatedEntity).when().patch(UPDATE).then()
				.statusCode(NO_CONTENT.getStatusCode());
		EntityResponse updatedResponse = EntitySteps.getEntity(entityId);
		assert updatedResponse.getTitle().equals(updatedEntity.getTitle());
		assert updatedResponse.isVerified() == updatedEntity.isVerified();
		EntitySteps.deleteEntity(entityId);
	}
}
