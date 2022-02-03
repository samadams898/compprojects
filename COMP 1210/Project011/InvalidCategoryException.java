/** exception class.
@author Samuel Adams
@version 4/16/2020
*
*/


public class InvalidCategoryException extends Exception {

   /** con.
   @param categoryIn yes */
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   
   }

}