import java.util.ArrayList;
import java.text.DecimalFormat;

/**
* Ellipsoid List Driver.
*@author Samuel Adams
*@version 2/14/2020
*Project 05
*/
public class EllipsoidList {

   private  String listName;
   private  ArrayList<Ellipsoid> eList;
   
   /**
   * EllipsoidList constructor. 
   * @param listNameIn Input Name
   * @param eListIn array list
   */
   public EllipsoidList(String listNameIn, ArrayList<Ellipsoid> eListIn) {
      listName = listNameIn;
      eList = eListIn;
   }
   /** getName method.
   * @return Name
   *
   */
   public String getName() {
      return listName;
   }
   /**
   *Number of Ellipsoids.
   *
   *@return eList.size()
   */
   public int numberOfEllipsoids() {
      return eList.size();
   }
   /**
    *the total volume of the ellipsoid.
    *@return totalVol
    */
   public double totalVolume() {
      int index = 0;
      double totalVol = 0;
      while (index < eList.size()) {
         totalVol += eList.get(index).volume();
         index++;
         
      }
      return totalVol;
   }
    /**
    *The average volume of the ellipsoids.
    *@return avgVol value.
    *
    */
   public double averageVolume() {
      int index = 0;
      double avgVol = 0;
      if (eList.size() != 0) {
         while (index < eList.size()) {
            avgVol += eList.get(index).volume();
            index++;
         
         }
         avgVol = avgVol / eList.size();
      }
      return avgVol;
   
   
   }
    /**
    *The total surface area.
    *@return totalSur total surface area
    */
   public double totalSurfaceArea() {
      int index = 0;
      double totalSur = 0;
      while (index < eList.size()) {
         totalSur += eList.get(index).surfaceArea();
         index++;
      }
      return totalSur;
   }
   /**
    *The average of the surface areas.
    *@return avgSur is the average surface area
    */
   public double averageSurfaceArea() {
      int index = 0;
      double avgSur = 0;
      if (eList.size() != 0) {
         while (index < eList.size()) {
            avgSur += eList.get(index).surfaceArea();
            index++;
         }
         avgSur = avgSur / eList.size();
      }
      return avgSur;
   }
    /**
    *The to string method.
    *@return output the writing
    */
   public String toString() {
      int index = 0;
      String output = "";
      while (index < eList.size()) {
         output += "\n" + eList.get(index).toString();
         index++;
      }
      return output;
   }
    /**
    *The summary info.
    *@return output everything.
    */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      output =  "----- Summary for " + getName() + " -----"
              + "\nNumber of Ellipsoid Objects: " + eList.size()
              + "\nTotal Volume: " + df.format(totalVolume()) + " cubic units"
              + "\nTotal Surface Area: " + df.format(totalSurfaceArea()) 
              + " square units"
              + "\nAverage Volume: " + df.format(averageVolume()) 
              + " cubic units"
              + "\nAverage Surface Area: " + df.format(averageSurfaceArea()) 
              + " square units";
      return output;
   
   }
}