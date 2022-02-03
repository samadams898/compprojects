import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/** Ellipsoid List Menu App.
* Project 06
*@version 2/21/2020
*@author Samuel Adams
*
*/



public class EllipsoidList2MenuApp {
/** main method.
@param args not used!
@throws FileNotFoundException thrown.*/


   public static void main(String []args) throws FileNotFoundException {
      String listName = "*** no list name assigned ***";
      ArrayList<Ellipsoid> eList = new ArrayList<Ellipsoid>();
      EllipsoidList appList = new EllipsoidList(listName, eList);
      double a, b, c;
      String label = "";
      String userInput = "";
      String fileName = "no file name";
      Scanner s = new Scanner(System.in);
      System.out.println("Ellipsoid List System Menu"
         + "\nR - Read File and Create Ellipsoid List"
         + "\nP - Print Ellipsoid List"
         + "\nS - Print Summary"
         + "\nA - Add Ellipsoid"
         + "\nD - Delete Ellipsoid"
         + "\nF - Find Ellipsoid"
         + "\nE - Edit Ellipsoid"
         + "\nQ - Quit");
          
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         userInput = s.nextLine();
         if (userInput.length() == 0) {
            continue;
         }
         userInput = userInput.toUpperCase();
         char useChar = userInput.charAt(0);
         switch (useChar) {
            case 'R':
               System.out.print("\tFile Name: ");
               fileName = s.nextLine();
               appList = appList.readFile(fileName);
               System.out.println("\tFile read in and" 
                  + " Ellipsoid List created\n");
               break;
               
            case 'P':
               System.out.println(appList.getName());
               System.out.println(appList);
               break;
            case 'S':
               System.out.println("\n" + appList.summaryInfo() + "\n");
               break;
            case 'A' :
               System.out.print("\tlabel: ");
               label = s.nextLine();
               System.out.print("\ta: ");
               a = Double.parseDouble(s.nextLine());
               System.out.print("\tb: ");
               b = Double.parseDouble(s.nextLine());
               System.out.print("\tc: ");
               c = Double.parseDouble(s.nextLine());
               appList.addEllipsoid(label, a, b, c);
               System.out.println("*** Ellipsoid added ***\n");
               break;
            case 'D' :
               System.out.print("\tlabel: ");
               label = s.nextLine();              
               
               Ellipsoid name = appList.findEllipsoid(label);
               System.out.println(appList.findEllipsoid(label) != null 
                  ? 
                  "\t\"" + name.getLabel() 
                  + "\"" + " deleted\n" : "\t\"" + label 
                  + "\"" + " not found\n");
               appList.deleteEllipsoid(label);
     
              
               break;
            case 'F' :
               System.out.print("\tlabel: ");
               label = s.nextLine();
               Ellipsoid finded = appList.findEllipsoid(label);
               System.out.println(appList.findEllipsoid(label) != null 
                  ?
                  finded.toString() : "\t\"" 
                  + label + "\"" + " not found\n");
               break;
              
            case 'E':
               System.out.print("\tlabel: ");
               label = s.nextLine();
               System.out.print("\ta: ");
               a = Double.parseDouble(s.nextLine());
               System.out.print("\tb: ");
               b = Double.parseDouble(s.nextLine());
               System.out.print("\tc: ");
               c = Double.parseDouble(s.nextLine());
               Ellipsoid findE = appList.findEllipsoid(label);
               System.out.println(
                  appList.editEllipsoid(label, a, b, c) != null 
                  ? 
                  "\t\"" + findE.getLabel() + "\"" 
                  + " successfully edited\n" : "\t\"" + label 
                  + "\"" + " not found\n");
               Ellipsoid edit = appList.editEllipsoid(label, a, b, c);
               break;
              
            case 'Q':
               break;
              
              
            default:
               System.out.println("\t*** invalid code ***\n");
               break;
              
         }
      } while (!userInput.equalsIgnoreCase("Q")); 
      
               
   } 










}