import java.util.Scanner;
/** Ellipsoid App Program. solves for surface area and volume.
*
*Project04
*@author Samuel Adams
*@version 2/5/2020
*
*/
public class EllipsoidApp {
/** @param args not used fam
   */
   public static void main(String []args) {
   
      Scanner in = new Scanner(System.in);
      Ellipsoid app = new Ellipsoid("", 0, 0, 0);
      System.out.print("Enter label and axes a, b, c for an ellipsoid.");
      System.out.print("\n\tlabel: ");
      app.setLabel(in.nextLine());
      System.out.print("\ta: ");
      app.setA(in.nextDouble());
      if (app.getA() <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
      System.out.print("\tb: ");
      app.setB(in.nextDouble());
      if (app.getB() <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }

      System.out.print("\tc: ");
      app.setC(in.nextDouble());
      if (app.getC() <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
      System.out.println("\n" + app.toString());
   
   }
   
}