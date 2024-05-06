package mainProgram;

import simulation.Simulation;

public interface HelpersSimulation extends Helpers
{
	public default String formateDouble(double d)
	{
		return String.format("%.2f", d);
	}
	
	
	public default void PrintStorageError(Translation translation)
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
	
	
	public default void PrintCashError(Translation translation)
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
	
	
	private void PrintSimulationAnimation(int weather)
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
	
	
	public default void PrintSimulationHeader(Translation translation, Simulation simulation)
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
		System.out.println("  | " + translation.getText("SIMULATION_HEADER_STORAGE_1") + " |\t\t\t" + simulation.kiosk.getUsedStorageSize() + " " + translation.getText("SIMULATION_HEADER_STORAGE_2") + " " + simulation.kiosk.storageSize + " " + translation.getText("SIMULATION_HEADER_STORAGE_3"));
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
}
