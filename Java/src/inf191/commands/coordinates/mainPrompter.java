package inf191.commands.coordinates;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPrompter
{ 
	public static void main(String[] args)
    {       
			Distance distance = new Distance();
			BuildingLocator locateBuilding = new BuildingLocator();
       		List<List<String>> arrayCoordList = new ArrayList<List<String>>();
			Parser parser = new Parser();
       		File file = new File("CoordinateTextFile");
       		
			parser.ParserText(arrayCoordList, file);
			System.out.println("Please Enter a Command ('LOCATE', 'DISTANCE', 'EXIT'): ");
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
					case "LOCATE":
						System.out.println("Please enter building name");
						consoleInput = scanConsoleInput.nextLine();
						xcoord = locateBuilding.getXCoord(arrayCoordList, consoleInput);
						ycoord = locateBuilding.getYCoord(arrayCoordList, consoleInput);
						if (xcoord.equals("error") || ycoord.equals("error"))
						{
							System.out.println("Building Not Found");
						}
						else
							System.out.println("Coordinates of " + consoleInput + " is: " + xcoord + "," + ycoord);
						System.out.println('\n' + "Please Enter a Command ('LOCATE', 'DISTANCE', 'EXIT'): ");
						command = scanConsoleInput.nextLine();
						
					case "DISTANCE":
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
							System.out.println("Distance from " + consoleInput + " to " + 
									consoleInput2 + " is: " +distance.calculateDistance(xcoord, ycoord, xcoord2, ycoord2));
						System.out.println('\n'+ "Please Enter a Command ('LOCATE', 'DISTANCE', 'EXIT'): ");
						command = scanConsoleInput.nextLine();
						
					case "EXIT":
						endInput = true;
						break;
					default:
						System.out.println("Could not recognize command. Please try again.");
						command = scanConsoleInput.nextLine();

				}
			} while (!endInput);
		}
	}
