import java.util.Scanner;
/** My Expressions program. Outputs solution to expression
*
*Project02
*@author Samuel Adams
*@version 1/22/2020
*
**/
public class Expression {
/** @param args not used
*/
  
   public static void main(String[] args) {
  //defines variables
      Scanner userInput = new Scanner(System.in);
      double x;
      double y;
      double result;
      System.out.println("result = (10x + 32.6) (5y - 1.567) / xy");
      System.out.print("\tx = ");
      x = userInput.nextDouble();
      System.out.print("\ty = ");
      y = userInput.nextDouble();
      if (x * y == 0) { //asks if x times y equals 0
         System.out.println("result is \"undefined\"");
      }
      else { //prints result if x times y is not 0
         result = ((10 * x) + 32.6) * ((5 * y) - 1.567) / (x * y);
         System.out.println("result = " + result);
      }

   }
}  