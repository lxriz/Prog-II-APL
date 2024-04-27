package simulation;

import java.util.Random;

public class Customer 
{
	
	// Every customer only buys one thing
	
	public int age;
	private static double[] demand;
	private static Random r = new Random();
				
	
	
	public Customer(int weather)
	{
		this.age = r.nextInt(18, 101);
		
		switch(weather)
		{
			case 0:		
				// Rainy
				demand = new double[]{0.22, 0.20, 0.15, 0.11, 0.12, 0.20};
				break;
			case 1:	
				// Cloudy
				demand = new double[]{0.22, 0.20, 0.15, 0.11, 0.12, 0.20};
				break;
			case 2:	
				// Sunny
				demand = new double[]{0.22, 0.20, 0.15, 0.11, 0.12, 0.20};
				break;
		}
	}
	
	
	public int chooseProcduct()
	{
		double choice = r.nextDouble();
		
		double kumulativ = 0;
		for(int i = 0; i < demand.length; i++)
		{
			if(choice < kumulativ + demand[i])
			{
				return i;
			}
			else
			{
				kumulativ += demand[i];
			}
		}
		
		return -1;
	}
	
	
	private double priceAcceptance(double x)
	{
		return -0.001 * x + 1.172;
	}
	
	public boolean willBuy(double marketPrice, double kioskPrice)
	{
		
		double willingToPay = marketPrice * priceAcceptance(this.age);
				
		if(willingToPay >= kioskPrice)
		{
			return true;
		}
		
		return false;
	}
	
	
}
