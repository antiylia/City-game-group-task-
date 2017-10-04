package by.htp.citygame.entity;

public class User extends Player {

	private int age;  // used field, only - like a basement for inheritance

	public User() {
		super();
	}

	public User(String name, int age) {
		super(name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
