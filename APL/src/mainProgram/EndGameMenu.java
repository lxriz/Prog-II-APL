package mainProgram;

import java.util.Scanner;

import simulation.Simulation;

public class EndGameMenu implements MenuSimulation
{	
	public void print(Translation translation, Simulation simulation)
	{
		PrintClearConsole();
		PrintLine();
		System.out.println();
		System.out.println(" " + translation.getText("SIMULATION_END_GAME_GAME_OVER"));
		System.out.println();
		PrintLine();
		System.out.println("  " + translation.getText("SIMULATION_END_GAME_PROFIT") + ": " + formateDouble((simulation.kiosk.getCash()-simulation.kiosk.startCash)) + "€");
		PrintLineDotted();
		System.out.println("  " + translation.getText("SIMULATION_END_GAME_PROFIT_PER_DAY") + ": " + formateDouble((simulation.kiosk.getCash()-simulation.kiosk.startCash)/((double)simulation.maxDays)) + "€");
		PrintLine();
		System.out.println();
		System.out.println("  " + translation.getText("SIMULATION_END_GAME_SAVE_HIGHSCORE"));
		PrintLine();
		System.out.println(" 1| " + translation.getText("SIMULATION_END_GAME_SAVE_HIGHSCORE_YES"));
		System.out.println(" 2| " + translation.getText("SIMULATION_END_GAME_SAVE_HIGHSCORE_NO"));
		
		PrintInput(translation);
	}
	
	
	@Override
	public void main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		while(running)
		{
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
				case 1:
					// HIER KOMMT NOCH SAVE METHODE REIN !!!
					break;
				case 2:
					running = false;
					break;
				default:
					PrintInvalidInput(translation);
					break;
			}
		}
	}
	
}
