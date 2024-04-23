package mainProgram;

import java.util.Scanner;


public class Main 
{
	public static Translation translation = new Translation();
	
	//
	public static void Line()
	{
		for(int i = 0; i < 20; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	
	public static void PrintMainMenu()
	{
		System.out.println(translation.getText("PROG_NAME"));
		Line();
		
		System.out.println("1: " + translation.getText("MAIN_MENU_CHANGE_LANGUAGE"));
		System.out.println("2: " + translation.getText("MAIN_MENU_EXIT"));
	
	}
	
	
	
	
	
	//
	public static void main(String[] args)
	{
		PrintMainMenu();
		
		
	}
	
	
	
	
}
