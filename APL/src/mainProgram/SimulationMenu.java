package mainProgram;

import java.util.Scanner;

import simulation.Kiosk;
import simulation.Simulation;

public class SimulationMenu implements MenuSimulation
{
	
	private void PrintEnterUsernameMenu(Translation translation)
	{
		System.out.println(" " + translation.getText("SIMULATION_ENTER_NAME_MENU"));
		PrintInput(translation);
	}
	
	
	private String EnterUsernameMenu(Translation translation)
	{
		Scanner scan = new Scanner(System.in);
		
		PrintClearConsole();
		String input = "";
		
		try
		{	
			PrintEnterUsernameMenu(translation);
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
		return EnterUsernameMenu(translation);
	}
	
	
	public void print(Translation translation, Simulation simulation)
	{
		System.out.println();
		
		System.out.println(" 1| " + translation.getText("SIMULATION_MENU_START_DAY"));
		System.out.println(" 2| " + translation.getText("SIMULATION_MENU_PRICES"));
		System.out.println(" 3| " + translation.getText("SIMULATION_MENU_STORAGE"));
		System.out.println(" 4| " + translation.getText("SIMULATION_MENU_GET_PRODUCTS"));

		System.out.println();
		
		System.out.println(" 0| " + translation.getText("SIMULATION_MENU_END_GAME"));

		System.out.println();

		
		PrintInput(translation);
	}
	
	@Override 
	public void main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		simulation = new Simulation(new Kiosk(EnterUsernameMenu(translation)));

		
		while(running)
		{
			PrintClearConsole();

			//PrintSimulationHeader(simulation.day.weather, simulation.kiosk.ownerName, simulation.kiosk.getCash(), simulation.kiosk.getUsedStorage(), simulation.kiosk.storageSize, simulation.getCurrentDay(), simulation.getMaxDays());
			PrintSimulationHeader(translation, simulation);

			
			print(translation, simulation);
			
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
					if(new ExitVerifyMenu().main(translation, simulation) == 1)
					{
						running = false;
					}
					break;
				case 1:
					new StartDayMenu().main(translation, simulation);
					if(simulation.checkEndGame())
					{
						running = false;
						new EndGameMenu().main(translation, simulation);
					}
					break;
				case 2:
					new SimulationPricesMenu().main(translation, simulation);
					break;
				case 3:
					new SimulationStorageMenu().main(translation, simulation);
					break;
				case 4:
					new SimulationMarketMenu().main(translation, simulation);
					break;
				default:
					PrintInvalidInput(translation);
					break;
			}	
		}	
	}
}
