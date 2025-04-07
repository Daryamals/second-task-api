package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EntityRequest {
	
	private AdditionRequest addition;
	@JsonProperty("important_numbers")
	
	private List<Integer> importantNumbers;
	
	private String title;
	
	private boolean verified;
}
