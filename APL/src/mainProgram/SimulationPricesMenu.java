package mainProgram;

import java.util.Scanner;

import simulation.Simulation;

public class SimulationPricesMenu implements MenuSimulation
{	
	private void PrintSimulationPricesMenu(Translation translation, Simulation simulation)
	{
		PrintClearConsole();
		PrintSimulationHeader(translation, simulation);
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
		
		PrintInput(translation);
	}
	
	
	public void main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while(running)
		{
			PrintSimulationPricesMenu(translation, simulation);
					
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
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				case 2:
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				case 3:
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				case 4:
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				case 5:
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				case 6:
					new SimulationPriceChangeMenu().main(translation, simulation, input);
					break;
				default:
					PrintInvalidInput(translation);
					break;
			}
		}
	}
	
	
}
