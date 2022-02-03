import java.text.DecimalFormat;
/** Shared Cloud method.
@author Samuel Adams
@version 4/2/2020
*/

public class SharedCloud extends CloudStorage {

   protected double dataStored;
   protected double dataLimit;
   /** javadoc comment. */
   public static final double COST_FACTOR = 1.0;
   
   /** Shared cloud constructor.
   @param dataStoredIn u
   @param dataLimitIn u
   @param nameIn n
   @param storageCostIn n */
   
   public SharedCloud(String nameIn, double storageCostIn, 
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, storageCostIn);
      dataStored = dataStoredIn;
      dataLimit = dataLimitIn;
   
   
   
   }
   
   /** getDataStored method.
   @return dataStored d */
   public double getDataStored() {
      
      return dataStored;
   }
   /** setDataStored method.
   @param dataStoredIn n */
   
   public void setDataStored(double dataStoredIn) {
      dataStored = dataStoredIn;
      
   }
   /** getDataLimit method.
   @return dataLimit n */
   public double getDataLimit() {
   
   
   
      return dataLimit;
   }
   /** setDataLimit method.
   @param dataLimitIn n */
   
   public void setDataLimit(double dataLimitIn) {
      dataLimit = dataLimitIn;
   }
   /** getCostFactor method.
   @return COST_FACTOR m*/
   public double getCostFactor() {
      return COST_FACTOR;
   }
   /** data Overage method.
   @return overage n*/
   public double dataOverage() {
      double overage = dataStored - dataLimit;
      if (overage < 0) {
     
         return 0;
      }
   
      return overage;
   }
   /** monthlyCost override method.
   @return monthlyCost n */
   public double monthlyCost() {
      double monthlyCost = storageCost 
         + dataOverage() * SharedCloud.COST_FACTOR;
      
   
      return monthlyCost;
   }
   /** toString method override.
   @return output s */
   public String toString() {
      DecimalFormat dm = new DecimalFormat("$#.00");
      DecimalFormat dg = new DecimalFormat("##0.000 GB");
      String output = super.toString() + "\nData Stored: " 
         + dg.format(dataStored) + "\nData Limit: " + dg.format(dataLimit) 
         +  "\nOverage: " + dg.format(dataOverage()) 
         + "\nCost Factor: " + getCostFactor();
      
      return output;
   
   
   }
   
}