package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionRequest {
	@JsonProperty("additional_info")
	private String additionalInfo;
	@JsonProperty("additional_number")
	private int additionalNumber;
}
