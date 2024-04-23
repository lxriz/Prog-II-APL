package simulation;

import products.Product;

public class Kiosk 
{
	private float cash;
	
	public final String ownerName;
	
	private final int storageSize;
	private Product[] storage;
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;
		
		// (Possible difficulty levels implementation)
		this.cash = 30;
		this.storageSize = 30;
		this.storage = new Product[this.storageSize];		
	}
	
	
}
