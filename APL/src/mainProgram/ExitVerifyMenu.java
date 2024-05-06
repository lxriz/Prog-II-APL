package mainProgram;

import java.util.Scanner;

import simulation.Simulation;

public class ExitVerifyMenu implements MenuSimulationReturn
{
	private void print(Translation translation)
	{
		System.out.println(" " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY"));
		System.out.println();

		System.out.println(" 1| " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY_STAY"));
		System.out.println(" 2| " + translation.getText("SIMULATION_MENU_END_GAME_VERIFY_LEAVE"));
		
		PrintInput(translation);
	}
	
	@Override
	public int main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		while(running)
		{
			PrintClearConsole();
			print(translation);

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
					return 1;
				default:
					PrintInvalidInput(translation);
					break;
			}	
		}
		
		return 0;
		
	}
}
