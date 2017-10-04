package by.htp.citygame.entity;

import java.util.List;

public class ComputerPlayer extends Player {

	private List<String> listCities;

	public ComputerPlayer() {
		super();
	}

	public ComputerPlayer(String name) {
		super(name);
	}

	public List<String> getListCities() {
		return listCities;
	}

	public void setListCities(List<String> listCities) {
		this.listCities = listCities;
	}

}
