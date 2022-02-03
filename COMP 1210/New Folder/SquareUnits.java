import java.util.Scanner;
/** My Square Units program. Lays out units from user input of square inches
*
*Project02
*@author Samuel Adams
*@version 1/22/2020
*/

public class SquareUnits {
/** @param args not used
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int areainSqIn;
      System.out.print("Enter the area in square inches: ");
      areainSqIn = userInput.nextInt();
      if (areainSqIn >= 1000000000) {
         System.out.println("Limit of 1,000,000,000 square inches" 
            + " exceeded!");
      }
      else {
         int sqYards = areainSqIn / 1296;
         int sqAcres = areainSqIn / 6272640;
         int sqFt = areainSqIn / 144;
         int sqYardsRem = areainSqIn % 1296;
         int sqAcresRem = areainSqIn % 6272640;
         int sqFtRem = areainSqIn % 144;
         System.out.println("Number of Units:");
         System.out.println("\tAcres: " + sqAcres); 
         System.out.println("\tSquare Yards: " + (sqAcresRem / 1296));
         System.out.println("\tSquare Feet: " + (sqYardsRem / 144));
         System.out.println("\tSquare Inches: " + (sqFtRem));
      }
   
   }
}