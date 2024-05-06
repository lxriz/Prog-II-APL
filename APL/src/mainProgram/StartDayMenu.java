package mainProgram;

import simulation.Simulation;

public class StartDayMenu implements MenuSimulation
{
	private void print(Translation translation, Simulation simulation)
	{
		PrintClearConsole();
		PrintSimulationHeader(translation, simulation);
		PrintLine();
	}
	
	
	private static String PrintStartDayMenuHelper(Translation translation, int response)
	{
		switch(response)
		{
			case 0:
				return translation.getText("SIMULATION_START_DAY_CUSTOMER_RESPONSE_SOLD_OUT");

			case 1:
				return translation.getText("SIMULATION_START_DAY_CUSTOMER_RESPONSE_TOO_EXPENSIVE");

			case 2:
				return translation.getText("SIMULATION_START_DAY_CUSTOMER_RESPONSE_BOUGHT");		
		}
		
		return "";
	}
	
	
	public void print(Translation translation, Simulation simulation, int[] response)
	{
		PrintClearConsole();
		PrintSimulationHeader(translation, simulation);
		
		switch(response[1])
		{
			case 1:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_CIGARETTES") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
				
			case 2:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_FRIES") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
				
			case 3:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_GUM") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
				
			case 4:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_ICE_CREAM") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
				
			case 5:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_LEMONADE") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
				
			case 6:
				System.out.println(" " + translation.getText("SIMULATION_START_DAY_CUSTOMER") + "[" + response[0] + "] - " + translation.getText("PRODUCT_NAME_NEWSPAPER") + ": " + PrintStartDayMenuHelper(translation, response[2]));
				break;
		}
		
		PrintLine();
	}
	
	
	
	@Override 
	public void main(Translation translation, Simulation simulation)
	{
		for(int i = 0; i < simulation.day.countCustomers; i++)
		{
			print(translation, simulation, simulation.day.nextCustomer());
		
		
			try
			{
				Thread.sleep(800);
			}
			catch(Exception e)
			{
				
			}
		}
		
		simulation.nextDay();
	}
	
	
	
}
