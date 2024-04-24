package simulation;

public class Simulation 
{
	public class Day
	{
		
		// 0 - Rainy
		// 1 - Cloudy
		// 2 - Sunny
		
		public final int weather;
		public Market markt;
		
		
		public Day()
		{
			this.weather = (int)Math.random()*4;
		}
		
	}
	
	
	private int currentDay; 
	private int maxDays;
	
	public Kiosk kiosk; 
	
	public Simulation(Kiosk kiosk)
	{
		this.kiosk = kiosk;
		
		this.currentDay = 1;
		this.maxDays = 21;
		
	}
	
	
	public int getCurrentDay()
	{
		return this.currentDay;
	}
	
	
	public int getMaxDays()
	{
		return this.maxDays;
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
		}
	}
}
