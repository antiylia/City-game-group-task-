package by.htp.citygame.entity;

public class Player {  // it is necessary to have common type for ComputerPlayer and User

	private String name;
	
	public Player() {
		super();
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Player " + name;
	}

}
