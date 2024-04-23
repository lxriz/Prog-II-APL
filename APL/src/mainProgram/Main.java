package mainProgram;

import java.util.Scanner;


public class Main 
{
	public static Translation translation = new Translation();
	
	//
	public static void PrintLine()
	{
		for(int i = 0; i < 20; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	
	public static void PrintMainMenu()
	{
		PrintLine();
		System.out.println(translation.getText("PROG_NAME"));
		PrintLine();
		
		System.out.println("1: " + translation.getText("MAIN_MENU_START"));
		System.out.println("2: " + translation.getText("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println("3: " + translation.getText("MAIN_MENU_SEE_SCORE"));
		System.out.println("4: " + translation.getText("MAIN_MENU_EXIT"));
		
	}
	
	
	
	
	
	//
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		
		while(running)
		{
			PrintMainMenu();
			
			
			int input = scan.nextInt();
			switch(input)
			{
				case 2:
					translation.selectLanguage("DE");
					break;
				case 4:
					running = false;
				break;
			
			
			}
		}
	}
	
	
	
	
}
