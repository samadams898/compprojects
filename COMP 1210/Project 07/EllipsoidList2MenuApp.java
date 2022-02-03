import java.util.Scanner;

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
      Ellipsoid[] eList = new Ellipsoid[100];
      EllipsoidList2 appList = new EllipsoidList2(listName, eList, 0);
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
               System.out.print("\tFile read in and" 
                  + " Ellipsoid List created\n\n");
               break;
               
            case 'P':
 //              appList =;
               System.out.print(appList.getName() + "\n");
              // int in = 0;
            //  for (Ellipsoid e : eList) {
              // while ( in < appList.numberOfEllipsoids()) {
              // System.out.println(appList.getName());
               System.out.print(appList + "\n");
               //in++;
              // }
               //}
              
               break;
            case 'S':
               System.out.print("\n" + appList.summaryInfo() + "\n\n");
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
               System.out.print(appList.findEllipsoid(label) != null 
                  ? 
                  "\t\"" + name.getLabel()
                  + "\"" + " deleted\n\n" : "\t\"" + label 
                  + "\"" + " not found\n\n");
               appList.deleteEllipsoid(label);
     
              
               break;
            case 'F' :
               System.out.print("\tlabel: ");
               label = s.nextLine();
               Ellipsoid finded = appList.findEllipsoid(label);
               System.out.print(appList.findEllipsoid(label) != null 
                  ?
                  finded + "\n\n" : "\t\"" 
                  + label + "\"" + " not found\n\n");
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
               System.out.print(
                  appList.editEllipsoid(label, a, b, c) != null 
                  ? 
                  "\t\"" + findE.getLabel() + "\"" 
                  + " successfully edited\n\n" : "\t\"" + label 
                  + "\"" + " not found\n\n");
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