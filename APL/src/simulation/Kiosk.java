package simulation;

import products.Product;

public class Kiosk 
{
	// in cent
	private float cash;
	
	public final String ownerName;
	
	private int usedStorage;
	public final int storageSize;
	private Product[] storage;
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;
		
		// (Possible difficulty levels implementation)
		
		this.cash = 3000;
		this.usedStorage = 0;
		this.storageSize = 30;
		this.storage = new Product[this.storageSize];		
	}
	
	public float getCash()
	{
		return this.cash;
	}
	
	public int getUsedStorage()
	{
		return this.usedStorage;
	}
	
}
