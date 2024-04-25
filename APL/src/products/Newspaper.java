package products;

public class Newspaper extends Product 
{	
	public Newspaper()
	{
		this.expiresDays = 1;
		this.size = 2;
		
		this.basePrice = 0.90;
		this.basePriceVariation = 0.40;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	public Newspaper(double buyPrice)
	{
		this.expiresDays = 1;
		this.size = 2;
		this.buyPrice = buyPrice;
		
		this.basePrice = 0.90;
		this.basePriceVariation = 0.40;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
}
