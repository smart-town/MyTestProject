package smalltown.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestModel {
	@NotNull
	@Size(min=2,max=16)
	private String name ;
	
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
