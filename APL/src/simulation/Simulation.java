package simulation;

import java.util.Random;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class Simulation 
{
	public class Day
	{
		// 0 - Rainy
		// 1 - Cloudy
		// 2 - Sunny
		public final int weather;
		public Market market;
		
		private static Random r = new Random();
		
		public Day()
		{
			this.weather = (int)(r.nextInt(3));
			market = new Market(this.weather);
			
		}
		
		public void startDay()
		{
			int countCustomers = r.nextInt(20, 51);
			for(int i = 0; i < countCustomers; i++)
			{
				Customer customer = new Customer(weather);
				int choice = customer.chooseProcduct();
				
				choice++;
								
				switch(choice)
				{
					case 1:
						if(kiosk.countProduct("PRODUCT_NAME_CIGARETTES") > 0)
						{
							if(customer.willBuy(market.cigarettesPrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_CIGARETTES");
							}
						}
						break;
						
					case 2:
						if(kiosk.countProduct("PRODUCT_NAME_FRIES") > 0)
						{
							if(customer.willBuy(market.friesPrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_FRIES");
							}
						}						
						break;
						
					case 3:
						if(kiosk.countProduct("PRODUCT_NAME_GUM") > 0)
						{
							if(customer.willBuy(market.gumPrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_GUM");
							}
						}						
						break;
						
					case 4:
						if(kiosk.countProduct("PRODUCT_NAME_ICE_CREAM") > 0)
						{
							if(customer.willBuy(market.iceCreamPrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_ICE_CREAM");
							}
						}
						break;
						
					case 5:
						if(kiosk.countProduct("PRODUCT_NAME_LEMONADE") > 0)
						{
							if(customer.willBuy(market.lemonadePrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_LEMONADE");
							}
						}
						break;
						
					case 6:
						if(kiosk.countProduct("PRODUCT_NAME_NEWSPAPER") > 0)
						{
							if(customer.willBuy(market.newspaperPrice, kiosk.getPrice(choice)))
							{
								kiosk.setCash(kiosk.getPrice(choice));
								kiosk.removeFromStorage("PRODUCT_NAME_NEWSPAPER");
							}
						}
						break;
				}
			}
		
		}
	}
	
	
	private int currentDay; 
	public final int maxDays;
	
	public Kiosk kiosk; 
	public Day day;
	
	
	public Simulation(Kiosk kiosk)
	{
		this.kiosk = kiosk;
		this.day = new Day();
		
		this.currentDay = 1;
		this.maxDays = 21;
	}
	
	
	public int getCurrentDay()
	{
		return this.currentDay;
	}

	
	
	public boolean endDays()
	{
		if(this.maxDays == this.currentDay)
		{
			return true;
		}
		
		return false;
	}
	
	
	public void nextDay()
	{
		day.startDay();
		kiosk.ageStorage();	

		// Day ended
		this.currentDay += 1;
		day = new Day();		
	}
	
}
