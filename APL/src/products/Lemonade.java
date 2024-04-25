package products;

public class Lemonade extends Product
{	
	public Lemonade()
	{
		this.expiresDays = 3;
		this.size = 2;
		
		this.basePrice = 1.25;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	
	public Lemonade(double buyPrice)
	{
		this.expiresDays = 3;
		this.size = 2;
		
		this.buyPrice = buyPrice;
		
		this.basePrice = 1.25;
		this.basePriceVariation = 0.24;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
}
