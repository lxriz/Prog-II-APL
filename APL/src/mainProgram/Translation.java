package mainProgram;

import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;	


public final class Translation 
{
	private static HashMap<String, String> translation = new HashMap<>();
	
	
	
	private void readFile(String lang)
	{
		
	}
	
	
	public void selectLanguage(String lang)
	{
		switch(lang)
		{
			case "DE":
				readFile("DE");
				break;
				
			case "ENG":
				readFile("ENG");
				break;
			
			default:
				readFile("ENG");
				break;
		}
	}
	
	
	public String getText(String input)
	{
		if(translation.containsKey(input))
		{
			return translation.get(input);
		}
		
		return "_ERROR_";
	}
	
}
