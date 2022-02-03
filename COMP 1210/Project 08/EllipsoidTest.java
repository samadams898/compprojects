import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** Project 08.
* Tests Ellipsoids.
*@author Samuel Adams
*@version 3/20/2020
*
**/

public class EllipsoidTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
   }


   /** A test that always fails. **/
 //  @Test public void defaultTest() {
   //   Assert.assertEquals("Default test added by jGRASP. Delete "
     //       + "this test once you have added your own.", 0, 1);
     /** tests getter methods. */
   @Test public void gettersT() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      Assert.assertEquals(e.getCount(), e.getCount());
      Assert.assertEquals("get Label Test", e.getLabel(), "Test");
      Assert.assertEquals("get A Test", e.getA(), 2, .0001);
      Assert.assertEquals("get B Test", e.getB(), 4, .0001);
      Assert.assertEquals("Get C Test", e.getC(), 8, .0001);
      
   }
         /** test setter methods. */
   @Test public void settersT() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      e.setLabel("Gamer");
      e.setA(4);
      e.setB(6);
      e.setC(10);
      Assert.assertEquals("get Label Test", e.getLabel(), "Gamer");
      Assert.assertEquals("get A Test", e.getA(), 4, .0001);
      Assert.assertEquals("get B Test", e.getB(), 6, .0001);
      Assert.assertEquals("Get C Test", e.getC(), 10, .0001);
      e = new Ellipsoid(null, 2, 4, 8);
      Assert.assertFalse(e.setLabel(null));
      e = new Ellipsoid("Neg", -1, 4, 8);
      Assert.assertFalse(e.setA(-1));
      e = new Ellipsoid("Meg", 2, -1, 8);
      Assert.assertFalse(e.setB(-1));
      e = new Ellipsoid("Neg", 2, 4, -1);
      Assert.assertFalse(e.setC(-1));
      e = new Ellipsoid("ZeroA", 0, 4, 8);
      Assert.assertFalse(e.setA(0));
      e = new Ellipsoid("ZeroB", 2, 0, 8);
      Assert.assertFalse(e.setB(0));
      e = new Ellipsoid("ZeroC", 2, 4, 0);
      Assert.assertFalse(e.setC(0));
     
     
   }
     /** Test volume method. */
   @Test public void volumeTest() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      Assert.assertEquals("volume Test", e.volume(), 268.082573106329, .000001);
      
   }
     /** test surface Area methods. */
   @Test public void surfaceAreaTest() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      Assert.assertEquals("surface Area Test", e.surfaceArea(), 
         254.0327254312495, 
         .000001);
      
      
   }
     /** tests reset count method.*/
   @Test public void resetCountTest() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      e.resetCount();
      Assert.assertEquals(0, e.getCount());
     
   }
     /** tests equals count test.*/
   @Test public void equalsTest() {
      Ellipsoid a1 = new Ellipsoid("a1", 2, 4, 8);
      Ellipsoid b2 = new Ellipsoid("b2", 2, 4, 8);
     //if e2 is not ellipsoid
      Assert.assertEquals("equals obj test", false, a1.equals("obj"));
     //If e1 and e2 are equal
      Ellipsoid a2 = new Ellipsoid("a1", 2, 4, 8);
      Assert.assertTrue(a1.equals(a2));
      Assert.assertFalse(a1.equals(b2));
      Ellipsoid be = new Ellipsoid("a1", 4, 4, 8);
      Assert.assertFalse(a1.equals(be));
      Ellipsoid b3 = new Ellipsoid("a1", 2, 8, 8);
      Assert.assertFalse(a1.equals(b3));
      Ellipsoid b4 = new Ellipsoid("a1", 2, 4, 10);
      Assert.assertFalse(a1.equals(b4));
     // a1 = new E
      
      
      
      
   }
     /** tests to String method. */
   @Test public void toStringTest() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      Assert.assertEquals("Ellipsoid " + "\"" + "Test" + "\" with axes a = "
         + "2.0" + ", b = " + "4.0"
         + ", c = " + "8.0"
         + " units has:" + "\n\tvolume = " + "268.0826"
         + " cubic units"
         + "\n\tsurface area = " + "254.0327" + " square units", e.toString());
     
     
     
   }
   /** tests to hashCode. */
   @Test public void hashCodeTest() {
      Ellipsoid e = new Ellipsoid("Test", 2, 4, 8);
      Assert.assertEquals(0, e.hashCode());
   
   
   }
}
