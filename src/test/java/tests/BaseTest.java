package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import data.TestDataGeneration;
import static helpers.APIEndpoints.BASE_URI;
import helpers.EntitySteps;

@Epic("API тесты для сущностей")
public class BaseTest {
	private int entityId;

	@Step("Установка базового URI для запросов")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URI;
	}

	@BeforeMethod
	public void prepareEntity() {
		entityId = EntitySteps.createEntity(TestDataGeneration.generateEntity());
	}

	@AfterMethod
	public void cleanupEntity() {
		EntitySteps.deleteEntity(entityId);
	}
}
