package helpers;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import dtos.EntityRequest;
import dtos.EntityResponse;
import static data.TestDataGeneration.PAGE;
import static data.TestDataGeneration.PER_PAGE;
import static helpers.APIEndpoints.CREATE;
import static helpers.APIEndpoints.DELETE;
import static helpers.APIEndpoints.GET;
import static helpers.APIEndpoints.GET_ALL;
import static helpers.APIEndpoints.UPDATE;

public class EntitySteps {

	private RequestSpecification baseRequest() {
		return given().contentType(ContentType.JSON);
	}

	@Step("Создание сущности")
	public int createEntity(EntityRequest entity) {
		String responseBody = baseRequest().body(entity).when().post(CREATE).then().statusCode(OK.getStatusCode())
				.extract().asString();

		return Integer.parseInt(responseBody);
	}

	@Step("Получение сущности по ID: {entityId}")
	public EntityResponse getEntity(int entityId) {
		return baseRequest().pathParam("id", entityId).when().get(GET).then().statusCode(OK.getStatusCode()).extract()
				.as(EntityResponse.class);
	}

	@Step("Удаление сущности по ID: {entityId}")
	public void deleteEntity(int entityId) {
		baseRequest().pathParam("id", entityId).when().delete(DELETE).then().statusCode(NO_CONTENT.getStatusCode());
	}

	@Step("Получение всех сущностей: страница {PAGE}, по {PER_PAGE} на страницу")
	public EntityResponse[] getAllEntities() {
		return baseRequest().queryParam("page", PAGE).queryParam("per_page", PER_PAGE).when().get(GET_ALL).then()
				.statusCode(OK.getStatusCode()).extract().jsonPath().getObject("entity", EntityResponse[].class);
	}

	@Step("Частичное обновление сущности по ID: {entityId}")
	public void updateEntity(int entityId, EntityRequest updatedEntity) {
		baseRequest().pathParam("id", entityId).contentType(ContentType.JSON).body(updatedEntity).when().patch(UPDATE)
				.then().statusCode(NO_CONTENT.getStatusCode());
	}

	@Step("Получение статуса сущности по ID: {entityId}")
	public int getEntityStatus(int entityId) {
		return baseRequest().pathParam("id", entityId).when().get(GET).then().extract().statusCode();
	}
}
