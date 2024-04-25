package simulation;

import products.Product;
import java.util.ArrayList;
import java.util.List;

public class Kiosk 
{
	// in cent
	private double cash;
	
	public final String ownerName;
	
	private int usedStorage;
	public final int storageSize;
	public List<Product> storage;
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;
		
		// (Possible difficulty levels implementation)
		
		this.cash = 30.00;
		this.usedStorage = 0;
		this.storageSize = 30;
		this.storage = new ArrayList<>();		
	}
	
	
	public boolean canPay(double change)
	{
		if(this.cash+change >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	public void changeCash(double change)
	{
		if(canPay(cash))
		{
			cash += change;
		}
	}
	
	
	public boolean canStore(int toStore)
	{
		if(this.usedStorage + toStore <= this.storageSize && this.usedStorage + toStore >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	public void changeStorage(int toStore)
	{
		if(canStore(toStore))
		{
			usedStorage += toStore;
		}
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
