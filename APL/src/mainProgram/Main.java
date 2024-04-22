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
	
	//
	public static void Start()
	{
		Line();
		System.out.println(translation.getText("PROG_NAME"));
		Line();
	}
	
	
	//
	public static void main(String[] args)
	{
		
		Start();
		
		System.out.println(translation.getText("PRODUCT_NAME_NEWSPAPER"));
		
	}
	
	
	
	
}
