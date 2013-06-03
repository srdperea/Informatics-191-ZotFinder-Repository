package inf191.commands.coordinates;

public class Distance 
{
	public static double calculateDistance(String coordX1, String coordY1, String coordX2, String coordY2)
	{
		double x1 = Double.parseDouble(coordX1);
		double y1 = Double.parseDouble(coordY1);
		double x2 = Double.parseDouble(coordX2);
		double y2 = Double.parseDouble(coordY2);
		
		double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		return distance;
	}
}
