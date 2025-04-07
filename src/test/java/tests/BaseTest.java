package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import dtos.EntityRequest;
import static helpers.ApiEndpoints.BASE_URI;
import helpers.EntitySteps;

@Epic("API тесты для сущностей")
public class BaseTest {
	protected EntitySteps entitySteps;
	protected EntityRequest testEntity;
	protected int testEntityId;

	@Step("Установка базового URI для запросов")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URI;
		entitySteps = new EntitySteps();
	}
}
