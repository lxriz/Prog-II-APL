package mainProgram;

import java.util.Scanner;

import products.Cigarettes;
import products.Fries;
import products.Gum;
import products.IceCream;
import products.Lemonade;
import products.Newspaper;
import simulation.Simulation;

public class SimulationMarketMenu implements MenuSimulation
{
	
	public void print(Translation translation, Simulation simulation)
	{
		PrintClearConsole();
		PrintSimulationHeader(translation, simulation);
		PrintLine();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU"));
		PrintLine();
		System.out.println();
		System.out.println("    " + translation.getText("SIMULATION_MARKET_MENU_HEADER_NAME") + "\t\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_SIZE") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_EXPIRES") + "\t" + translation.getText("SIMULATION_MARKET_MENU_HEADER_PRICE"));
		PrintLineDashed();
		System.out.println(" 1| " + translation.getText("PRODUCT_NAME_CIGARETTES") + "\t\t" +simulation.day.market.cigarettes.size + "\t" + simulation.day.market.cigarettes.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.cigarettesPrice) + "€");
		PrintLineDotted();
		System.out.println(" 2| " + translation.getText("PRODUCT_NAME_FRIES") + "\t\t" +simulation.day.market.fries.size + "\t" + simulation.day.market.fries.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.friesPrice) + "€");
		PrintLineDotted();
		System.out.println(" 3| " + translation.getText("PRODUCT_NAME_GUM") + "\t\t" +simulation.day.market.gum.size + "\t" + simulation.day.market.gum.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.gumPrice) + "€");
		PrintLineDotted();
		System.out.println(" 4| " + translation.getText("PRODUCT_NAME_ICE_CREAM") + "\t\t" +simulation.day.market.iceCream.size + "\t" + simulation.day.market.iceCream.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.iceCreamPrice) + "€");
		PrintLineDotted();
		System.out.println(" 5| " + translation.getText("PRODUCT_NAME_LEMONADE") + "\t\t" +simulation.day.market.lemonade.size + "\t" + simulation.day.market.lemonade.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.lemonadePrice) + "€");
		PrintLineDotted();
		System.out.println(" 6| " + translation.getText("PRODUCT_NAME_NEWSPAPER") + "\t\t" +simulation.day.market.newspaper.size + "\t" + simulation.day.market.newspaper.expiresDays + " " + translation.getText("SIMULATION_MARKET_MENU_DAYS") + "\t\t" + formateDouble(simulation.day.market.newspaperPrice) + "€");
		PrintLine();
		
		System.out.println(" 0| " + translation.getText("SIMULATION_MARKET_MENU_BACK"));
		System.out.println();
		System.out.println(" " + translation.getText("SIMULATION_MARKET_MENU_QUESTION"));
		
		PrintInput(translation);
	}
	
	@Override 
	public void main(Translation translation, Simulation simulation)
	{
		Scanner scan = new Scanner(System.in);
		boolean running = true;		
		
		while(running)
		{
			print(translation, simulation);
			
			int input = -1;
			try
			{
				input = scan.nextInt();
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
			
			int amount = 0;
			switch(input)
			{
				case 0:
					running = false;
					
					break;
					
				case 1:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.cigarettesPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.cigarettes.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.cigarettesPrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new Cigarettes(simulation.day.market.cigarettesPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				case 2:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.friesPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.fries.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.friesPrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new Fries(simulation.day.market.friesPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				case 3:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.gumPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.gum.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.gumPrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new Gum(simulation.day.market.gumPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				case 4:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.iceCreamPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.iceCream.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.iceCreamPrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new IceCream(simulation.day.market.iceCreamPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				case 5:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.lemonadePrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.lemonade.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.lemonadePrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new Lemonade(simulation.day.market.lemonadePrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				case 6:
					amount = new SimulationMarketBuyMenu().main(translation, simulation);
					if(simulation.kiosk.canPay(-amount * simulation.day.market.newspaperPrice))
					{
						if(simulation.kiosk.canStore(amount * simulation.day.market.newspaper.size))
						{
							simulation.kiosk.setCash(-amount * simulation.day.market.newspaperPrice);
							
							for(int i = 0; i < amount; i++)
							{
								simulation.kiosk.addStorage(new Newspaper(simulation.day.market.newspaperPrice));
							}
							continue;
						}
						else
						{
							PrintStorageError(translation);
						}
					}
					else
					{
						PrintCashError(translation);
					}
					break;
					
				default:
					PrintInvalidInput(translation);
					break;
			}	
		}
	}
}
