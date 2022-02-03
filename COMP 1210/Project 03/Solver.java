import java.util.Scanner;
import java.text.DecimalFormat;
/** My Solver program. Takes x value from userInput and solves equation.
*
*Project03
*@author Samuel Adams
*@version 1/30/2020
*/
public class Solver
{
   /** @param args not used
   */
   public static void main(String[] args)
   {
      double x;
      double result;
      double numerator;
      double denominator;
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      numerator = (Math.sqrt(Math.abs((11 * Math.pow(x, 4)) 
         + (9 * Math.pow(x, 3)) 
         + (7 * Math.pow(x, 2)) + (5 * x) + 4)));
      denominator = ((2 * x) + 4);
      result = (numerator / denominator);
      System.out.println("Result: " + result);
      String formatvalue = Double.toString(result);
        
      int decimalPos = formatvalue.indexOf(".");
      int llength = decimalPos;
      int rlength = ((formatvalue.length() - decimalPos) - 1);
      System.out.println("# of characters to left of decimal point: " 
         + llength);
      System.out.println("# of characters to right of decimal point: " 
         + rlength);
      DecimalFormat decform = new DecimalFormat("#,##0.0####");
      System.out.println("Formatted Result: " + decform.format(result));
     
   }
}