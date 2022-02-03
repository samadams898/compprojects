
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
public class EllipsoidList2 {

   private  String listName;
   private  Ellipsoid[] eList;
   private  int eNum;
   
   /**
   * EllipsoidList constructor. 
   * @param listNameIn Input Name
   * @param eListIn array list
   *@param eNumIn eNumbers
   */
   public EllipsoidList2(String listNameIn, Ellipsoid[] eListIn, int eNumIn) {
      listName = listNameIn;
      eList = eListIn;
      eNum = eNumIn;
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
      return eNum;
   }
   /**
    *the total volume of the ellipsoid.
    *@return totalVol
    */
   public double totalVolume() {
      int index = 0;
      double totalVol = 0;
      while (index < eNum) {
         totalVol += eList[index].volume();
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
      if (eNum != 0) {
         while (index < eNum) {
            avgVol += eList[index].volume();
            index++;
         
         }
         avgVol = avgVol / eNum;
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
      while (index < eNum) {
         totalSur += eList[index].surfaceArea();
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
      if (eNum != 0) {
         while (index < eNum) {
            avgSur += eList[index].surfaceArea();
            index++;
         }
         avgSur = avgSur / eNum;
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
      while (index < eNum) {
         output += "\n" + eList[index].toString() + "\n";
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
              + "\nNumber of Ellipsoid Objects: " + eNum
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
   public Ellipsoid[] getList() {
      return eList;
   }
   /** readFile method.
   @return File info.
   @param fileNameIn file used.
   @throws FileNotFoundException thrown.
   */
   public EllipsoidList2 readFile(String fileNameIn) 
      throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File(fileNameIn));
      Ellipsoid[] ellipList;
      double  a = 0, b = 0, c = 0;
      
      String eListName = "";
      eListName = fileScan.nextLine();
      int eIndex = 0;
      while (fileScan.hasNext()) {
         if (fileScan.hasNextLine()) {
            //eNum++;
            String label = fileScan.nextLine();
         
            if (fileScan.hasNextDouble()) {
               a = Double.parseDouble(fileScan.next());
               b = Double.parseDouble(fileScan.next());
               c = Double.parseDouble(fileScan.next());
               Ellipsoid e = new Ellipsoid(label, a, b, c);
               eList[eIndex] = e;
               eIndex++;
               eNum++;
            }
         }
      }
  
      EllipsoidList2 printList = new EllipsoidList2(eListName, eList, eNum);
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
      eList[eNum] = add;
      eNum++;
   }
  /** findEllipsoid method.
  @param labelIn used.
  @return Ellipsoid  */
   public Ellipsoid findEllipsoid(String labelIn) {
      Ellipsoid result = null;
      for (int i = 0; i < eNum; i++) {
         Ellipsoid find = eList[i];
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
     // Ellipsoid target = labelIn;
      for (int i = 0; i < eNum; i++) {
         if (eList[i] == del) {

            for (int k = i; k < eNum - 1; k++) {
            
               eList[k] = eList[k + 1];
               
            }
           // eNum--;
            break;
            
         }
      }
      eList[eNum - 1] = null;
      eNum--;
    
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
   /** find Ellipsoid with the smallest volume.
   @return smallest */
   public Ellipsoid findEllipsoidWithSmallestVolume() {
      if (eNum <= 0) {
         return null;
      }
      double smallestV = eList[0].volume();
      Ellipsoid smallest = null;
      int index = 0;
      while (index < eNum) {
         if (!(smallestV < eList[index].volume())) {
            smallestV = eList[index].volume();
            smallest = eList[index];
         }
         index++;
      }
   
      return smallest;
   }
   /** find e with largest vol.
   @return largest large */
   public Ellipsoid findEllipsoidWithLargestVolume() {
      if (eNum <= 0) {
         return null;
      }
      double largestV = eList[0].volume();
      Ellipsoid largest = null;
      int index = 0;
      while (index < eNum) {
         if (!(largestV > eList[index].volume())) {
            largestV = eList[index].volume();
            largest = eList[index];
         }
         index++;
      }
   
      return largest;

   }
   /** find ellipsoid wth samlelt srufae area.
   @return smallest surfarea */
   public Ellipsoid findEllipsoidWithSmallestSurfaceArea() {
      if (eNum <= 0) {
         return null;
      }
      double smallestSA = eList[0].surfaceArea();
      Ellipsoid smallest = null;
      int index = 0;
      while (index < eNum) {
         if (!(smallestSA < eList[index].surfaceArea())) {
            smallestSA = eList[index].surfaceArea();
            smallest = eList[index];
         }
         index++;
      }
   
      return smallest;
   }
   /** find e with large surf.
   @return largest lagre */
   public Ellipsoid findEllipsoidWithLargestSurfaceArea() {
      if (eNum <= 0) {
         return null;
      }
      double largestSA = eList[0].surfaceArea();
      Ellipsoid largest = null;
      int index = 0;
      while (index < eNum) {
         if (!(largestSA > eList[index].surfaceArea())) {
            largestSA = eList[index].surfaceArea();
            largest = eList[index];
         }
         index++;
      }
   
      return largest;
   }
  
}