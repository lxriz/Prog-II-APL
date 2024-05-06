package mainProgram;

public class StartScreen implements Menu
{
	// Prints a short screen when the game starts
	//
	
	private void print(Translation translation)
	{
		
		PrintLine();
		for(int i = 0; i < 20; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		
		System.out.println(">   " + translation.getText("PROG_NAME") + "  <");
		
		System.out.println();
		System.out.println();

		System.out.println(translation.getText("START_SCREEN"));
		
		for(int i = 0; i < 20; i++)
		{
			System.out.print("*");
		}
		System.out.println();
		
		PrintLine();
		
		
		try
		{
			Thread.sleep(2100);
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	@Override
	public void main(Translation translation)
	{
		print(translation);
	}
	
}
