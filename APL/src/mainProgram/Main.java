package mainProgram;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import products.*;
import simulation.Kiosk;
import simulation.Simulation;



public class Main 
{		
	public static void main(String[] args)
	{
		Translation translation = new Translation();	
		
		new StartScreen().main(translation);
		new MainMenu().main(translation);
	}
}
