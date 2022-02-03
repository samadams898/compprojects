import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** Shared Cloud Test.
@author Samuel Adams
@version 4/2/2020
*/

public class SharedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** get data stored test. */
   @Test public void getDataStoredTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 9.00, 25.00);
      Assert.assertEquals("getDataStoredTest", 9, a.getDataStored(), 0.0000);
   }
   /** set Data Stored test. */
   @Test public void setDataStoredTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      a.setDataStored(9);
      Assert.assertEquals("getDataStoredTest", 9, a.getDataStored(), 0.0000);
   
   }
   /** get Data Limit Test. */
   @Test public void getDataLimitTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("getDataLimit test", 25, a.getDataLimit(), 0.0000);
   
   
   }
   /** set Data Limit test. */
   @Test public void setDataLimitTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      a.setDataLimit(26);
      Assert.assertEquals("getDataLimit test", 26, a.getDataLimit(), 0.0000);
   
   }
   /** get Cost Factor test. */
   @Test public void getCostFactorTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("getDataLimit test", 1.0, a.getCostFactor(), 0.0000);

   }
   /** data Overage test. */
   @Test public void dataOverageTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      SharedCloud a2 = new SharedCloud("Arnold", 0, 10, 0);
      
      Assert.assertEquals("data overage test", 0, a.dataOverage(), 0.0000);
      Assert.assertEquals("data Overage test", 10, a2.dataOverage(), 0.0000);
   
   
   }
   /** monthly Cost test. */
   @Test public void monthlyCost() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("data overage test", 14, a.monthlyCost(), 0.0000);
  
   }
   /** toString test. */
   @Test public void toStringTest() {
      SharedCloud a = new SharedCloud("Arnold", 14.00, 10.00, 25.00);
      Assert.assertEquals("toStringTest", 
         "Arnold (class SharedCloud) Monthly Cost: $14.00"
                                             + "\nBase Storage Cost: $14.00"
                                             + "\nData Stored: 10.000 GB"
                                             + "\nData Limit: 25.000 GB"
                                             + "\nOverage: 0.000 GB"
                                             + "\nCost Factor: 1.0", 
                                             a.toString());
      
   }
}
