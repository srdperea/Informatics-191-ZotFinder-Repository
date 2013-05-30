package inf191.commands.coordinates;

public class Distance 
{
	public double calculateDistance(String coordX1, String coordY1, String coordX2, String coordY2)
	{
		double x1 = Float.parseFloat(coordX1);
		double y1 = Float.parseFloat(coordY1);
		double x2 = Float.parseFloat(coordX2);
		double y2 = Float.parseFloat(coordY2);
		
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
}
/*
//distance = square root of [(x2-x1)squared + (y2-y1)squared]
static double distance(double x1, double y1, double x2, double y2)
{
    return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
}
*/