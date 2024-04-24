package simulation;

public class Simulation 
{
	private int currentDay; 
	private int maxDays;
	
	public Kiosk kiosk; 
	public Market market;
	
	public Simulation(Kiosk kiosk)
	{
		this.kiosk = kiosk;
		
		this.currentDay = 1;
		this.maxDays = 21;
		// MARKET EINFÜGEN
		
	}
	
	public String getKioskUsername()
	{
		return this.kiosk.ownerName;
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
