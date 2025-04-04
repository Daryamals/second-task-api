package helpers;

import static io.restassured.RestAssured.given;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import dtos.EntityRequest;
import dtos.EntityResponse;
import static data.ResponseCodes.OK;
import static data.ResponseCodes.NO_CONTENT;

public class BaseRequest extends APIEndpoints {
	@Step("Создание новой сущности")
	public static int createEntity(EntityRequest entity) {
		Response response = given().contentType(ContentType.JSON).body(entity).when().post(CREATE).then().statusCode(OK)
				.extract().response();
		return Integer.parseInt(response.asString());
	}

	@Step("Получение сущности по ID")
	public static EntityResponse getEntity(int entityId) {
		return given().pathParam("id", entityId).when().get(GET).then().statusCode(OK).extract()
				.as(EntityResponse.class);
	}

	@Step("Удаление сущности по ID")
	public static void deleteEntity(int entityId) {
		given().pathParam("id", entityId).when().delete(DELETE).then().statusCode(NO_CONTENT);
	}
}
