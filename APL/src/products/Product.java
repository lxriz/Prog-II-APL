package products;

public abstract class Product 
{
	// Saves the days until the product expires
	// expiresDays > 0, good to sell
	// expiresDays == 0, product has to be thrown away
	// expiresDays < 0, the product never expires
	int expiresDays; 
	
		
	// Saves the size of the product for storage
	// The value is simplified with no real measurement
	int size; 
	
	
	
	// WETTER VARIABLEN
	
	
	
	public boolean age()
	{
		this.expiresDays -= 1;
		if(this.expiresDays == 0)
		{
			return true;
		}
		
		return false;
	}
}
