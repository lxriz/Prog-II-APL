package products;

public class IceCream extends Product
{
	public IceCream()
	{
		this.expiresDays = 2;
		this.size = 3;
		
		this.basePrice = 1.00;
		this.basePriceVariation = 0.12;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	
	public IceCream(double buyPrice)
	{
		this.expiresDays = 2;
		this.size = 3;
		
		this.buyPrice = buyPrice;
		
		this.basePrice = 1.00;
		this.basePriceVariation = 0.12;
		this.priceWeather = new double[]{0.2, 0, -0.2};
	}
	

}
