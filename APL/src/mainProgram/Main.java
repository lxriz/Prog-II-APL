package mainProgram;

import java.util.Scanner;


public class Main 
{
	public static Translation translation = new Translation();
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Utility methods
	public static void PrintLine()
	{
		for(int i = 0; i < 20; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void PrintClearConsole()
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Change Language 
	
	public static void PrintChangeLanguage()
	{
		PrintLine();
		System.out.println(translation.getText("LANGUAGE_MENU"));
		PrintLine();
	
		
		String[] languages = translation.getSuppoertedLanguages();
		for(int i = 0; i < languages.length; i++)
		{
			System.out.println(Integer.toString(i+1) + "| " + languages[i]);
		}
		
		System.out.println();
		System.out.println("0|" + translation.getText("LANGUAGE_MENU_EXIT"));

	}
	
	
	public static void ChangeLanguageMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		
		PrintClearConsole();
		
		while(running)
		{
			PrintChangeLanguage();
			
			try
			{
				int input = scan.nextInt();
			}
			catch(Exception e)
			{
				
			}
			
			running = false;
		}
		
	}
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// High Score
	
	public static void PrintHighscoresMenu()
	{
		PrintClearConsole();
		PrintLine();
		System.out.println(translation.getText("HIGHSCORES_MENU"));
		PrintLine();
		
		
		// HIER KOMMEN NOCH DIE HIGHSCORES HIN
		for(int i = 0; i < 3; i++)
		{
			System.out.println(i);
		}
	}
	
	public static void HighscoresMenu()
	{
		Scanner scan = new Scanner(System.in);
		

		PrintHighscoresMenu();
		scan.nextLine();
	}
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Main Menu
	public static void PrintMainMenu()
	{
		PrintLine();
		System.out.println(translation.getText("PROG_NAME"));
		PrintLine();
		
		System.out.println("1| " + translation.getText("MAIN_MENU_START"));
		System.out.println("2| " + translation.getText("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println("3| " + translation.getText("MAIN_MENU_SEE_SCORE"));
		System.out.println("4| " + translation.getText("MAIN_MENU_EXIT"));
	}
	
	public static void MainMenu()
	{
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		while(running)
		{
			PrintMainMenu();
			
			int input = 0;
			try
			{
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			PrintClearConsole();
	
			// HIER FEHLEN NOCH MEHR CASES
			// DEBUG CASE FÜR toString() ? 
			switch(input)
			{
				case 1:
					
					break;
				case 2:
					ChangeLanguageMenu();
					PrintClearConsole();
					break;
				case 3:
					HighscoresMenu();
					PrintClearConsole();
					break;
				case 4:
					running = false;
					break;
				default:
					System.out.println(translation.getText("INVALID_INPUT"));
					break;
			
			}
		}
	}
	

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	// Main Funktion
	public static void main(String[] args)
	{
		boolean running = true;
		PrintClearConsole();
		
		MainMenu();
	}
	
	
	
	
}
