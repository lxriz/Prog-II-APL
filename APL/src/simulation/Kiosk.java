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
	
	public final double startCash = 25;

	
	private double[] prices = new double[6];
	
	
	
	public Kiosk(String ownerName)
	{
		this.ownerName = ownerName;		
		this.cash = startCash;
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
		index --;
		if(index >= 0 && index < prices.length)
		{
			return prices[index];
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
	
	
	public double getCash()
	{
		return this.cash;
	}
	
	
	public int countProduct(String name)
	{
		int sum = 0;
		
		for(Product product : storage)
		{
			if(name == product.name)
			{
				sum++;
			}
		}
		
		return sum;
	}
	
	
	public boolean canStore(int toStore)
	{
		if(this.usedStorage + toStore <= this.storageSize && this.usedStorage + toStore >= 0)
		{
			return true;
		}
		
		return false;
	}
	
	
	private boolean setStorageSize(int toStore)
	{
		if(canStore(toStore))
		{
			usedStorage += toStore;
			return true;
		}	
		
		return false;
	}
	
	
	public int getUsedStorageSize()
	{
		return this.usedStorage;
	}
	
	
	public boolean addStorage(Product product)
	{
		if(setStorageSize(product.size))
		{
			storage.add(product);
			return true;
		}
		
		return false;
	}
	
	
	public boolean removeFromStorage(String name)
	{
		for(Product product : storage)
		{
			if(product.name == name)
			{
				if(setStorageSize(-product.size))
				{
					storage.remove(product);
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	public void ageStorage()
	{
		for(int i = 0; i<storage.size(); i++)
		{
			storage.get(i).expiresDays -= 1;
			
			if(storage.get(i).expiresDays == 0)
			{
				setStorageSize(-storage.get(i).size);
				storage.remove(storage.get(i));
				i--;
			}
		}
	}
}
