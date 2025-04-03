package tests;

import static io.restassured.RestAssured.given;
import java.util.Arrays;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pogo.AdditionRequest;
import pogo.EntityRequest;

@Feature("Создание сущности")
public class CreateEntityTest extends BaseTest {
	@Test
	@Story("Создание новой сущности через API")
	@Description("Тест проверяет успешное создание сущности")
	public void testCreateEntity() {
		Allure.step("Создание объекта AdditionRequest");
		AdditionRequest addition = new AdditionRequest();
		addition.setAdditional_info("Дополнительные сведения");
		addition.setAdditional_number(123);
		Allure.step("Создание объекта EntityRequest - тело запроса");
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
