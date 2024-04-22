package customers;

public class Customer 
{
	public final String name;
	
	// Older people are not as likely to spend higher prices
	public final int age;
	
	private float money;
	
	
	
	
	public Customer(String name, int age, float money)
	{
		this.name = name;
		this.age = age;
		this.money = money;
	}
	
	
	
	// Customer buys a product
	public void buy(float price)
	{
		this.money -= price;
	}
	
}
