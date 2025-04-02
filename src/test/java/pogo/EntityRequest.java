package pogo;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EntityRequest {
	private AdditionRequest addition;
	private List<Integer> important_numbers;
	private String title;
	private boolean verified;
}