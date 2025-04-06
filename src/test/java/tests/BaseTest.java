package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import data.TestDataGeneration;
import dtos.EntityRequest;

import static helpers.APIEndpoints.BASE_URI;
import helpers.EntitySteps;

@Epic("API тесты для сущностей")
public class BaseTest {
	protected EntitySteps entitySteps;
	protected EntityRequest testEntity;
	protected int testEntityId;
	protected boolean skipDelete = false;

	@Step("Установка базового URI для запросов")
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = BASE_URI;
		entitySteps = new EntitySteps();
	}

	@Step("Подготовка сущности перед тестом")
	@BeforeMethod
	public void createTestEntity() {
		testEntity = TestDataGeneration.generateEntity();
		testEntityId = entitySteps.createEntity(testEntity);
	}

	@Step("Очистка тестовых данных после теста")
	@AfterMethod
	public void deleteTestEntity() {
		if (!skipDelete) {
			entitySteps.deleteEntity(testEntityId);
		}
	}
}
