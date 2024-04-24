package simulation;

import products.Product;

public class Kiosk 
{
	// in cent
	private double cash;
	
	public final String ownerName;
	
	private int usedStorage;
	public final int storageSize;
	private Product[] storage;
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;
		
		// (Possible difficulty levels implementation)
		
		this.cash = 30.00;
		this.usedStorage = 0;
		this.storageSize = 30;
		this.storage = new Product[this.storageSize];		
	}
	
	public boolean setCash(double change)
	{
		if(this.cash-change >= 0)
		{
			this.cash += change;
			return true;
		}
		
		return false;
	}
	
	public double getCash()
	{
		return this.cash;
	}
	
	public int getUsedStorage()
	{
		return this.usedStorage;
	}
	
}
