package mainProgram;

import java.util.Scanner;
import simulation.Kiosk;
import simulation.Simulation;


public class Main 
{	
	private static Translation translation = new Translation();
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Utility methods
	
	private static int lineLength = 70;
	
	private static void PrintLine()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	private static void PrintLineDashed()
	{
		for(int i = 0; i < lineLength/2; i++)
		{
			System.out.print("- ");
		}
		System.out.println();
	}
	
	private static void PrintLineDotted()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print(".");
		}
		System.out.println();
	}
	
	private static void PrintInput()
	{
		PrintLine();
		System.out.println(translation.getText("INPUT"));
		System.out.print("> ");
	}
	
	private static void PrintInvalidInput()
	{
		PrintLineDotted();
		System.out.println(" " + translation.getText("INVALID_INPUT"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
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
		System.out.println(" " + translation.getText("LANGUAGE_MENU"));
		PrintLine();
	
		
		String[] languages = translation.getSuppoertedLanguages();
		for(int i = 0; i < languages.length; i++)
		{
			System.out.println(" " + Integer.toString(i+1) + "| " + languages[i]);
		}
		
		System.out.println();
		System.out.println(" 0| " + translation.getText("LANGUAGE_MENU_EXIT"));

	}
	
	
	private static void ChangeLanguageMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		
		
		while(running)
		{
			PrintClearConsole();
			
			PrintChangeLanguage();
			
			int input = -1;
			try
			{
				PrintInput();
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
				PrintInvalidInput();
				continue;
			}
			
			
			String[] languages = translation.getSuppoertedLanguages();
			
			if(input < 0 || input > languages.length)
			{
				PrintInvalidInput();
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
		
		PrintClearConsole();
		
	}
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// High Score
	
	
	private static void PrintHighscoresMenu()
	{
		PrintClearConsole();
		PrintLine();
		System.out.println(" " + translation.getText("HIGHSCORES_MENU"));
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
	
	
	private static void PrintExitVerifyMenu()
	{
		System.out.println(" " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY"));
		System.out.println();

		System.out.println(" 1| " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY_STAY"));
		System.out.println(" 2| " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY_LEAVE"));
		
		PrintInput();
	}
	
	
	private static boolean ExitVerifyMenu()
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
	
		while(running)
		{
			PrintClearConsole();
			PrintExitVerifyMenu();

			int input = -1;
			try
			{
				input = scan.nextInt();
			}
			catch (Exception e)
			{
				scan.nextLine();
			}
			
			switch(input)
			{
				case 1:
					running = false;
					break;
				case 2:
					return true;
				default:
					PrintInvalidInput();
					break;
			}	
		}
		
		return false;
	}
	
	
	private static void PrintEnterUsernameMenu()
	{
		System.out.println(" " + translation.getText("SIMULATION_ENTER_NAME_MENU"));
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
	
	
	private static void PrintSimulationAnimation(int weather)
	{
		switch(weather)
		{
			case 0:
				// RAINY
				System.out.println("\t\t/\t    /      /      /   / ");
				System.out.println("\t\t/\t / _____/___      /");
				System.out.println("\t/\t\t  /         \\       /   /");
				System.out.println("\t\t/\t  |   ___   |            /");
				System.out.println("\t\t/\t  |  |___|  | /        /");
				System.out.println("\t/\t\t/ |_________|       /");
				break;
			case 1:
				// CLOUDY
				System.out.println("\t\t\t               \t ooOoo");
				System.out.println("\t\t\t   _________   \toOOooOoOoo");
				System.out.println("\t\t\t  /         \\ \t ooOOooo");
				System.out.println("\t\t\t  |   ___   |");
				System.out.println("\t\t\t  |  |___|  |");
				System.out.println("\t\t\t  |_________|");
				break;
			case 2:
				// SUNNY
				System.out.println("\t\t\t               \t ooo");
				System.out.println("\t\t\t   _________   \tooooo");
				System.out.println("\t\t\t  /         \\ \t ooo");
				System.out.println("\t\t\t  |   ___   |");
				System.out.println("\t\t\t  |  |___|  |");
				System.out.println("\t\t\t  |_________|");
				break;
				
		}
	}
	
	
	private static void PrintSimulationHeader(int weather, String ownerName, double cash, int usedStorage, int storageSize, int currentDay, int maxDays)
	{			
		String weekday = "";
		String weatherText = "";
		
		// Lookup table weekday
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
		
		// Lookup table weather
		switch(weather)
		{
			case 0:
				weatherText = "WEATHER_RAINY";
				break;
			case 1:
				weatherText = "WEATHER_CLOUDY";
				break;
			case 2:
				weatherText = "WEATHER_SUNNY";
				break;
		}
		
		
		PrintSimulationAnimation(weather);
		
		System.out.println("  " + translation.getText(weatherText) + "\t\t\t\t" + "[" + ownerName + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + translation.getText(weekday) + " |\t\t\t" + translation.getText("SIMULATION_HEADER_WEATHER_1") + " " + currentDay + " " + translation.getText("SIMULATION_HEADER_WEATHER_2") + " " + maxDays);
		PrintLineDashed();		
		System.out.println("  | " + translation.getText("SIMULATION_HEADER_MONEY") + " |\t\t\t" + cash + "€");
		PrintLineDashed();
		System.out.println("  | " + translation.getText("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + usedStorage + " " + translation.getText("SIMULATION_HEADER_STORAGE_2") + " " + storageSize + " " + translation.getText("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
	}
	
	
	private static void PrintSimulationMenu()
	{
		System.out.println();
		
		System.out.println(" 1| " + translation.getText("SIMULATION_MENU_START_DAY"));
		System.out.println(" 2| " + translation.getText("SIMULATION_MENU_PRICES"));
		System.out.println(" 3| " + translation.getText("SIMULATION_MENU_STORAGE"));
		System.out.println(" 4| " + translation.getText("SIMULATION_MENU_GET_PRODUCTS"));

		System.out.println();
		
		System.out.println(" 0| " + translation.getText("SIMULATION_MENU_END_GAME"));

		System.out.println();

		
		PrintInput();
	}
	
	
	private static void PrintSimulationPricesMenu()
	{
		PrintClearConsole();
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_PRICES_MENU"));
		PrintLine();
		PrintLineDashed();
		
		PrintInput();
		
	}
	
	private static void SimulationPricesMenu()
	{
		PrintSimulationPricesMenu();
		
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	private static void PrintSimulationMarketMenu(Simulation simulation)
	{
		PrintClearConsole();
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU"));
		PrintLine();
		System.out.println();
		System.out.println("    " + translation.getText("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_SIZE") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_EXPIRES") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + translation.getText("PRODUCT_NAME_CIGARETTES") + "\t" +simulation.day.market.cigarettes.size + "\t" + simulation.day.market.cigarettes.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + simulation.day.market.cigarettesPrice + "€");
		PrintInput();
	}
	
	
	private static void SimulationMarketMenu(Simulation simulation)
	{
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		
		
		while(running)
		{
			PrintSimulationMarketMenu(simulation);
			
			int input = -1;
			try
			{
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			// TEMP
			running = false;
			
		}
	}
	
	
	private static void Simulation()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
				
		Simulation simulation = new Simulation(new Kiosk(EnterUsernameMenu()));

		
		while(running)
		{
			PrintClearConsole();

			PrintSimulationHeader(simulation.day.weather, simulation.kiosk.ownerName, simulation.kiosk.getCash(), simulation.kiosk.getUsedStorage(), simulation.kiosk.storageSize, simulation.getCurrentDay(), simulation.getMaxDays());
			
			PrintSimulationMenu();
			
			int input = -1; 
			try
			{
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			
			switch(input)
			{
				case 0:
					if(ExitVerifyMenu())
					{
						running = false;
					}
					break;
				case 1:
					simulation.nextDay();
					break;
				case 2:
					SimulationPricesMenu();
					break;
				case 3:
					break;
				case 4:
					SimulationMarketMenu(simulation);
					break;
				default:
					PrintInvalidInput();
					break;
			}	
		}	
	}
		
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Main Menu
	
	
	private static void PrintMainMenu()
	{
		PrintLine();
		System.out.println(" " + translation.getText("MAIN_MENU"));
		PrintLine();
		
		System.out.println(" 1| " + translation.getText("MAIN_MENU_START"));
		System.out.println(" 2| " + translation.getText("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println(" 3| " + translation.getText("MAIN_MENU_SEE_SCORE"));
		System.out.println();
		System.out.println(" 0| " + translation.getText("MAIN_MENU_EXIT"));
	}
	
	
	private static void MainMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		while(running)
		{
			PrintClearConsole();
			
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
					break;
				case 3:
					HighscoresMenu();
					PrintClearConsole();
					break;
				case 0:
					PrintClearConsole();
					running = false;
					break;
				default:
					PrintInvalidInput();
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
		//PrintStartScreen();
		PrintClearConsole();
		MainMenu();
	}
}
