/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3ga;

import java.util.ArrayList;

/**
 *
 * @author rawan
 */
public class Fazification 
{
    public static double lineEquation (double m,double x0,double y0,double x)
    {
        double y=(m*(x-x0))+y0;
        return y;
    }
    
    public static double slope(double y1,double y0,double x1,double x0)
    {
       // if(x1-x0==0) this will be infinity   
        return (double)(y1-y0)/(double)(x1-x0);
    }
    public static boolean slopeExist(double y1,double y0,double x1,double x0)
    {
       return (x1-x0!=0) ;
    }
    
    public static ArrayList<Double> Fazi(double value,Attribute attr)
    {
        
        double m;//slope
        Double intersection;
        ArrayList<Double>intersections=new ArrayList<Double>();
        for (int i=0;i<attr.shapesNumber;i++)
        {
            ArrayList<Double>shapePoints=attr.shapePoints.get(i);
            if(attr.shapeType.get(i).equals("triangle"))
            {
                if(value >=shapePoints.get(0)&&value<=shapePoints.get(1))
                {
                    if(slopeExist(1,0,shapePoints.get(1),shapePoints.get(0)))
                    {
                        m=slope(1,0,shapePoints.get(1),shapePoints.get(0));
                        intersection=lineEquation(m,shapePoints.get(0) ,
                            0, value);
                        intersections.add(intersection);
                    }
                   
                    
                }
                else if(value >=shapePoints.get(1)&&value<=shapePoints.get(2))
                {
                    if(slopeExist(0,1,shapePoints.get(2),shapePoints.get(1)))
                    {
                        m=slope(0,1,shapePoints.get(2),shapePoints.get(1));
                        intersection=lineEquation(m,shapePoints.get(1) ,
                                1, value);
                        intersections.add(intersection);
                        
                    }
                }
                else 
                    intersections.add(0.0);
                    
               
            }
            else 
            {
                 if(value >=shapePoints.get(0)&&value<=shapePoints.get(1))
                {
                    if(slopeExist(1,0,shapePoints.get(1),shapePoints.get(0)))
                    {
                        m=slope(1,0,shapePoints.get(1),shapePoints.get(0));
                        intersection=lineEquation(m,shapePoints.get(0) ,
                            0, value);
                        intersections.add(intersection);
                    }
                   
                    
                }
                else if(value >=shapePoints.get(1)&&value<=shapePoints.get(2))
                {
                    if(slopeExist(1,1,shapePoints.get(2),shapePoints.get(1)))
                    {
                        m=slope(1,1,shapePoints.get(2),shapePoints.get(1));
                        intersection=lineEquation(m,shapePoints.get(1) ,
                                1, value);
                        intersections.add(intersection);
                        
                    }
                }
                else if(value>=shapePoints.get(2)&&value<=shapePoints.get(3))
                {
                    if(slopeExist(0,1,shapePoints.get(3),shapePoints.get(2)))
                    {
                        m=slope(0,1,shapePoints.get(3),shapePoints.get(2));
                        intersection=lineEquation(m,shapePoints.get(2) ,
                                1, value);
                        intersections.add(intersection);
                        
                    }
                }
                else 
                   intersections.add(0.0);
                
            }

        
        }
        printIntersections(attr,intersections);
       return intersections; 
    }


    public static void printIntersections(Attribute attr, 
            ArrayList<Double> intersections) 
    {
        for(int i=0;i<attr.shapeName.size();i++)
        {
            System.out.print(attr.shapeName.get(i)+" "+intersections.get(i));
        }
    }
    
}
