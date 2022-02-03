import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
* Ellipsoid List App Driver.
*@author Samuel Adams
*@version 2/14/2020
*Project 05
*/

public class EllipsoidListApp {

/**
* Main method.
*@param args not used
*@throws FileNotFoundException used
*/
   public static void main(String []args) throws FileNotFoundException
   {
      ArrayList<Ellipsoid> eList = new ArrayList<Ellipsoid>();
      Scanner in = new Scanner(System.in);
      System.out.println("Enter file name: ");
      String fileN = in.nextLine();
      Scanner sFile = new Scanner(new File(fileN));   
      String ellipsoidListN = sFile.nextLine();
      
      if (sFile.hasNext()) {  
         while (sFile.hasNext()) {
            if (sFile.hasNextLine()) {
               String label = sFile.nextLine();
               if (sFile.hasNextDouble()) {
                  double a = sFile.nextDouble();
                  double b = sFile.nextDouble();
                  double c = sFile.nextDouble();
                  Ellipsoid e = new Ellipsoid(label, a, b, c);
                  eList.add(e);
               }    
            }
         }
      } 
      sFile.close();
      EllipsoidList ellipsoidlist = new EllipsoidList(ellipsoidListN, eList);
      System.out.println("\n" + ellipsoidlist.getName());
      System.out.println(ellipsoidlist.toString());
      System.out.println("\n" + ellipsoidlist.summaryInfo());
   }


}