package products;

public class Fries extends Product 
{
	public Fries()
	{
		this.expiresDays = 4;
		this.size = 5;
		
		this.basePrice = 2.50;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	
	public Fries(double buyPrice)
	{
		this.expiresDays = 4;
		this.size = 5;
		
		this.buyPrice = buyPrice;

		
		this.basePrice = 2.50;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
}
