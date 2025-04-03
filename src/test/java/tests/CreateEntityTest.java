package tests;

import static io.restassured.RestAssured.given;
import java.util.Arrays;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pogo.AdditionRequest;
import pogo.EntityRequest;

public class CreateEntityTest extends BaseTest {
	@Test
	public void testCreateEntity() {
		AdditionRequest addition = new AdditionRequest();
		addition.setAdditional_info("Дополнительные сведения");
		addition.setAdditional_number(123);
		EntityRequest entity = new EntityRequest();
		entity.setTitle("Тестовая сущность");
		entity.setVerified(true);
		entity.setImportant_numbers(Arrays.asList(42, 87, 15));
		entity.setAddition(addition);
		Response response = given().contentType(ContentType.JSON).body(entity).when().post("/api/create").then()
				.statusCode(200).extract().response();
		createdEntityId = Integer.parseInt(response.asString());
	}
}
