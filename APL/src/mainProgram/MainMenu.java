package mainProgram;

import java.util.Scanner;

public class MainMenu implements Menu
{
	private void print(Translation translation)
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
	
	
	
	@Override	
	public void main(Translation translation)
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
				PrintInput(translation);
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
	
			switch(input)
			{
				case 1:
					new SimulationMenu().main(translation, null);
					PrintClearConsole();
					break;
				case 2:
					new ChangeLanguageMenu().main(translation);
					break;
				case 3:
					new HighscoreMenu().main(translation);
					break;
				case 0:
					PrintClearConsole();
					running = false;
					scan.close();
					break;
				default:
					PrintInvalidInput(translation);
					break;
			
			}
		}
	}
}
