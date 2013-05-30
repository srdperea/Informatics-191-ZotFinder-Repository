package inf191.commands.coordinates;

import java.util.List;


public class BuildingLocator
{
	public String getXCoord(List<List<String>> arrayCoordList, String bName)
	{
		String error = "error"; 
		for (int i = 0; i<arrayCoordList.size(); i++)
		{
			for (int j = 0; j<arrayCoordList.get(i).size(); j++)
			{
				if (bName.equals(arrayCoordList.get(i).get(j)))
				{
					return arrayCoordList.get(i).get(j+4); 
				}
			}
		}
		return error;
	}
	public String getYCoord(List<List<String>> arrayCoordList, String bName)
	{
		String error = "error"; 
		for (int i = 0; i<arrayCoordList.size(); i++)
		{
			for (int j = 0; j<arrayCoordList.get(i).size(); j++)
			{
				if (bName.equals(arrayCoordList.get(i).get(j)))
				{
					return arrayCoordList.get(i).get(j+5); 
				}
			}
		}
		return error;
	}
}
