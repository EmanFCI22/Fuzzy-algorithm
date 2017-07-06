/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3ga;

import java.util.ArrayList;

/**
 *
 * @author FCI User
 */
public class Attribute {
    public String attributeName;
    public Double attributeValue;
    public int shapesNumber;
    public ArrayList<String> shapeName;
    public ArrayList<String> shapeType;
    public ArrayList<ArrayList<Double> > shapePoints;

    Attribute(){
        shapeName=new ArrayList<String>();
        shapeType=new ArrayList<String>();
        shapePoints=new ArrayList<ArrayList< Double>>();
        
    }
    
}
