


import java.util.Comparator;

/** monthly cost comparator class.
*@author Samuel Adams
*@version 4/10/2020
*
*
**
*/
public class MonthlyCostComparator implements Comparator<CloudStorage> {
   /** compare method.
      @param obj1 n
      @param obj2 n 
      @return num*/

   public int compare(CloudStorage obj1, CloudStorage obj2) {
      
      if (obj1.monthlyCost() > obj2.monthlyCost()) {
      
         return -1;
      
      }
      else if (obj1.monthlyCost() < obj2.monthlyCost()) {
      
         return 1;
      }
      else {
      
         return 0;
      
      }
      
      
   
   
   }









}