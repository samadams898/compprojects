import java.text.DecimalFormat;
/** Ellipsoid class. Defines parameters and methods of EllipsoidApp.
*
*Project08
*@author Samuel Adams
*@version 03/20/2020
*/

public class Ellipsoid {

   private static int count = 0;
   private double a = 0; 
   private double  b = 0; 
   private double c = 0; 
   private String label = "";
  /** Ellipsoid methods. 
                         @param labelIn used
                         @param aIn used
                         @param bIn used
                         @param cIn used
  */ 
   public Ellipsoid(String labelIn, double aIn, double bIn, double cIn)  {
      setLabel(labelIn);
      setA(aIn);
      setB(bIn);
      setC(cIn);
      count++;
   }
   /** Converts to string.
      @return String
   */
   public String toString() {
      DecimalFormat  df = new DecimalFormat("#,##0.0###");
      String output = "Ellipsoid " + "\"" + label + "\"" + " with axes a = " 
         + a + ", b = " 
         + b + ", c = " + c + " units has:"
         + "\n\tvolume = " + df.format(volume()) + " cubic units"
         + "\n\tsurface area = " + df.format(surfaceArea()) + " square units";
      return output;
   }
   /** getLabel method. 
   @return label.*/
   public String getLabel() {
      return label;
   }
   /** checks if label contains string value.
      @return label
      @param labelIn label*/
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      }
   }
   /** Sets A variable.
       @return setA 
       @param aIn . */
   public boolean setA(double aIn) {
      if (aIn > 0) {
         a = aIn;
         return true;
      }
      else {
      
         return false;
      }
   }
   /** Gets A.
       @return a */
   public double getA() {
      return a;
   }
   /** Sets B.
      @param bIn input B
      @return B */
   public boolean setB(double bIn) {
      if (bIn > 0) {
         b = bIn;
         return true;
      }
      else {
      
         return false;
      }
   }
   /** gets B.
       @return b */
   public double getB() {
      return b;
   }
   /** sets C.
      @param cIn input C
      @return c */
   public boolean setC(double cIn) {
      if (cIn > 0) {
         c = cIn;
         return true;
      }
      else {
      
         return false;
      }
   }
   /** gets C.
      @return c */
   public double getC() {
      return c;
   }
   /** Volume method. Calculates volume
      @return volume */
   public double volume() {
      double vol = ((4 * Math.PI * a * b * c) / 3);
      return vol;
   }
   /** Surface Area method. Calculates Surface Area.
      @return sur */
   public double surfaceArea() {
      double sur = (4 * Math.PI * (Math.pow((((Math.pow((a * b), 1.6)) 
         + (Math.pow((a * c), 1.6)) 
         + (Math.pow((b * c), 1.6))) / 3), 1 / 1.6)));
      return sur;
   
   }
   /** get Count method.
   @return countE */
   public static int getCount() {
      int countE = count;
      return countE;
   }
   /** resetCount method.*/
   public static void resetCount() {
      count = 0;
 
   }
   /** equals method.
   @return boolean
   @param obj object */
   public boolean equals(Object obj) {
   
      if (!(obj instanceof Ellipsoid)) {
         return false;
      }
      else {
         Ellipsoid e = (Ellipsoid) obj;
         return (label.equalsIgnoreCase(e.getLabel())
            && Math.abs(a - e.getA()) < .000001
            && Math.abs(b - e.getB()) < .000001
            && Math.abs(c - e.getC()) < .000001);
      }
   }
    /**  hashcode method.
    @return 0 */
   public int hashCode() {
    
      return 0;
   }
   
   
   
   
   
}
   

