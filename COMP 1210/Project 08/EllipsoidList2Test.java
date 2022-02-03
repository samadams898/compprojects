import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
/** Project 08B.
*@author Samuel Adams
*@version 03/27/2020
*/

public class EllipsoidList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/** get Name test. */

   @Test public void getNameTest() {
  // Ellipsoid[] eList = new Ellipsoid[0];
      EllipsoidList2 e = new EllipsoidList2("Test List", null, 0);
      Assert.assertEquals("Test List", e.getName(), "Test List");
   }
   /** number of ellipsoids test. */
   @Test public void numberOfEllipsoidsTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 4);
      Assert.assertEquals("Number Test", e.numberOfEllipsoids(), 4);
   }
   /** total vol test. */
   @Test public void totalVolumeTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Test", e.totalVolume(), 150.796, 0.001);
     // EllipsoidList2 e2 = new EllipsoidList2("Fail List", eList, 0);
      
      //Assert.assertEquals("a is 0 test", e2.totalVolume(), 0, 0.00001);
   
   }
   /** average vol test. */
   @Test public void averageVolumeTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
      Assert.assertEquals("Test", e.averageVolume(), 50.265, 0.001);
      EllipsoidList2 e2 = new EllipsoidList2("Fail List", eList, 0);
      
      Assert.assertEquals("a is 0 test", e2.averageVolume(), 0, 0.00001);
   
   }
   /** total surface area test. */
   @Test public void totalSurfaceAreaTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Test", e.totalSurfaceArea(), 175.929, 0.001);
      //EllipsoidList2 e2 = new EllipsoidList2("Fail List", eList, 0);
      
      //Assert.assertEquals("a is 0 test", e2.totalSurfaceArea(), 0, 0.00001);
   
   
   
   }
   /** avg surf test. */
   @Test public void averageSurfaceAreaTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Pinkerton is the best Weezer Album", 
         e.averageSurfaceArea(), 
         58.643, 0.001);
      EllipsoidList2 e2 = new EllipsoidList2("Fail List", eList, 0);
      
      Assert.assertEquals("a is 0 test", e2.averageSurfaceArea(), 0, 0.00001);
   }
   /** to string test. */
   @Test public void toStringTest() {
      Ellipsoid[] eList = new Ellipsoid[1];
      eList[0] = new Ellipsoid("Buddy Holly", 1, 1, 1);
  // eList[1] = new Ellipsoid("Only In Dreams", 2, 2, 2);
 //eList[2] = new Ellipsoid("Pink Triangle", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Test", eList, 1);
      Assert.assertEquals("\nEllipsoid " + "\"" + "Buddy Holly" 
            + "\" with axes a = "
            + "1.0" + ", b = " + "1.0"
            + ", c = " + "1.0"
            + " units has:" + "\n\tvolume = " + "4.1888"
            + " cubic units"
            + "\n\tsurface area = " + "12.5664" 
            + " square units\n", e.toString());

   }
   /** summary info test. */
   @Test public void summaryInfoTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Buddy Holly", 1, 1, 1);
      eList[1] = new Ellipsoid("Jonas", 2, 2, 2);
      eList[2] = new Ellipsoid("Rivers", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 3);
   
   
      Assert.assertEquals("----- Summary for Weezer -----"
              + "\nNumber of Ellipsoid Objects: 3"
              + "\nTotal Volume: 150.796 cubic units"
              + "\nTotal Surface Area: 175.929"
              + " square units"
              + "\nAverage Volume: 50.265"
              + " cubic units"
              + "\nAverage Surface Area: 58.643"
              + " square units", e.summaryInfo());
   

   }
   /** get list test. */
   @Test public void getListTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 4);
      Assert.assertArrayEquals(eList, e.getList());
   
   }
   /** read file test.
   @throws FileNotFoundException */
   @Test public void readFileTest() throws FileNotFoundException {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Ex 1", 1, 2, 3);
      eList[1] = new Ellipsoid("Ex 2", 2.3, 5.5, 7.4);
      eList[2] = new Ellipsoid("Ex 3", 123.4, 234.5, 345.6);
      EllipsoidList2 e = new EllipsoidList2("Ellipsoid List Test", eList, 3);
   
      String file = "Ellipsoid_data_1.txt";
      e = e.readFile(file);
      Assert.assertEquals("read file Test", "Ellipsoid Test List", e.getName());
      EllipsoidList2 e2 = new EllipsoidList2("Ellipsoid List Test", eList, 0);
      e2 = e2.readFile("Ellipsoid_data_0.txt");
      
      Assert.assertEquals("no file test", "Ellipsoid Empty Test List", 
         e2.getName());
   }
   /** add ellipsoid test. */
   @Test public void addEllipsoidTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList[1] = new Ellipsoid("Scott", 2, 2, 2);
      eList[2] = new Ellipsoid("Rivers", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 3);
      Ellipsoid add = new Ellipsoid("Scott", 4, 4, 4);
      e.addEllipsoid("Scott", 4, 4, 4);
      Ellipsoid[] eA = e.getList();
      Assert.assertEquals("add Ellipsoid test", add, eA[3]);
   
   }
   /** find ellip test. */
   @Test public void findEllipsoidTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList[1] = new Ellipsoid("Scott", 2, 2, 2);
      eList[2] = new Ellipsoid("Rivers", 3, 3, 3);
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 3);
      Ellipsoid[] eF = e.getList();
      Assert.assertEquals("find Ellipsoid test", e.findEllipsoid("Rivers"), 
         eF[2]);
 
   }
   /** delete ellipsoid test. */
   @Test public void deleteEllipsoidTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      Ellipsoid[] eList2 = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList[1] = new Ellipsoid("Scott", 2, 2, 2);
      eList[2] = new Ellipsoid("Rivers", 3, 3, 3);
      eList2[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList2[1] = new Ellipsoid("Scott", 2, 2, 2);
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 3);
      EllipsoidList2 e2 = new EllipsoidList2("Weezer", eList, 3);
      e.deleteEllipsoid("Rivers"); 
      Assert.assertArrayEquals("delete Ellipsoid Test", e.getList(), 
         e2.getList());
     // EllipsoidList2 e3 = new EllipsoidList2("Weezer", eList, 3);
      
      Assert.assertEquals("delete Ellipsoid Test Fail", 
         e.deleteEllipsoid("Bongo"), 
          null);

     
      
   }
   /** edit ellip test. */
   @Test public void editEllipsoidTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      Ellipsoid[] eList2 = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList[1] = new Ellipsoid("Scott", 2, 2, 2);
      eList[2] = new Ellipsoid("Rivers", 3, 3, 3);
      eList2[0] = new Ellipsoid("Brian", 1, 1, 1);
      eList2[1] = new Ellipsoid("Scott", 2, 2, 2);
      eList2[2] = new Ellipsoid("Rivers", 4, 4, 4);
      EllipsoidList2 e = new EllipsoidList2("Weezer", eList, 3);
      EllipsoidList2 e2 = new EllipsoidList2("Weezer", eList, 3);
      e.editEllipsoid("Rivers", 4, 4, 4); 
      Assert.assertArrayEquals("edit Ellipsoid Test", e.getList(), 
         e2.getList());
         //EllipsoidList2 e3 = new EllipsoidList2(null, null, 0);
      
      Assert.assertEquals("edit Ellipsoid Test null", 
         e.editEllipsoid("Patt", 4, 5, 6), null);
   
   
   }
   /** smallest test. */
   @Test public void smallestVolumeTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Hol up", e.findEllipsoidWithSmallestVolume(), 
         eList[0]);
   
      EllipsoidList2 e2 = new EllipsoidList2("Empty List Test", null, 0);
      Assert.assertEquals("Empty Test", e2.findEllipsoidWithSmallestVolume(), 
         null);
   
   }
   /** largest vol test. */
   @Test public void largestVolumeTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Hol up", e.findEllipsoidWithLargestVolume(), 
         eList[2]);
   
      EllipsoidList2 e2 = new EllipsoidList2("Empty List Test", null, 0);
      Assert.assertEquals("Empty Test", e2.findEllipsoidWithLargestVolume(), 
         null);
      Ellipsoid[] eList3 = new Ellipsoid[4];
      eList3[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList3[1] = new Ellipsoid("Botch", 1, 1, 1);
      EllipsoidList2 e3 = new EllipsoidList2("boi", eList3, 2);
     // Assert.assertEquals("no largest", null, 
      //   e3.findEllipsoidWithLargestVolume());
   
   }
   /** smallest surface area test. */
   @Test public void smallestSurfaceAreaTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Hol up", e.findEllipsoidWithSmallestSurfaceArea(), 
         eList[0]);
   
      EllipsoidList2 e2 = new EllipsoidList2("Empty List Test", null, 0);
      Assert.assertEquals("Empty Test", 
         e2.findEllipsoidWithSmallestSurfaceArea(), 
         null);
   
   }
   /** largest surface area test. */
   @Test public void largestSurfaceAreaTest() {
      Ellipsoid[] eList = new Ellipsoid[4];
      eList[0] = new Ellipsoid("Test1", 1, 1, 1);
      eList[1] = new Ellipsoid("Test2", 2, 2, 2);
      eList[2] = new Ellipsoid("Test3", 3, 3, 3);
      
      EllipsoidList2 e = new EllipsoidList2("Test List", eList, 3);
   
      Assert.assertEquals("Hol up", 
         e.findEllipsoidWithLargestSurfaceArea(), eList[2]);
   
      EllipsoidList2 e2 = new EllipsoidList2("Empty List Test", null, 0);
      Assert.assertEquals("Empty Test", 
         e2.findEllipsoidWithLargestSurfaceArea(), null);
      Ellipsoid[] eList3 = new Ellipsoid[4];
      eList3[0] = new Ellipsoid("Test1", 1, 1, 1);
      //eList3[1] = new Ellipsoid("Test1", 1, 1, 1);
     
     // EllipsoidList2 e3 = new EllipsoidList2("boi", eList3, 1);
      //Assert.assertEquals("no largest", 
       //  e3.findEllipsoidWithLargestSurfaceArea(), 
      //   null);
   
   }
   
}
