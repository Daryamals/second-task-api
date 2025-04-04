package data;

import dtos.AdditionRequest;
import dtos.EntityRequest;
import java.util.Arrays;
import com.github.javafaker.Faker;

public class TestDataGeneration {
	private static final Faker faker = new Faker();

	public static EntityRequest generateEntity() {
		AdditionRequest addition = new AdditionRequest();
		addition.setAdditionalInfo(faker.lorem().sentence());
		addition.setAdditionalNumber(faker.number().numberBetween(1, 1000));
		EntityRequest entity = new EntityRequest();
		entity.setTitle(faker.company().name());
		entity.setVerified(faker.bool().bool());
		entity.setImportantNumbers(Arrays.asList(faker.number().randomDigit(), faker.number().randomDigit()));
		entity.setAddition(addition);
		return entity;
	}

}
