/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3ga;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FCI User
 */
public class Assignment3GA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        FuzzyAlgorithm fa=new FuzzyAlgorithm();
        fa.attributesNumber=sc.nextInt();
        for (int i = 0; i < fa.attributesNumber; i++) {
            fa.attributes.add(new Attribute());
            fa.attributes.get(i).attributeName=sc.next();
            
            fa.attributes.get(i).attributeValue=sc.nextDouble();
            
            fa.attributes.get(i).shapesNumber=sc.nextInt();
            for (int j = 0; j < fa.attributes.get(i).shapesNumber; j++) {
                String sh = sc.next() ;
                fa.attributes.get(i).shapeName.add(sh);
                fa.setNames.add(sh) ; 
                String shapType=sc.next();
                fa.attributes.get(i).shapeType.add(shapType);
                fa.attributes.get(i).shapePoints.add(new ArrayList<Double>());
                for (int k = 0; k < (shapType.equals("triangle")?3:4); k++) {
                    fa.attributes.get(i).shapePoints.get(j).add(sc.nextDouble());
                }
            }
        }
        //output Atribute
        fa.outputAttribute.attributeName=sc.next();
        fa.outputAttribute.attributeValue=sc.nextDouble();
        fa.outputAttribute.shapesNumber=sc.nextInt();
        for (int j = 0; j < fa.outputAttribute.shapesNumber; j++) {
            fa.outputAttribute.shapeName.add(sc.next());
            String shapType=sc.next();
            fa.outputAttribute.shapeType.add(shapType);
            fa.outputAttribute.shapePoints.add(new ArrayList<Double>());
            for (int k = 0; k < (shapType.equals("triangle")?3:4); k++) {
                fa.outputAttribute.shapePoints.get(k).add(sc.nextDouble());
            }
        }
        //Rules
        fa.rulesNumber=sc.nextInt();
        for (int i = 0; i < fa.rulesNumber; i++) {
            fa.rules.add(sc.nextLine());
        }
        fa.excute();
    }
    
}
