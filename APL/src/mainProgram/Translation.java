package mainProgram;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public final class Translation 
{
	private static HashMap<String, String> translation = new HashMap<>();
	
	// ACHTUNG NOCH NICHT DYNAMISCH !!!
	private static final String path = "/Users/loris/git/repository/APLII/APL/src/mainProgram/translation.json";
	
	
	private void readFile(String lang)
	{
		try 
		{
			FileReader reader = new FileReader(path);
			JSONParser parser = new JSONParser(); 
			JSONObject object = (JSONObject)(parser.parse(reader));
			
            JSONObject o = (JSONObject)(object.get("PROG_NAME"));
            System.out.println(o.get(lang));
            
            
	    } 
	 	catch (IOException | ParseException e) 
	 	{
            e.printStackTrace();
        }
		
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
