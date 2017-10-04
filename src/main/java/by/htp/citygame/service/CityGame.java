package by.htp.citygame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import by.htp.citygame.dao.InputCities;
import by.htp.citygame.entity.ComputerPlayer;
import by.htp.citygame.entity.Player;
import by.htp.citygame.entity.User;

public class CityGame {
	
	private static final String GAME_NAME = "City game with two players";
	
	// Example for practising merging (Ylia)
 		
    public Player play (String namePlayer) {
		System.out.println("\"" + GAME_NAME + "\""+ " has been started...");
		
		ComputerPlayer player = new ComputerPlayer(namePlayer);
		List<String> cities = new InputCities().readCities(); 
		player.setListCities(cities);
		
		String userName = getUserInput ("Enter your name");
		User user = new User();
		user.setName(userName);
	
		System.out.println(player.getName() + " plays against " + user.getName() + "\n");
		
		List<String> reestrAnswers = new ArrayList<String>(); // MARK: ABOUT VALIDATION!!!
		
		String currentCity = " ";
		char letter = ' ';
	if (isComputerFirst ()) {
		
			System.out.println(player.getName() + " says first city");
			letter = getRandomChar(); 
			
			currentCity = getCityByLetter(player, letter);
			reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
			System.out.println(player.getName() + " : " + currentCity);
			
		while (!currentCity.equals("I don't know suitable city")) {	
			letter = getlastLetter (currentCity);
			
			currentCity = getUserInput("Enter city, which starts with " + letter);
			// HERE How to organise test if city named firstly? 
			// TODO!!!
			System.out.println(user.getName() + " : " + currentCity);
			if (currentCity.equalsIgnoreCase("I don't know suitable city")) {
				return player;
			  }
			reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
			
			
			letter = getlastLetter (currentCity);
			currentCity = getCityByLetter(player, letter);
			System.out.println(player.getName() + " : " + currentCity);
			
			if (currentCity.equalsIgnoreCase("I don't know suitable city")) {
				return user;
			  }			
			 reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
		  }
		return user;
	} else {
		
			System.out.println(user.getName() + " says first city");
			currentCity = getUserInput("Enter first city");
			reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
			System.out.println(user.getName() + " : " + currentCity);
			
			while (!currentCity.equals("I don't know suitable city")) {	
				
				letter = getlastLetter (currentCity);				
				currentCity = getCityByLetter(player, letter);
				System.out.println(player.getName() + " : " + currentCity);
				if (currentCity.equalsIgnoreCase("I don't know suitable city")) {
					return user;
				  }				
				reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
				
				letter = getlastLetter (currentCity);
				currentCity = getUserInput("Enter city, which starts with " + letter);
				System.out.println(user.getName() + " : " + currentCity);
				if (currentCity.equalsIgnoreCase("I don't know suitable city")) {
					return player;
				  }
				reestrAnswers.add(currentCity); // MARK: ABOUT VALIDATION!!!
										
			  }
			return player;
		}		
	}
	
    
    
    private char getlastLetter (String city) {
        return city.charAt(city.length()-1);    
     }
    
   /** 
    * Utility method, which returns city by first letter
    * + VALIDATION if the city is occured for the first time    
    * 
    * MARK: ABOUT VALIDATION!!! - Саша, look, it is necessary also to check user's answer on first-occuring.
    * it seems to me, that is better to have common List<String> in method play() for registrating all answers 
   */ 
   // TODO САША 
    private String getCityByLetter(ComputerPlayer p, char l) {
    	
    	
      return "Minsk";
      }
    
   // TODO САША 
    static boolean isCityUsed(String city) {
    	
    	
    	return false;
    }
    
    // Для САШИ  -  new InputCities().readCities() is ready ( returns List<String> )  
    
    	
    /**
     * Utility method, which randomly returns some char.
     * Is is necessary when Player is defining first city 
     * and not to dublicate method  " private String getCityByLetter(Player p, char l) "
     * but only provide random char for it
    */    
    private char getRandomChar () {
	   char [] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
			             'h', 'i', 'j', 'k', 'l','m','n', 'o', 'p', 'q', 
			             'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	   
	   Random r = new Random();
	    int i =-1;
		do {
		  i  = r.nextInt(array.length);
		} while (i>= array.length || i<0);
	 return array[i];	   
     }    
    
    
    /**
     * Utility method, which randomly returns boolean value.
     * Is is used for defining, if the Player (computer) will start the Game first or not
    */
    private boolean isComputerFirst () { // TODO ДАША
    
    	// using Random class!!!!
    	
      return true;
    }
    
    
    
    /**
	 * Utility method, which return String - as a result of User's input
	 *  it is used 1. when we get name of User
	 *             2. when we get response with city name
	 */
	public String getUserInput(String message) {
		String userInputLine = "";
		boolean flag = true;
		Scanner objScan = new Scanner(System.in);

		while (flag) {
			System.out.println(message);
			userInputLine = objScan.nextLine();

			if (userInputLine.length() > 1) {
				flag = false;
			}
		}
		return userInputLine;
	}
        
    
    
    
}
    
   