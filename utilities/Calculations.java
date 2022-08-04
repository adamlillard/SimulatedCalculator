package utilities;

/**
 * Simple calculations class.
 * 
 * @author team23
 * @version 05/04/2022
 */
public class Calculations {

  /**
   * Multiply function.
   * 
   * @param x incoming
   * @param y incoming
   * @return multiple
   */
  public static double multiply(double x, double y) {
    return (x * y);
  }

  /**
   * Division function.
   * 
   * @param x incoming
   * @param y incoming
   * @return divide
   */
  public static double divide(double x, double y) {
    if (y == 0) {
      throw new IllegalArgumentException("Undefined");
    }
    return (x / y);
  }

  /**
   * Addition function.
   * 
   * @param x incoming
   * @param y incoming
   * @return add
   */
  public static double add(double x, double y) {
    return (x + y);
  }

  /**
   * Subtract function.
   * 
   * @param x incoming
   * @param y incoming
   * @return subtract
   */
  public static double subtract(double x, double y) {
    return (x - y);
  }
  
  /**
   * Inverse function.
   * 
   * @param x incoming
   * @return inverse
   */
  public static double inverse(double x) {
    return (1/x);
  }
  
  /**
   * Power function.
   * 
   * @param x incoming
   * @param y incoming
   * @return power
   */
  public static double power(double x, double y) {
    return Math.pow(x, y);
  }
}
