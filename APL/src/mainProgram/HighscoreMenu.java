package mainProgram;

import java.util.Scanner;

public class HighscoreMenu implements Menu
{
	public void print(Translation translation)
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
	
	
	@Override
	public void main(Translation translation)
	{	Scanner scan = new Scanner(System.in);
		print(translation);
		scan.nextLine();
		PrintClearConsole();
	}
}
