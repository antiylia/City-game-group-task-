package by.htp.citygame.runner;

import by.htp.citygame.entity.Player;
import by.htp.citygame.service.CityGame;

public class Main {

	public static void main(String[] args) {
		String nameComputerPlayer = "Bob-bot";
		
		CityGame game = new CityGame();
		Player winner = game.play(nameComputerPlayer);
		System.out.println("The winner is " + winner);
	}

}
