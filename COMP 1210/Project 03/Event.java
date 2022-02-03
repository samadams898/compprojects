import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/** My Event program. Reads User inputs event code.
*
*Project 03
*@author Samuel Adams
*@version 1/30/2020
*/

public class Event

{
/** @param args not used.
*/
   public static void main(String[] args)

   {
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter your event code: ");
      String eventcode = userInput.nextLine();
      eventcode = eventcode.trim();
      if (eventcode.length() >= 26) {
         String mon = eventcode.substring(0, 2);
         String day = eventcode.substring(2, 4);
         String year = eventcode.substring(4, 8);
         String eventName = eventcode.substring(25);
         String hour = eventcode.substring(8, 10);
         String min = eventcode.substring(10, 12);
         String price = eventcode.substring(12, 16);
         //price = price.replace("0", "");
         String discount = eventcode.substring(16, 19);
         String section = eventcode.substring(19, 21);
         String row = eventcode.substring(21, 23);
         String seat = eventcode.substring(23, 25);
         System.out.println("\nEvent: " + eventName + "   Date: " + mon + "/" 
            + day + "/" + year + "   Time: " + hour + ":" + min);
         System.out.println("Section: " + section + "   Row: " + row  
            + "   Seat: " + seat);
         DecimalFormat moneyform = new DecimalFormat("$#,##0.00");
         DecimalFormat discform = new DecimalFormat("0%");
         DecimalFormat prizeform = new DecimalFormat("0000");
         Random gen = new Random();  
         int prizenum = gen.nextInt(9999) + 1;
         double priceD = Double.parseDouble(price);
         double discoD = Double.parseDouble(discount);
         double cost = (priceD - ((priceD * discoD) / 100));
         System.out.println("Price: " + moneyform.format(priceD / 10)  
            + "   Discount: " + discform.format(discoD / 100) + "   Cost: " 
            + moneyform.format(cost / 10));
         System.out.println("Prize Number: " + prizeform.format(prizenum));  
      }
   
      else {
         System.out.println("\nInvalid Event Code.");
         System.out.println("Event code must have at least 26 characters.");
   
   
      }
   
   
   
   }
}
   