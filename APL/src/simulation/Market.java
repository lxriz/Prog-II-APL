package simulation;

import java.util.Random;

public class Market 
{
	
	// Resulting prices
	public final double cigarettesPrice;
	public final double friesPrice;
	public final double gumPrice;
	public final double iceCreamPrice;
	public final double lemonadePrice;
	public final double newspaperPrice;
	
	
	// Used as an anchor for price calculations
	// Prices in euro
	public final double cigarettesBasePrice = 6.50;
	public final double friesBasePrice = 2.50;
	public final double gumBasePrice = 0.30;
	public final double iceCreamBasePrice = 1.00;
	public final double lemonadeBasePrice = 0.85;
	public final double newspaperBasePrice = 0.60;
	
	
	// Used for random Price Variation on base price
	// Max percent of variation on base price
	public final double cigarettesBasePriceVariation = 0.08;
	public final double friesBasePriceVariation = 0.18;
	public final double gumBasePriceVariation = 0.30;
	public final double iceCreamBasePriceVariation = 0.12;
	public final double lemonadeBasePriceVariation = 0.24;
	public final double newspaperBasePriceVariation = 0.40;
	
	
	// Saves the weather price variation  
	public final double[] cigarettesPriceWeather = {0.2, 0, -0.2};
	public final double[] friesPriceWeather = {0.2, 0, -0.2};
	public final double[] gumPriceWeather = {0.2, 0, -0.2};
	public final double[] iceCreamPriceWeather = {0.2, 0, -0.2};
	public final double[] lemonadePriceWeather = {0.2, 0, -0.2};
	public final double[] newspaperPriceWeather = {0.2, 0, -0.2};

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
		
		cigarettesPrice = calculatePriceVariation(calculatePriceWeather(cigarettesBasePrice, cigarettesPriceWeather[weather]), cigarettesBasePriceVariation);
		friesPrice = calculatePriceVariation(calculatePriceWeather(friesBasePrice, friesPriceWeather[weather]), friesBasePriceVariation);
		gumPrice = calculatePriceVariation(calculatePriceWeather(gumBasePrice, gumPriceWeather[weather]), gumBasePriceVariation);
		iceCreamPrice = calculatePriceVariation(calculatePriceWeather(iceCreamBasePrice, iceCreamPriceWeather[weather]), iceCreamBasePriceVariation);
		lemonadePrice = calculatePriceVariation(calculatePriceWeather(lemonadeBasePrice, lemonadePriceWeather[weather]), lemonadeBasePriceVariation);
		newspaperPrice = calculatePriceVariation(calculatePriceWeather(newspaperBasePrice, newspaperPriceWeather[weather]), newspaperBasePriceVariation);
	}
	
	public double[] getPrices()
	{
		double[] prices = {cigarettesPrice, friesPrice, gumPrice, iceCreamPrice, lemonadePrice, newspaperPrice};
		return prices;
	}
	
}
