package mainProgram;

public interface Helpers 
{
	// Utility methods
	
	static int lineLength = 70;
	
	public default void PrintLine()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	public default void PrintLineDashed()
	{
		for(int i = 0; i < lineLength/2; i++)
		{
			System.out.print("- ");
		}
		System.out.println();
	}
	
	public default void PrintLineDotted()
	{
		for(int i = 0; i < lineLength; i++)
		{
			System.out.print(".");
		}
		System.out.println();
	}
	
	public default void PrintInput(Translation translation)
	{
		PrintLine();
		System.out.println(translation.getText("INPUT"));
		System.out.print("> ");
	}
	
	public default void PrintInvalidInput(Translation translation)
	{
		PrintLineDotted();
		System.out.println(" " + translation.getText("INVALID_INPUT"));
		PrintLineDotted();
		
		try
		{
			Thread.sleep(800);
		}
		catch(Exception e)
		{
			
		}
	}

	public default void PrintClearConsole()
	{
		for(int i = 0; i < 25; i++)
		{
			System.out.println();
		}
	}
}
