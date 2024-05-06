package mainProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import products.Product;
import simulation.Simulation;

public class SimulationStorageMenu implements MenuSimulation
{

	private void print(Translation translation, Simulation simulation, List<Product> storage)
	{
		PrintClearConsole();
		PrintSimulationHeader(translation, simulation);
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_STORAGE_MENU"));
		PrintLine();
	
		System.out.println("    " + translation.getText("SIMULATION_STORAGE_MENU_HEADER") + "\t\t" + translation.getText("SIMULATION_STORAGE_MENU_SIZE") + "\t" + translation.getText("SIMULATION_STORAGE_MENU_EXPIRES") + "\t" + translation.getText("SIMULATION_STORAGE_MENU_BUY_PRICE"));
		
		PrintLineDashed();
		
		for(Product product : storage)
		{
			System.out.println("    " + translation.getText(product.name) + "\t\t" + product.size + "\t" + product.expiresDays + " "+ "" + translation.getText("SIMULATION_STORAGE_MENU_DAY") + "\t\t" + formateDouble(product.buyPrice) + "€");
			PrintLineDotted();
		}
		
		PrintLine();
		System.out.println(" 1| " + translation.getText("SIMULATION_STORAGE_MENU_SORT_NAME"));
		System.out.println(" 2| " + translation.getText("SIMULATION_STORAGE_MENU_SORT_EXPIRES"));
		System.out.println();
		System.out.println(" 0| " + translation.getText("SIMULATION_STORAGE_MENU_BACK"));
		PrintInput(translation);
	}
	
	private static List<Product> sortStorageExpired(Translation translation, List<Product> unsortedList)
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : unsortedList)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(productunsorted.expiresDays <= sortedList.get(i).expiresDays)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		return sortedList;
	}
	
	
	private static List<Product> sortStorageName(Translation translation, List<Product> unsortedList)
	{
		List<Product> sortedList = new ArrayList<>();

		for(Product productunsorted : unsortedList)
		{
			boolean inserted = false;
			for(int i = 0; i<sortedList.size(); i++)
			{
				if(translation.getText(productunsorted.name).compareTo(translation.getText(sortedList.get(i).name)) < 0)
				{
					sortedList.add(i, productunsorted);	
					inserted = true;
					break;
				}
			}
			
			if(!inserted)
			{
				sortedList.add(productunsorted);
			}
		}
		
		return sortedList;
	}
	
	
	@Override 
	public void main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		List<Product> storage = simulation.kiosk.storage;
		
		
		while(running)
		{
			print(translation, simulation, storage);
			
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
				case 0:
					running = false;
					break;
				case 1:
					storage = sortStorageName(translation, simulation.kiosk.storage);
					break;
				case 2:
					storage = sortStorageExpired(translation, simulation.kiosk.storage);
					break;
				case 3:
					break;
				default:
					PrintInvalidInput(translation);
					break;
			}
		}
	}
}
