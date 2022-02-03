import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
   /** Get List method.
   @return eList bro. */
   public ArrayList<Ellipsoid> getList() {
      return eList;
   }
   /** readFile method.
   @return File info.
   @param fileNameIn file used.
   @throws FileNotFoundException thrown.
   */
   public EllipsoidList readFile(String fileNameIn) 
      throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File(fileNameIn));
      ArrayList<Ellipsoid> ellipList = new ArrayList<Ellipsoid>();
      double  a = 0, b = 0, c = 0;
      
      String eListName = "";
      eListName = fileScan.nextLine();
      while (fileScan.hasNext()) {
         if (fileScan.hasNextLine()) {
    
            String label = fileScan.nextLine();
         
            if (fileScan.hasNextDouble()) {
               a = Double.parseDouble(fileScan.next());
               b = Double.parseDouble(fileScan.next());
               c = Double.parseDouble(fileScan.next());
         
               Ellipsoid e = new Ellipsoid(label, a, b, c);
               eList.add(e);
            }
         }
      }
  
      EllipsoidList printList = new EllipsoidList(eListName, eList);
      return printList;
   }
   /** add Ellipsoid method.
      @param labelIn used
      @param aIn used
      @param bIn used.
      @param cIn used
       **/
   public void addEllipsoid(String labelIn, double aIn, 
      double bIn, double cIn) {
      Ellipsoid add = new Ellipsoid(labelIn, aIn, bIn, cIn);
      eList.add(add);
   }
  /** findEllipsoid method.
  @param labelIn used.
  @return Ellipsoid  */
   public Ellipsoid findEllipsoid(String labelIn) {
      Ellipsoid result = null;
      for (int i = 0; i < eList.size(); i++) {
         Ellipsoid find = eList.get(i);
         if (find.getLabel().equalsIgnoreCase(labelIn)) {
            result = find;
            break;
         }
      }
     
      return result;
   }
   /** delete Ellipsoid method.
   @param labelIn used
   @return Ellipsoid */
   public Ellipsoid deleteEllipsoid(String labelIn) {
   
      Ellipsoid del = findEllipsoid(labelIn);
      eList.remove(del);
      return del;
   }
  /** edit Ellipsoid method.
  @param labelIn used.
  @param aIn used.
  @param bIn used.
  @param cIn used. 
  @return Ellipsoid*/
   public Ellipsoid editEllipsoid(String labelIn, 
      double aIn, double bIn, double cIn) {
      Ellipsoid edit = findEllipsoid(labelIn);
      if (findEllipsoid(labelIn) != null) {
         edit.setA(aIn);
         edit.setB(bIn);
         edit.setC(cIn);
         return edit;
      }
  
      return null;
   }
  
}