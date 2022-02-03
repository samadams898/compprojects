import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;


/** Cloud Storage List class.
*  Project 10
* @author Samuel Adams
*  @version 4/10/2020
*
*
*/
public class CloudStorageList {

   private CloudStorage[] cloudArray;
   private String[] invalidReads;
   
   
   /** cloud storage list array. 
   */
   public CloudStorageList() {
   
      cloudArray = new CloudStorage[0];
      invalidReads = new String[0];
   
   
   
   }
   /** get Cloud storage Array.
   @return array n */
   public CloudStorage[] getCloudStorageArray() {
   
   
   
      return cloudArray;
   }
   /** get invalid records array.
   @return arrrg n */
   public String[] getInvalidRecordsArray() {
   
   
   
   
   
      return invalidReads;
   }
   /** add cloud storage method.
   @param cloudStorageIn m */
   public void addCloudStorage(CloudStorage cloudStorageIn) {
      
      cloudArray = Arrays.copyOf(cloudArray, cloudArray.length + 1);
      cloudArray[cloudArray.length - 1] = cloudStorageIn;
   
   
   }
   /** add invalid record method.
   @param invalid n
  */
   public void addInvalidRecord(String invalid) {
   
      invalidReads = Arrays.copyOf(invalidReads, invalidReads.length + 1);
      invalidReads[invalidReads.length - 1] = invalid;
   
   }
   /**read file method. 
   @param dataFile h hh 
   @throws FileNotFoundException n*/
   
   public void readFile(String dataFile) 
      throws FileNotFoundException {
      Scanner scan = new Scanner(new File(dataFile));
   
   
      while (scan.hasNextLine()) {
         String typeOf = "";
         String name = "";
         double baseStorageCost = 0, param2 = 0, param3 = 0;
         
         
         //if (scan.hasNext()){ 
         String current = scan.nextLine();
         
         char type = current.charAt(0);
         Scanner sin = new Scanner(current).useDelimiter(",");
         switch (type) {
         
            case 'C':
               typeOf = sin.next();
               name = sin.next();
               baseStorageCost = Double.parseDouble(sin.next());
               param2 = Double.parseDouble(sin.next());
               param3 = Double.parseDouble(sin.next());
               PublicCloud c = new PublicCloud(name, 
                  baseStorageCost, param2, param3);
               addCloudStorage(c);
               continue;
         
            case 'D':
               typeOf = sin.next();
               name = sin.next();
               baseStorageCost = Double.parseDouble(sin.next());
               param2 = Double.parseDouble(sin.next());
               DedicatedCloud d = new DedicatedCloud(name, 
                  baseStorageCost, param2);
               addCloudStorage(d);
               continue;
            case 'P':
               typeOf = sin.next();
               name = sin.next();
               baseStorageCost = Double.parseDouble(sin.next());
               param2 = Double.parseDouble(sin.next());
               param3 = Double.parseDouble(sin.next());
               PersonalCloud p = new PersonalCloud(name, 
                  baseStorageCost, param2, param3);
               addCloudStorage(p);
               continue;
            case 'S':
               typeOf = sin.next();
               name = sin.next();
               baseStorageCost = Double.parseDouble(sin.next());
               param2 = Double.parseDouble(sin.next());
               param3 = Double.parseDouble(sin.next());
               SharedCloud s = new SharedCloud(name, 
                  baseStorageCost, param2, param3);
               addCloudStorage(s);
               continue;
            
            default:
               continue;
         
         
         }
      
      
      
      
      
      //}
      
      
      
      }
   }
   /**generate Report method.
   @return string */
   public String generateReport() {
   
   //int index = 0;
      String output = "-------------------------------"
            + "\nMonthly Cloud Storage Report"
            + "\n-------------------------------";
   
      for (CloudStorage obj : cloudArray) {
         output += "\n" + obj.toString() + "\n";
      }
     
      return output;
   
   }
   /** Generate Report by name. Natural ordering.
   @return output out */
   public String generateReportByName() {
      String output = "-----------------------------------------"
            + "\nMonthly Cloud Storage Report (by Name)"
            + "\n-----------------------------------------";
      Arrays.sort(cloudArray);
      for (CloudStorage obj : cloudArray) {
         output += "\n" + obj.toString() + "\n";
      }
      return output;
   }
   /** generate Report by monthly cost.
   @return output */
   public String generateReportByMonthlyCost() {
      String output = "-------------------------------------------------"
            + "\nMonthly Cloud Storage Report (by Monthly Cost)"
            + "\n-------------------------------------------------";
      Arrays.sort(getCloudStorageArray(), new MonthlyCostComparator());
      for (CloudStorage obj : cloudArray) {
         output += "\n" + obj.toString() + "\n";
      }
      return output;
   }
   
   







































}