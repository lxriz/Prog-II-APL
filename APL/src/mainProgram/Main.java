package mainProgram;

import java.util.Scanner;
import simulation.Kiosk;
import simulation.Simulation;


public class Main 
{
	private static Translation translation = new Translation();
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Utility methods
	
	
	private static void PrintLine()
	{
		for(int i = 0; i < 50; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	private static void PrintInput()
	{
		PrintLine();
		System.out.println(translation.getText("INPUT"));
		System.out.print("> ");
	}
	
	private static void PrintClearConsole()
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Change Language 
	
	
	private static void PrintChangeLanguage()
	{
		PrintLine();
		System.out.println(translation.getText("LANGUAGE_MENU"));
		PrintLine();
	
		
		String[] languages = translation.getSuppoertedLanguages();
		for(int i = 0; i < languages.length; i++)
		{
			System.out.println(Integer.toString(i+1) + "| " + languages[i]);
		}
		
		System.out.println();
		System.out.println("0| " + translation.getText("LANGUAGE_MENU_EXIT"));

	}
	
	
	private static void ChangeLanguageMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		
		PrintClearConsole();
		
		while(running)
		{
			PrintChangeLanguage();
			
			int input = -1;
			try
			{
				PrintInput();
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				PrintClearConsole();
				scan.nextLine();
				System.out.println(translation.getText("INVALID_INPUT"));
				continue;
			}
			
			PrintClearConsole();
			
			String[] languages = translation.getSuppoertedLanguages();
			
			if(input < 0 || input > languages.length)
			{
				System.out.println(translation.getText("INVALID_INPUT"));
				continue;
			}
				
			if(input == 0)
			{
				running = false;
			}
			else
			{
				translation.selectLanguage(languages[input-1]);
			}
			
		}
		
	}
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// High Score
	
	
	private static void PrintHighscoresMenu()
	{
		PrintClearConsole();
		PrintLine();
		System.out.println(translation.getText("HIGHSCORES_MENU"));
		PrintLine();
		
		
		// HIER KOMMEN NOCH DIE HIGHSCORES HIN
		for(int i = 0; i < 3; i++)
		{
			System.out.println(i);
		}
	}
	
	
	private static void HighscoresMenu()
	{
		Scanner scan = new Scanner(System.in);
		
		PrintHighscoresMenu();
		scan.nextLine();
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Simulation
	
	
	private static void PrintEnterUsernameMenu()
	{
		System.out.println(translation.getText("SIMULATION_ENTER_NAME_MENU"));
		PrintInput();
	}
	
	
	private static String EnterUsernameMenu()
	{
		Scanner scan = new Scanner(System.in);

		PrintClearConsole();
		String input = "";
		
		try
		{	
			PrintEnterUsernameMenu();
			 input = scan.nextLine();
		}
		catch(Exception e)
		{
			
		}
		
		if(!input.isEmpty())
		{
			PrintClearConsole();
			return input;
		}
		
		PrintClearConsole();
		return EnterUsernameMenu();
	}
	
	
	private static void PrintSimulationAnimation()
	{
		// HIER KANN MAN AM ENDE NOCH DAS WETTER IN DER ANIMATION ANZEIGEN LASSEN
		
		System.out.println("\t  _______");
		System.out.println("\t /       \\");
		System.out.println("\t/         \\");
		System.out.println("\t|   ___   |    O");
		System.out.println("\t|  |___|  |   /|\\");
		System.out.println("\t|_________|   / \\");
		
	}
	
	
	private static void PrintSimulationHeader(String username, int currentDay, int maxDays)
	{
		String weekday = "";
		
		switch(currentDay % 7)
		{
			case 0:
				weekday = "DAY_7";
				break;
			case 1:
				weekday = "DAY_1";
				break;
			case 2:
				weekday = "DAY_2";
				break;
			case 3:
				weekday = "DAY_3";
				break;
			case 4:
				weekday = "DAY_4";
				break;
			case 5:
				weekday = "DAY_5";
				break;
			case 6:
				weekday = "DAY_6";
				break;
		}
		
		
		PrintSimulationAnimation();
		
		PrintLine();
		System.out.println(username + "'s Kiosk");
		PrintLine();
		PrintLine();
		System.out.println(translation.getText("SIMULATION_HEADER_MONEY") + "\t500€");
		PrintLine();
		System.out.println(currentDay + "/" + maxDays + "\t" + translation.getText(weekday));
		PrintLine();
		
		
	}
	
	
	private static void PrintSimulationMenu()
	{
		System.out.println();
		System.out.println();
		
		System.out.println("1| " + translation.getText("SIMULATION_MENU_START_DAY"));
		System.out.println("2| " + translation.getText("SIMULATION_MENU_STORAGE"));
		System.out.println("3| " + translation.getText("SIMULATION_MENU_PRICES"));
		
		System.out.println("4| " + translation.getText("SIMULATION_MENU_GET_PRODUCTS"));

		System.out.println();
		
		System.out.println("0| " + translation.getText("SIMULATION_MENU_END_GAME"));

		System.out.println();

		
		PrintInput();
	}
	
	
	private static void Simulation()
	{
		PrintClearConsole();
		
		
		Simulation simulation = new Simulation(new Kiosk(EnterUsernameMenu()));

		

		PrintSimulationHeader(simulation.getKioskUsername(), simulation.getCurrentDay(), simulation.getMaxDays());
		
		PrintSimulationMenu();
		
		try
		{
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			
		}
		
		// 1. Tag starten
		// 2. Waren einkaufen
		// 3. Lager ansehen
		
		
	}
		
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Main Menu
	
	
	private static void PrintMainMenu()
	{
		PrintLine();
		System.out.println(translation.getText("MAIN_MENU"));
		PrintLine();
		
		System.out.println("1| " + translation.getText("MAIN_MENU_START"));
		System.out.println("2| " + translation.getText("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println("3| " + translation.getText("MAIN_MENU_SEE_SCORE"));
		System.out.println("4| " + translation.getText("MAIN_MENU_EXIT"));
	}
	
	
	private static void MainMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		while(running)
		{
			PrintMainMenu();
			
			int input = -1;
			try
			{	
				PrintInput();
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			PrintClearConsole();
	
			// HIER FEHLEN NOCH MEHR CASES
			// DEBUG CASE FÜR toString() ? 
			switch(input)
			{
				case 1:
					Simulation();
					PrintClearConsole();
					break;
				case 2:
					ChangeLanguageMenu();
					PrintClearConsole();
					break;
				case 3:
					HighscoresMenu();
					PrintClearConsole();
					break;
				case 4:
					running = false;
					break;
				default:
					System.out.println(translation.getText("INVALID_INPUT"));
					break;
			
			}
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// StartScreen
	
	
	// Prints a short screen when the game starts
	//
	private static void PrintStartScreen()
	{
		PrintLine();
		for(int i = 0; i < 20; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		
		System.out.println(">   " + translation.getText("PROG_NAME") + "  <");
		
		System.out.println();
		System.out.println();

		System.out.println(translation.getText("START_SCREEN"));
		
		for(int i = 0; i < 20; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		
		PrintLine();
		
		
		try
		{
			Thread.sleep(2100);
		}
		catch(Exception e)
		{
			
		}
		
	}
	

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Main Funktion
	
	
	public static void main(String[] args)
	{
		PrintStartScreen();
		PrintClearConsole();
		MainMenu();
	}
}
