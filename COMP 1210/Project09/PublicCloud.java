/** SharedCloud class.
@version 4/2/2020
@author Samuel Adams
*/

public class PublicCloud extends SharedCloud {
   /** javadoc comment. */
   public static final double COST_FACTOR = 2.0;
   
   /** PublicCloud con.
   @param nameIn n
   @param storageCostIn n
   @param dataStoredIn n
   @param dataLimitIn n*/
   public PublicCloud(String nameIn, double storageCostIn, 
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, storageCostIn, dataStoredIn, dataLimitIn);
  
   }
  /** getCostFactor method.
  @return COST_FACTOR */
   public double getCostFactor() {
   
      return COST_FACTOR;
   }
  
  /** monthlyCost method.
  @return monthlyCost n */
   public double monthlyCost() {
      double monthlyCost = storageCost 
         + (dataOverage() * PublicCloud.COST_FACTOR);
  
  
      return monthlyCost;
   }
   















}