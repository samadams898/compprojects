import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** Public Cloud Test.
@author Samuel Adams
@version 4/2/2020
*/

public class PublicCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
    //  Assert.assertEquals("Default test added by jGRASP. Delete "
  //  
    //      + "this test once you have added your own.", 0, 1);
  // }
  /** get Cost Factor Test. */
   @Test public void getCostFactorTest() {
      PublicCloud a = new PublicCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("Get cost factor test", 2.0, 
         a.getCostFactor(), 0.0000);
  
   }
  /** monthly Cost Test. */
   @Test public void monthlyCostTest() {
      PublicCloud a = new PublicCloud("Arnold", 14.00, 
         10.00, 25.00);
      Assert.assertEquals("Get cost factor test", 
         14.00, a.monthlyCost(), 0.0000);
   
  
  
   }
}
