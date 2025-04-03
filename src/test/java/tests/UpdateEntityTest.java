package tests;

import static io.restassured.RestAssured.given;
import java.util.Arrays;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import pogo.AdditionRequest;
import pogo.EntityRequest;

@Feature("Обновление сущности")
public class UpdateEntityTest extends BaseTest {
	@Test(dependsOnMethods = "testCreateEntity")
	@Story("Обновление сущности")
	@Description("Тест проверяет возможность обновления данных сущности")
	public void testUpdateEntity() {
		AdditionRequest additionUpdate = new AdditionRequest();
		additionUpdate.setAdditional_info("Обновленные сведения");
		additionUpdate.setAdditional_number(456);

		EntityRequest entityUpdate = new EntityRequest();
		entityUpdate.setTitle("Обновленная сущность");
		entityUpdate.setVerified(false);
		entityUpdate.setImportant_numbers(Arrays.asList(99, 88, 77));
		entityUpdate.setAddition(additionUpdate);

		given().pathParam("id", createdEntityId).contentType(ContentType.JSON).body(entityUpdate).log().all().when()
				.patch("/api/patch/{id}").then().log().all().statusCode(204);

	}
}
