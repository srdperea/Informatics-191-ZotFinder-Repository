package inf191.commands.coordinates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
		public void ParserText(List<List<String>> arrayCoordList, File file) {
		
		BufferedReader reader = null;
	
		try 
		{
		    reader = new BufferedReader(new FileReader(file));
		    String text = reader.readLine();
		    String text2 = null;
		    Scanner scanInputFile = new Scanner(text).useDelimiter(",");
		    while ((text = reader.readLine()) != null) 
		    {
		    	List<String> row = new ArrayList<String>();
		    	scanInputFile = new Scanner(text).useDelimiter(",");
		    	for(int i= 0; i<=6; i++)
		    	{
		    		text2 = scanInputFile.next();
	            	row.add(text2);
		    	}
		       	arrayCoordList.add(row);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    	
	    	}
		}
	}
}
