package simulation;

import java.util.Random;
import products.*;

public class Market 
{
	
	// Resulting prices
	public final double cigarettesPrice;
	public final double friesPrice;
	public final double gumPrice;
	public final double iceCreamPrice;
	public final double lemonadePrice;
	public final double newspaperPrice;
	
	
	// Objects
	public Cigarettes cigarettes;
	public Fries fries;
	public Gum gum;
	public IceCream iceCream;
	public Lemonade lemonade;
	public Newspaper newspaper;
	
	

	private Random r = new Random();

	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

	
	private double calculatePriceVariation(double base, double variation)
	{
		return base + base * (variation * ((r.nextDouble()*2)-1));
	}
	
	
	private double calculatePriceWeather(double base, double variation)
	{
		return base + base * variation; 
	}
	
	
	public Market(int weather)
	{
		// 0 - Rainy
		// 1 - Cloudy, no impact on base prices
		// 2 - Sunny 
		
		cigarettes = new Cigarettes();
		fries = new Fries();
		gum = new Gum();
		iceCream = new IceCream();
		lemonade = new Lemonade();
		newspaper = new Newspaper();
		
		cigarettesPrice = calculatePriceVariation(calculatePriceWeather(cigarettes.basePrice, cigarettes.priceWeather[weather]), cigarettes.basePriceVariation);
		friesPrice = calculatePriceVariation(calculatePriceWeather(fries.basePrice, fries.priceWeather[weather]), fries.basePriceVariation);
		gumPrice = calculatePriceVariation(calculatePriceWeather(gum.basePrice, gum.priceWeather[weather]), gum.basePriceVariation);
		iceCreamPrice = calculatePriceVariation(calculatePriceWeather(iceCream.basePrice, iceCream.priceWeather[weather]), iceCream.basePriceVariation);
		lemonadePrice = calculatePriceVariation(calculatePriceWeather(lemonade.basePrice, lemonade.priceWeather[weather]), lemonade.basePriceVariation);
		newspaperPrice = calculatePriceVariation(calculatePriceWeather(newspaper.basePrice, newspaper.priceWeather[weather]), newspaper.basePriceVariation);
	}
	
	public double[] getPrices()
	{
		double[] prices = {cigarettesPrice, friesPrice, gumPrice, iceCreamPrice, lemonadePrice, newspaperPrice};
		return prices;
	}
	
}
