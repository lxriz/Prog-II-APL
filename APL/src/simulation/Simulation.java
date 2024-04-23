package simulation;

public class Simulation 
{
	private int currentDay; 
	private int maxDays;
	
	Kiosk kiosk; 
	
	
	
	
	
	
	
	
	
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
		if(endDays())
		{
			this.currentDay += 1;
		}
	}
}
