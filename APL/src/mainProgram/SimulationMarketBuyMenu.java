package mainProgram;

import java.util.Scanner;

import simulation.Simulation;

public class SimulationMarketBuyMenu implements MenuSimulationReturn
{
	
	public void print(Translation translation, Simulation simulation)
	{
		PrintLineDashed();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_QUESTION_2"));
		PrintInput(translation);
	}
	
	
	public int main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		print(translation, simulation);
		
		int input = -1;
		try
		{
			input = scan.nextInt();
		}
		catch(Exception e)
		{
			PrintInvalidInput(translation);
			return 0;
		}
				
		if(input < 0)
		{
			PrintInvalidInput(translation);
			return 0;
		}
		
		return input;
	}
	
	
	
}
