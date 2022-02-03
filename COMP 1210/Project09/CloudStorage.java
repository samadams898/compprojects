import java.text.DecimalFormat;
/** Cloud Storage abstract class.
*@author Samuel Adams
*@version 04/02/20
*
*
*
*/

public abstract class CloudStorage {

   protected String name;
   protected double storageCost;
   protected static int count;
   
   /** Cloud storage cons.
   @param nameIn name
   @param storageCostIn sto */
   
   public CloudStorage(String nameIn, double storageCostIn) {
      name = nameIn;
      storageCost = storageCostIn;
      count++;
   
   }
   /** getName getter.
   @return name name */

   public String getName() {
   
      return name;
   }
   /** setName setter method.
   @param nameIn nnn */
   public void setName(String nameIn) {
      name = nameIn;
   }
   /** getBaseStorageCost method.
   @return storageCost cost */
   public double getBaseStorageCost() {
   
      return storageCost;
   
   }
   /** setBaseStorageCost setter.
   @param storageCostIn costIn*/
   public void setBaseStorageCost(double storageCostIn) {
      storageCost = storageCostIn;
   }
   /** getCount method.
   @return count c */
   
   public static int getCount() {
   
      return count;
   }
   /** resetCount method. Resets count.
   */
   public static void resetCount() {
      count = 0;
   
      
   }
   /** to String method.
   @return output o */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#.00");
      String output = name + " (" + this.getClass() + ")" + " Monthly Cost: "  
         + df.format(monthlyCost()) 
         + "\nBase Storage Cost: " 
         + df.format(storageCost);
      
      return output;
   }
   /** monthly Cost abstract method.
   @return monthlyCost n */
   public abstract double monthlyCost(); 
   
   







}