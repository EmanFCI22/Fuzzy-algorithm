/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3ga;

import static java.lang.Double.max;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeMath.min;

/**
 *
 * @author FCI User
 */
public class FuzzyAlgorithm {
    public int attributesNumber;
    public ArrayList<Attribute> attributes;
    public Attribute outputAttribute;
    public int rulesNumber;
    public ArrayList<String> setNames ;
    public ArrayList<String> rules;

    public FuzzyAlgorithm() {
        attributes=new ArrayList<>();
        outputAttribute=new Attribute();
        rules=new ArrayList<>();
        setNames = new ArrayList<String>();
    }
    public void excute(){
        ArrayList<Double> intersections=null;
        for (int i = 0; i < attributes.size(); i++) {
            intersections=Fazification.Fazi(attributes.get(i).attributeValue,attributes.get(i) );
        }
        
        ArrayList<String> weights=inferenceRules(intersections);
        double Cx=Defuzification.defuzification(weights, outputAttribute.shapeName, outputAttribute.shapePoints);
        System.out.println("Fazification"+intersections.toString());
        System.out.println("inference"+weights.toString());
        System.out.println("defuzification"+Cx);
    }
    
    public ArrayList<String> inferenceRules(ArrayList<Double> memberShipValues){
        
        double lastValue ;// the attribute which we need to know its membership in specific set 
        ArrayList<String> weights = new ArrayList<String>();
        for(int i = 0 ; i < rules.size() ; ++i)
        {
            
            String[] splited = rules.get(i).split(" ");
            lastValue = memberShipValues.get(setNames.indexOf(splited[3])) ;
            for(int j = 4 ; j < splited.length ; )
            {
                if(splited[j].equals("then"))
                {
                // get the value of the set membership
                    weights.add(String.valueOf(lastValue) + " " + splited[j+3]) ;
                    
                }
                else if(splited[j].equals("AND"))
                {
                    
                   lastValue = (double) min(memberShipValues.get(setNames.indexOf(splited[j+3])), lastValue) ;
                       
                        
                }
                    
          
                
                else{
                        lastValue = (double) max(memberShipValues.get(setNames.indexOf(splited[j+3])), lastValue) ;

                }
                
                j += 4 ;
            }
        }
        
        return weights ;
        
    }
    
    
}
