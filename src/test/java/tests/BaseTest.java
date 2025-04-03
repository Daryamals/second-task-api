package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

@Epic("API тесты для сущностей")
public class BaseTest {
	protected static int createdEntityId;

	@Step("Установка базового URI для запросов")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "http://localhost:8080/";
	}
}
