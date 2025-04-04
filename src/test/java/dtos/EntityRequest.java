package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EntityRequest {
	@JsonProperty("addition")
	private AdditionRequest addition;
	@JsonProperty("important_numbers")
	private List<Integer> importantNumbers;
	@JsonProperty("title")
	private String title;
	@JsonProperty("verified")
	private boolean verified;
}
