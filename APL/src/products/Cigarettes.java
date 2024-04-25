package products;

public class Cigarettes extends Product
{
	public Cigarettes()
	{
		this.expiresDays = 7;
		this.size = 4;
		
		this.basePrice = 6.50;
		this.basePriceVariation = 0.08;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	
	public Cigarettes(double buyPrice)
	{
		this.expiresDays = 7;
		this.size = 4;
		
		this.buyPrice = buyPrice;
		
		this.basePrice = 6.50;
		this.basePriceVariation = 0.08;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
}
