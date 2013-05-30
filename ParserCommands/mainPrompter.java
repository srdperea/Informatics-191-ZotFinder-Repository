import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java1 
{ 
	public static void main(String[] args)
    {       
			distance distance = new distance();
			locateBuilding locateBuilding = new locateBuilding();
       		List<List<String>> arrayCoordList = new ArrayList<List<String>>();
			File file = new File("CoordinateTextFile");
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
			
			System.out.println("Please Enter a Command. Type help for options");
			Scanner scanConsoleInput = new Scanner(System.in);
			String command = scanConsoleInput.nextLine();
			String consoleInput = null;
			String consoleInput2 = null;
			String xcoord = null;
			String ycoord = null;
			String xcoord2 = null;
			String ycoord2 = null;
			boolean endInput = false;			
			do
			{
				switch (command)
				{
					case "locate":
						System.out.println("Please enter building name");
						consoleInput = scanConsoleInput.nextLine();
						xcoord = locateBuilding.getXCoord(arrayCoordList, consoleInput);
						ycoord = locateBuilding.getYCoord(arrayCoordList, consoleInput);
						if (xcoord.equals("error") || ycoord.equals("error"))
						{
							System.out.println("Building Not Found");
						}
						else
							System.out.println("Coordinates of " + consoleInput + "is " + xcoord + "," + ycoord);
						System.out.println('\n' + "Please Enter a Command. Type Help for options");
						command = scanConsoleInput.nextLine();
						
					case "distance":
						System.out.println("Enter the first building name");
						consoleInput = scanConsoleInput.nextLine();
						System.out.println("Enter the second building name");
						consoleInput2 = scanConsoleInput.nextLine();
						xcoord = locateBuilding.getXCoord(arrayCoordList, consoleInput);
						ycoord = locateBuilding.getYCoord(arrayCoordList, consoleInput);
						xcoord2 = locateBuilding.getXCoord(arrayCoordList, consoleInput2);
						ycoord2 = locateBuilding.getYCoord(arrayCoordList, consoleInput2);
						if (xcoord.equals("error") || ycoord.equals("error") || 
								xcoord2.equals("error") || ycoord2.equals("error"))
						{
							System.out.println("Building Not Found");
						}
						else
							System.out.println("Distance from " + consoleInput + "to" + 
									consoleInput2 + "is " +distance.calculateDistance(xcoord, ycoord, xcoord2, ycoord2));
						System.out.println('\n'+ "Please Enter a Command. Type Help for options");
						command = scanConsoleInput.nextLine();
						
					case "help":
						System.out.println("locate - locates a building and returns coordinates" + '\n');
						System.out.println("distance - determines distance between two given buildings" + '\n');
						System.out.println("exit - exits the system" + '\n');
						command = scanConsoleInput.nextLine();
					case "exit":
						endInput = true;
					default:
						System.out.println("Could not recognize command. Please try again.");
						command = scanConsoleInput.nextLine();
				}
			} while (!endInput);
		}
	}
