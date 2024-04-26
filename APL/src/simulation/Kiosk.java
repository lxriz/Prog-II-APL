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
	
	private double[] prices = new double[6];
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;		
		this.cash = 30.00;
		this.usedStorage = 0;
		this.storageSize = 50;
		this.storage = new ArrayList<>();		
	}
	
	
	public boolean setPrice(int index, double newPrice)
	{
		index--;
		if(newPrice >= 0 && index >= 0 && index < prices.length)
		{
			prices[index] = newPrice;
			return true;
		}
		
		return false;
	}
	
	
	public double getPrice(int index)
	{
		if(index-1 >= 0 && index-1 < prices.length)
		{
			return prices[index-1];
		}
		
		return -1;
	}
	
	
	
	public boolean canPay(double change)
	{
		if(this.cash+change >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	public void setCash(double change)
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
	
	
	public void setStorage(int toStore)
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
