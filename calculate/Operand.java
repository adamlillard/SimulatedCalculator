package calculate;

/**
 * Operand class.
 * 
 * @author team23
 * @version 05/04/2022
 */
public class Operand
{
  private String units;
  private double value;
  private boolean isDash;
  private boolean isSlash;
  private String defined;

  /**
   * This is the constructor for operands.
   * 
   * @param value
   *          the number value of the operand.
   * @param units
   *          the type of units of the operand.
   */
  public Operand(double value, String units)
  {
    this.value = value;

    if (units == null)
      return;

    if (units.contains("-") && units.contains("/"))
    {
      throw new IllegalArgumentException();
    }

    if (units.contains("-"))
      isDash = true;

    if (units.contains("/"))
      isSlash = true;

    this.units = units;
    this.value = value;
    this.defined = "";
  }

  /**
   * This method returns the operand as a String.
   * 
   * @return The value and unit of the Operand.
   */
  public String toString()
  {
    if (this.units == null)
      return "" + this.value;

    return this.value + " " + this.units;
  }

  /**
   * This is a getter method.
   * 
   * @return true/false
   */
  public boolean isSlash()
  {
    return isSlash;
  }

  /**
   * This is a getter method.
   * 
   * @return true/false
   */
  public boolean isDash()
  {
    return isDash;
  }

  /**
   * This is a getter method.
   * 
   * @return value
   */
  public double getValue()
  {
    return this.value;
  }

  /**
   * This is a getter method.
   * 
   * @return unit
   */
  public String getUnits()
  {
    return this.units;
  }

  /**
   * Get the defined key.
   * 
   * @return key
   */
  public String getDefined()
  {
    return defined;
  }

  /**
   * Set the defined key.
   * 
   * @param incoming incoming
   */
  public void setDefined(final String incoming)
  {
    this.defined = incoming;
  }
}
