/** Personal Cloud class.
@version 4/2/2020
@author Samuel Adams
*/
public class PersonalCloud extends PublicCloud {
   /** instance variable. */
   public static final double COST_FACTOR = 3.0;
   
   /** Personal Cloud con.
   @param nameIn n
   @param storageCostIn n
   @param dataStoredIn n
   @param dataLimitIn n
   */
   
   public PersonalCloud(String nameIn, double storageCostIn, 
      double dataStoredIn, double dataLimitIn) {
      super(nameIn, storageCostIn, dataStoredIn, dataLimitIn);
      
   
   }
   
   /** get Cost Factor method.
   @return COST_FACTOR s */
   
   public double getCostFactor() {
   
      return COST_FACTOR;
   }
   /** monthly Cost method.
   @return monthlyCost */
   
   public double monthlyCost() {
      double monthlyCost = storageCost 
         + (dataOverage() * PersonalCloud.COST_FACTOR);
      
      return monthlyCost;
   }
}