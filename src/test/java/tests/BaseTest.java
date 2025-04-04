package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import helpers.BaseRequest;

@Epic("API тесты для сущностей")
public class BaseTest extends BaseRequest {
	@Step("Установка базового URI для запросов")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URI;
	}
}
