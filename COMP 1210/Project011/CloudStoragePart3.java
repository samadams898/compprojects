//import java.util.Arrays;
//import java.io.File;
import java.io.FileNotFoundException;



/**Cloud storage part 2 driver.
@author Samuel Adams
@version 4/10/2020
*/

public class CloudStoragePart3 {
/** main method.
@param args used
@throws FileNotFoundException */

   public static void main(String[] args)  {
      String fileName = "";
          
     
      try {
        
         if (args.length != 0) {
            fileName = args[0];
            
            CloudStorageList cList = new CloudStorageList();
            cList.readFile(fileName);
         //System.out.print("-------------------------------"
            //+ "\nMonthly Cloud Storage Report"
            //+ "\n-------------------------------");
            System.out.println(cList.generateReport());
         //System.out.print("-------------------------------"
            //+ "\nMonthly Cloud Storage Report (by Name)"
            //+ "\n-------------------------------");
            System.out.println(cList.generateReportByName());
         //System.out.print("-------------------------------"
            //+ "\nMonthly Cloud Storage Report (by Monthly Cost)"
            //+ "\n-------------------------------");
            System.out.println(cList.generateReportByMonthlyCost());
            System.out.println(cList.generateInvalidRecordsReport());
         }
         else {
            System.out.println("File name expected as command line argument."
               + "\nProgram ending.");
         
         }
      }
      catch (FileNotFoundException e) {
         System.out.println("*** Attempted to read file: " + fileName 
            + " (No such file or directory)");
       
      }
      
   }
   
   
}
