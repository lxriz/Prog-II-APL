package simulation;

import products.Product;

public class Kiosk 
{
	private float cash;
	
	public final String ownerName;
	
	private int currentStorageSize;
	private final int maxStorageSize;
	private Product[] storage;
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;
		
		// (Possible difficulty levels implementation)
		this.cash = 30;
		this.maxStorageSize = 30;
		this.storage = new Product[this.maxStorageSize];		
	}
	
	
}
