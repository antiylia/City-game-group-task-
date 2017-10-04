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
	private ComputerPlayer player;
	
	// САША - I've moved the list from the "play" method to get possibility using it in the "isCityUsed" method
	private List<String> reestrAnswers = new ArrayList<String>();  // MARK: ABOUT VALIDATION!!!
		
    public Player play (String namePlayer) {
		System.out.println("\"" + GAME_NAME + "\""+ " has been started...");
		
		player = new ComputerPlayer(namePlayer);
		List<String> cities = new InputCities().readCities(); 
		player.setListCities(cities);
		
		String userName = getUserInput ("Enter your name");
		User user = new User();
		user.setName(userName);
	
		System.out.println(player.getName() + " plays against " + user.getName() + "\n");
				
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
   // САША - Done 
    private String getCityByLetter(ComputerPlayer p, char l) {
<<<<<<< HEAD
    	
    	player.getListCities();
      return "Minsk";
      }
    
   // TODO САША 
    private boolean isCityUsed(String city, List<String> cities) {
    	
    	
    	return false;
    }
=======
    	String city = "";
    	char letter;
    	List<String> knownCities = new ArrayList<String>();
		knownCities = p.getListCities();
		List<String> suitedCities = new ArrayList<String>();
		for (int i = 0; i < knownCities.size(); i++) {
			if (!isCityUsed(knownCities.get(i))) {
				city = (String) knownCities.get(i);
				letter = city.charAt(0);
				if (letter == Character.toUpperCase(l))
					suitedCities.add(city);
			}
		}
		if (suitedCities.size() == 0)
			return "0";
		else {
			city = getRandomCity(suitedCities);
			return city;
		}
	}
    
    // САША - I've added this utility method in order to use random in the getCityByLetter method     
	private String getRandomCity(List<String> list) {
    	String city = "";
		int i = (int) new Random().nextInt(list.size());
		city = (String) list.get(i);
		return city;
	}   
   
	// САША - Done
    private boolean isCityUsed(String city) {
    	String c = "";
    	for (int i = 0; i < reestrAnswers.size(); i++) {
			c = reestrAnswers.get(i);
			if (city.equals(c))
				return true;
		}
		return false;
	}
>>>>>>> 443f1ed6c69c48acc11a7286fa00d7b6e0f50644
    
    // Для САШИ  -  new InputCities().readCities() is ready ( returns List<String> )  
    // Okay. I used the getter from the ComputerPlayer class
    
    	
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
    
   