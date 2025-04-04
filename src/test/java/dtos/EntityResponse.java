package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EntityResponse {
	@JsonProperty("id")
	private int id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("verified")
	private boolean verified;
	@JsonProperty("important_numbers")
	private List<Integer> importantNumbers;
	@JsonProperty("addition")
	private AdditionResponse addition;
}
