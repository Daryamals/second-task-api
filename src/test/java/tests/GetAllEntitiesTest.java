package tests;

import dtos.EntityResponse;
import helpers.EntitySteps;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Получение всех сущностей")
public class GetAllEntitiesTest extends BaseTest {

	@Story("Получение списка сущностей")
	@Description("Тест проверяет получение списка сущностей")
	public void testGetAllEntities() {
//		EntityRequest entity = TestDataGeneration.generateEntity();
//		int entityId = BaseRequest.createEntity(entity);
		
		//Исправить через data и TestDataGeneration. Добавить генерацию страниц
		EntityResponse[] entities = EntitySteps.getAllEntities(1,10);
		assert entities.length > 0 : "Список сущностей пуст";
//		BaseRequest.deleteEntity(entityId);
	}
}