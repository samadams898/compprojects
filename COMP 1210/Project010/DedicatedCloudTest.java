import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** DedicatedCloud Test.
@author Samuel Adams
@version 4/2/2020
*/

public class DedicatedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


 //  /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
     //       + "this test once you have added your own.", 0, 1);
     /** getName Test. */
   @Test public void getNameTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      Assert.assertEquals("getNameTest", "John Lennon", a.getName());
     
     
   }
     /** setNametest. */
   @Test public void setNameTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      a.setName("Dead");
      Assert.assertEquals("setNameTest", "Dead", a.getName());
   }
     /** getBasestorage test. */
   @Test public void getBaseStorageTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      
      Assert.assertEquals("getBaseStoragetest", 20.00, 
         a.getBaseStorageCost(), 0.0000);
   
   }
   /** set BAse Storage test. */
   @Test public void setBaseStorageTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 19.00, 15.00);
      a.setBaseStorageCost(20);
      Assert.assertEquals("getBaseStoragetest", 20.00, 
         a.getBaseStorageCost(), 0.0000);
   
   
   }
     /** getCountTest. */
   @Test public void getCountTest() {
      DedicatedCloud.resetCount();
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      
      Assert.assertEquals("get Count test", 1, a.getCount());
   }
     /** reset Count Test. */
   @Test public void resetCountTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      a.resetCount();
      Assert.assertEquals("getBaseStoragetest", 0, a.getCount());
     
     
   }
     /** to String test. */
   @Test public void toStringTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      
      Assert.assertEquals("toStringTest", 
         "John Lennon (class DedicatedCloud) Monthly Cost: $35.00"
                                             + "\nBase Storage Cost: $20.00"
                                             + "\nServer Cost: $15.00", 
                                                a.toString());
                                            
     
     
   }
    /** monthly cost test. */
   @Test public void monthlyCostTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      
      Assert.assertEquals("monthlyCost Test", 35, a.monthlyCost(), 0.00000);
     
   }
   /** getServer cost test. */
   @Test public void getServerCostTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      Assert.assertEquals("get Server Cost test", 15, 
         a.getServerCost(), 0.00000);
     
   }
   /** set cot ete.*/
   @Test public void setServerCostTest() {
      DedicatedCloud a = new DedicatedCloud("John Lennon", 20.00, 15.00);
      a.setServerCost(20);
      Assert.assertEquals("server cost set test", 20, 
         a.getServerCost(), 0.00000);
     
     
     
   }
}
