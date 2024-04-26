package mainProgram;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import products.*;
import simulation.Kiosk;
import simulation.Simulation;



public class Main 
{	
	private static Scanner scan = new Scanner(System.in);
	
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
	
	
	private static String formateDouble(double d)
	{
		return String.format("%.2f", d);
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
				System.out.println("\t\t\t               \t \\|/");
				System.out.println("\t\t\t   _________   \t-ooo-");
				System.out.println("\t\t\t  /         \\ \t /|\\");
				System.out.println("\t\t\t  |   ___   |");
				System.out.println("\t\t\t  |  |___|  |");
				System.out.println("\t\t\t  |_________|");
				break;
				
		}
	}
	
	
	private static void PrintSimulationHeader(Simulation simulation)
	{			
		String weekday = "";
		String weatherText = "";
		
		// Lookup table weekday
		switch(simulation.getCurrentDay() % 7)
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
		switch(simulation.day.weather)
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
		
		
		PrintSimulationAnimation(simulation.day.weather);
		
		System.out.println("  " + translation.getText(weatherText) + "\t\t\t\t" + "[" + simulation.kiosk.ownerName + "'s Kiosk]");
		PrintLine();
		System.out.println("  | " + translation.getText(weekday) + " |\t\t\t" + translation.getText("SIMULATION_HEADER_WEATHER_1") + " " + simulation.getCurrentDay() + " " + translation.getText("SIMULATION_HEADER_WEATHER_2") + " " + simulation.maxDays);
		PrintLineDashed();		
		System.out.println("  | " + translation.getText("SIMULATION_HEADER_MONEY") + " |\t\t\t" + formateDouble(simulation.kiosk.getCash()) + "€");
		PrintLineDashed();
		System.out.println("  | " + translation.getText("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + simulation.kiosk.getUsedStorage() + " " + translation.getText("SIMULATION_HEADER_STORAGE_2") + " " + simulation.kiosk.storageSize + " " + translation.getText("SIMULATION_HEADER_STORAGE_3"));
		PrintLine();
		
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_CIGARETTES") + " X " + translation.getText("PRODUCT_NAME_CIGARETTES"));
		PrintLineDashed();
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_FRIES") + " X " + translation.getText("PRODUCT_NAME_FRIES"));
		PrintLineDashed();		
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_GUM") + " X " + translation.getText("PRODUCT_NAME_GUM"));
		PrintLineDashed();
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_ICE_CREAM") + " X " + translation.getText("PRODUCT_NAME_ICE_CREAM"));
		PrintLineDashed();
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_LEMONADE") + " X " + translation.getText("PRODUCT_NAME_LEMONADE"));
		PrintLineDashed();
		System.out.println("    " + simulation.kiosk.countProduct("PRODUCT_NAME_NEWSPAPER") + " X " + translation.getText("PRODUCT_NAME_NEWSPAPER"));
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
	
	private static void PrintPriceError()
	{
		PrintLineDotted();
		System.out.println(" " + translation.getText("SIMULATION_PRICE_MENU_ERROR_PRICE"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	private static void PrintSimulationPriceChangeMenu()
	{
		PrintLineDashed();
		System.out.println(" " + translation.getText("SIMULATION_PRICES_MENU_QUESTION"));
		PrintInput();
	}
	
	
	private static void SimulationPriceChangeMenu(int index, Simulation simulation)
	{
		PrintSimulationPriceChangeMenu();
		
		double input = -1;
		try
		{
			input = scan.nextDouble();
		}
		catch(Exception e)
		{
			scan.nextLine();
			PrintInvalidInput();
			return;
		}
		
		if(!simulation.kiosk.setPrice(index, input))
		{
			PrintPriceError();
		}
		
	}
	
	
	private static void PrintSimulationPricesMenu(Simulation simulation)
	{
		PrintClearConsole();
		PrintSimulationHeader(simulation);
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_PRICES_MENU"));
		PrintLine();
		System.out.println("    " + translation.getText("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t\t\t\t\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + translation.getText("PRODUCT_NAME_CIGARETTES") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(1)) + "€");
		PrintLineDotted();
		System.out.println(" 2| " + translation.getText("PRODUCT_NAME_FRIES") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(2)) + "€");
		PrintLineDotted();
		System.out.println(" 3| " + translation.getText("PRODUCT_NAME_GUM") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(3)) + "€");
		PrintLineDotted();
		System.out.println(" 4| " + translation.getText("PRODUCT_NAME_ICE_CREAM") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(4)) + "€");
		PrintLineDotted();
		System.out.println(" 5| " + translation.getText("PRODUCT_NAME_LEMONADE") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(5)) + "€");
		PrintLineDotted();
		System.out.println(" 6| " + translation.getText("PRODUCT_NAME_NEWSPAPER") + "\t\t\t\t\t" + formateDouble(simulation.kiosk.getPrice(6)) + "€");
		PrintLineDotted();
		System.out.println();
		System.out.println(" 0| " + translation.getText("SIMULATION_PRICES_MENU_BACK"));
		
		PrintInput();
	}
	
	
	private static void SimulationPricesMenu(Simulation simulation)
	{
		boolean running = true;
		while(running)
		{
			PrintSimulationPricesMenu(simulation);
					
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
					running = false;
					break;
				case 1:
					SimulationPriceChangeMenu(input, simulation);
					break;
				case 2:
					SimulationPriceChangeMenu(input, simulation);
					break;
				case 3:
					SimulationPriceChangeMenu(input, simulation);
					break;
				case 4:
					SimulationPriceChangeMenu(input, simulation);
					break;
				case 5:
					SimulationPriceChangeMenu(input, simulation);
					break;
				case 6:
					SimulationPriceChangeMenu(input, simulation);
					break;
				default:
					PrintInvalidInput();
					break;
			}
		}
	}
	
	
	private static List<Product> sortStorageExpired(List<Product> unsortedList)
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : unsortedList)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(productunsorted.expiresDays <= sortedList.get(i).expiresDays)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		return sortedList;
	}
	
	
	private static List<Product> sortStorageName(List<Product> unsortedList)
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : unsortedList)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(translation.getText(productunsorted.name).compareTo(translation.getText(sortedList.get(i).name)) < 0)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		return sortedList;
	}
	
	
	private static void PrintSimulationStorageMenu(Simulation simulation, List<Product> storage)
	{
		PrintClearConsole();
		PrintSimulationHeader(simulation);
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_STORAGE_MENU"));
		PrintLine();
	
		System.out.println("    " + translation.getText("SIMULATION_STORAGE_MENU_HEADER") + "\t\t" + translation.getText("SIMULATION_STORAGE_MENU_SIZE") + "\t" + translation.getText("SIMULATION_STORAGE_MENU_EXPIRES") + "\t" + translation.getText("SIMULATION_STORAGE_MENU_BUY_PRICE"));
		
		PrintLineDashed();
		
		for(Product product : storage)
		{
			System.out.println("    " + translation.getText(product.name) + "\t\t" + product.size + "\t" + product.expiresDays + " "+ "" + translation.getText("SIMULATION_STORAGE_MENU_DAY") + "\t\t" + formateDouble(product.buyPrice) + "€");
			PrintLineDotted();
		}
		
		PrintLine();
		System.out.println(" 1| " + translation.getText("SIMULATION_STORAGE_MENU_SORT_NAME"));
		System.out.println(" 2| " + translation.getText("SIMULATION_STORAGE_MENU_SORT_EXPIRES"));
		System.out.println();
		System.out.println(" 0| " + translation.getText("SIMULATION_STORAGE_MENU_BACK"));
		PrintInput();
	}
	
	
	private static void SimulationStorageMenu(Simulation simulation)
	{
		boolean running = true;
		
		List<Product> storage = simulation.kiosk.storage;
		
		
		while(running)
		{
			PrintSimulationStorageMenu(simulation, storage);
			
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
					running = false;
					break;
				case 1:
					storage = sortStorageName(simulation.kiosk.storage);
					break;
				case 2:
					storage = sortStorageExpired(simulation.kiosk.storage);
					break;
				case 3:
					break;
				default:
					PrintInvalidInput();
					break;
			}
		}
	}
	
	private static void PrintSimulationMarketBuyMenu()
	{
		PrintLineDashed();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_QUESTION_2"));
		PrintInput();
	}
	
	private static int SimulationMarketBuyMenu()
	{
		PrintSimulationMarketBuyMenu();
		
		int input = -1;
		try
		{
			input = scan.nextInt();
		}
		catch(Exception e)
		{
			PrintInvalidInput();
			return 0;
		}
				
		if(input < 0)
		{
			PrintInvalidInput();
			return 0;
		}
		
		return input;
	}
	
	private static void PrintStorageError()
	{
		PrintLineDotted();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_ERROR_STORAGE"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}
	
	private static void PrintCashError()
	{
		PrintLineDotted();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_ERROR_CASH"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}
	
	private static void PrintSimulationMarketMenu(Simulation simulation)
	{
		PrintClearConsole();
		PrintSimulationHeader(simulation);
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU"));
		PrintLine();
		System.out.println();
		System.out.println("    " + translation.getText("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_SIZE") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_EXPIRES") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + translation.getText("PRODUCT_NAME_CIGARETTES") + "\t\t" +simulation.day.market.cigarettes.size + "\t" + simulation.day.market.cigarettes.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.cigarettesPrice) + "€");
		PrintLineDotted();
		System.out.println(" 2| " + translation.getText("PRODUCT_NAME_FRIES") + "\t\t" +simulation.day.market.fries.size + "\t" + simulation.day.market.fries.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.friesPrice) + "€");
		PrintLineDotted();
		System.out.println(" 3| " + translation.getText("PRODUCT_NAME_GUM") + "\t\t" +simulation.day.market.gum.size + "\t" + simulation.day.market.gum.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.gumPrice) + "€");
		PrintLineDotted();
		System.out.println(" 4| " + translation.getText("PRODUCT_NAME_ICE_CREAM") + "\t\t" +simulation.day.market.iceCream.size + "\t" + simulation.day.market.iceCream.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.iceCreamPrice) + "€");
		PrintLineDotted();
		System.out.println(" 5| " + translation.getText("PRODUCT_NAME_LEMONADE") + "\t\t" +simulation.day.market.lemonade.size + "\t" + simulation.day.market.lemonade.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.lemonadePrice) + "€");
		PrintLineDotted();
		System.out.println(" 6| " + translation.getText("PRODUCT_NAME_NEWSPAPER") + "\t\t" +simulation.day.market.newspaper.size + "\t" + simulation.day.market.newspaper.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.newspaperPrice) + "€");
		PrintLine();
		
		System.out.println(" 0| " + translation.getText("SIMULATION_MARKET_MENU_BACK"));
		System.out.println();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_QUESTION"));
		
		PrintInput();
	}
	
	
	private static void SimulationMarketMenu(Simulation simulation)
	{
		boolean running = true;		
		
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
			
			int amount = 0;
			switch(input)
			{
				case 0:
					running = false;
					
					break;
					
				case 1:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.cigarettesPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.cigarettes.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.cigarettesPrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.cigarettes.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new Cigarettes(simulation.day.market.cigarettesPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				case 2:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.friesPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.fries.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.friesPrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.fries.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new Fries(simulation.day.market.friesPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				case 3:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.gumPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.gum.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.gumPrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.gum.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new Gum(simulation.day.market.gumPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				case 4:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.iceCreamPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.iceCream.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.iceCreamPrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.iceCream.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new IceCream(simulation.day.market.iceCreamPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				case 5:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.lemonadePrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.lemonade.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.lemonadePrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.lemonade.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new Lemonade(simulation.day.market.lemonadePrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				case 6:
					amount = SimulationMarketBuyMenu();
					if(simulation.kiosk.canPay(-amount * simulation.day.market.newspaperPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.newspaper.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.newspaperPrice);
							simulation.kiosk.setStorage(amount * simulation.day.market.newspaper.size);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.storage.add(new Newspaper(simulation.day.market.newspaperPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError();
						}
					}
					else
					{
						PrintCashError();
					}
					break;
					
				default:
					PrintInvalidInput();
					break;
			}	
		}
	}
	
	
	private static void Simulation()
	{
		boolean running = true;
						
		Simulation simulation = new Simulation(new Kiosk(EnterUsernameMenu()));

		
		while(running)
		{
			PrintClearConsole();

			//PrintSimulationHeader(simulation.day.weather, simulation.kiosk.ownerName, simulation.kiosk.getCash(), simulation.kiosk.getUsedStorage(), simulation.kiosk.storageSize, simulation.getCurrentDay(), simulation.getMaxDays());
			PrintSimulationHeader(simulation);

			
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
					SimulationPricesMenu(simulation);
					break;
				case 3:
					SimulationStorageMenu(simulation);
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
					scan.close();
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
		PrintStartScreen();
		MainMenu();
	}
}
