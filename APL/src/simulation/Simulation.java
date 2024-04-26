package simulation;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import products.*;

public class Simulation 
{
	public class Day
	{
		// 0 - Rainy
		// 1 - Cloudy
		// 2 - Sunny
		public final int weather;
		
		public Market market;
		
		public Day()
		{
			Random r = new Random();
			this.weather = (int)(r.nextInt(3));
			market = new Market(this.weather);
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
		if(!endDays())
		{
			this.currentDay += 1;
			day = new Day();
			
			
			for(int i = 0; i < kiosk.storage.size(); i++)
			{			
				if(!kiosk.storage.get(i).age())
				{
					kiosk.setStorage(-kiosk.storage.get(i).size);
					kiosk.storage.remove(i);
					i--;
				}		
			}
		}
	}
}
