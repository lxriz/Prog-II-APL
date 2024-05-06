package mainProgram;

import java.util.Scanner;

public class ChangeLanguageMenu implements Menu
{
	public void print(Translation translation)
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
	
	
	@Override
	public void main(Translation translation)
	{
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		
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
				PrintInvalidInput(translation);
				continue;
			}
			
			
			String[] languages = translation.getSuppoertedLanguages();
			
			if(input < 0 || input > languages.length)
			{
				PrintInvalidInput(translation);
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
	
}
