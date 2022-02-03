import java.text.DecimalFormat;
/** Dedicated Cloud class.
@author Samuel Adams
@version 4/2/2020
*/



public class DedicatedCloud extends CloudStorage {
   private double serverCost;

   /**DedicatedCloud con.
   @param serverCostIn servercost 
   @param nameIn n
   @param storageCostIn n */

   public DedicatedCloud(String nameIn, double storageCostIn, 
      double serverCostIn) {
      super(nameIn, storageCostIn);
   
      serverCost = serverCostIn;
   
   }
   /** get serverCost method.
   @return serverCost */
   public double getServerCost() {
   
      return serverCost;
   }
   /** set ServerCost method.
   @param serverCostIn s */
   public void setServerCost(double serverCostIn) {
      serverCost = serverCostIn;
   
   }
   /** monthly Cost override method.
   @return monthly costttt 2 */
   public double monthlyCost() {
      
      double monthlyCost = storageCost + serverCost;
   
      return monthlyCost;
   }

   /** to String method.
   @return output string */
   public String toString() {
      DecimalFormat dm = new DecimalFormat("$#.00");
      String output = super.toString() + "\nServer Cost: " 
         + dm.format(serverCost);
  
      return output;
   }




}