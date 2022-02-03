import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** PersonalCloud Test.
@author Samuel Adams
@version 4/2/2020
*/
public class PersonalCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** getCostFactor Test. */
   @Test public void getCostFactorTest() {
      PersonalCloud a = new PersonalCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("Get cost factor test", 3.0, 
         a.getCostFactor(), 0.0000);
   
   }
   /** monthly cost Test. */
   @Test public void monthlyCostTest() {
      PersonalCloud a = new PersonalCloud("Arnold", 14.00, 10.00, 25.00);

      Assert.assertEquals("Get monthylcost tets", 14.00, 
         a.monthlyCost(), 0.0000);
   
   }
   
   
}
