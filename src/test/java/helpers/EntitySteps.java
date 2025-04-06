package helpers;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static jakarta.ws.rs.core.Response.Status.NO_CONTENT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import dtos.EntityRequest;
import dtos.EntityResponse;

import static helpers.APIEndpoints.*;

public class EntitySteps {

	@Step("Создание сущности")
	public static int createEntity(EntityRequest entity) {
		return given().contentType(ContentType.JSON).body(entity).when().post(CREATE).then().statusCode(OK.getStatusCode()).extract()
				.as(Integer.class);
	}

	@Step("Получение сущности по ID: {entityId}")
	public static EntityResponse getEntity(int entityId) {
		return given().pathParam("id", entityId).when().get(GET).then().statusCode(OK.getStatusCode()).extract()
				.as(EntityResponse.class);
	}

	@Step("Удаление сущности по ID: {entityId}")
	public static void deleteEntity(int entityId) {
		given().pathParam("id", entityId).when().delete(DELETE).then().statusCode(NO_CONTENT.getStatusCode());
	}

	@Step("Получение всех сущностей: страница {page}, по {perPage} на страницу")
	public static EntityResponse[] getAllEntities(int page, int perPage) {
		return given().queryParam("page", page).queryParam("perPage", perPage).when().get(GET_ALL).then().statusCode(OK.getStatusCode())
				.extract().jsonPath().getObject("entity", EntityResponse[].class);
	}

	@Step("Частичное обновление сущности по ID: {entityId}")
	public static void updateEntity(int entityId, EntityRequest updatedEntity) {
		given().pathParam("id", entityId).contentType(ContentType.JSON).body(updatedEntity).when().patch(UPDATE).then()
				.statusCode(NO_CONTENT.getStatusCode());
	}
}
