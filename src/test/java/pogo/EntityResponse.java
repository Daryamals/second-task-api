package pogo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityResponse {
	private AdditionResponse addition;
	private int id;
	private List<Integer> important_numbers;
	private String title;
	private boolean verified;
}