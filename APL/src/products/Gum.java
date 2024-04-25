package products;

public class Gum extends Product
{
	public Gum()
	{
		this.expiresDays = 7;
		this.size = 1;
		
		this.basePrice = 0.40;
		this.basePriceVariation = 0.25;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	
	public Gum(double buyPrice)
	{
		this.expiresDays = 7;
		this.size = 1;
		
		this.buyPrice = buyPrice;
		
		this.basePrice = 0.40;
		this.basePriceVariation = 0.25;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}

}
