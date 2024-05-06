package mainProgram;

import java.util.Scanner;

import simulation.Simulation;

public class SimulationPriceChangeMenu implements MenuSimulationInput
{
	private void print(Translation translation)
	{
		PrintLineDashed();
		System.out.println(" " + translation.getText("SIMULATION_PRICES_MENU_QUESTION"));
		PrintInput(translation);
	}
	
	private void PrintPriceError(Translation translation)
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
	
	@Override
	public void main(Translation translation, Simulation simulation, int index)
	{
		Scanner scan = new Scanner(System.in);
		print(translation);
		
		double input = -1;
		try
		{
			input = scan.nextDouble();
		}
		catch(Exception e)
		{
			scan.nextLine();
			PrintInvalidInput(translation);
			return;
		}
		
		
		if(!simulation.kiosk.setPrice(index, input))
		{
			PrintPriceError(translation);
		}
	}
}
