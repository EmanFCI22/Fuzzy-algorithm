package assignment3ga;

import java.util.ArrayList;

public class Defuzification {
	public static double defuzification(ArrayList<String > weights,ArrayList<String> shapeNames ,ArrayList<ArrayList<Double> > numbers)
        {
            double output=0.0;
            double sumWeights=0.0;
            for(int i=0;i<weights.size();i++)
            {
                String split [] =weights.get(i).split(" ");
                int index=-1;
                for(int j=0;j<shapeNames.size();j++)
                {
                    if(split[1].equals(shapeNames.get(j)))
                    {
                        index=j;
                        break;
                    }
                }
                double center=0.0;
                if (index !=-1)
                    center=centroid(numbers.get(index));
                output +=(Integer.valueOf(split[0])*center);
               sumWeights+=Integer.valueOf(split[0]);
            }
            output/=sumWeights;
            return output;
        
        }
	public static double getArea(ArrayList<Double> polygon)
	{
	    double area=0.0;
	    int y1=0;
	    int y2=1;
		for(int i=0;i<(polygon.size()-1);i++)
		{
			if(polygon.size()==4 && i==1)
			{
				y1=1;
				y2=1;
			}
			area+=((polygon.get(i)*y2)-(polygon.get(i+1)*y1));
			y1=y2;
			y2=0;
		}
		area/=2;
		return area;
	}
	
	public static double centroid (ArrayList<Double> polygon)
	{
		double Cx=0.0;
		 int y1=0;
		    int y2=1;
			for(int i=0;i<(polygon.size()-1);i++)
			{
				if(polygon.size()==4 && i==1)
				{
					y1=1;
					y2=1;
				}
				Cx+= ((polygon.get(i) + polygon.get(i+1))*((polygon.get(i)*y2)-(polygon.get(i+1)*y1)));
				y1=y2;
				y2=0;
			}
			Cx/=(6*getArea(polygon));
		return Cx;
	}
}
