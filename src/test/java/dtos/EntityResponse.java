package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EntityResponse {

	private int id;
	private String title;
	private boolean verified;

	@JsonProperty("important_numbers")
	private List<Integer> importantNumbers;

	private AdditionResponse addition;
}
