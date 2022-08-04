package calculate;

/**
 * Units represents the units available in the calculator.
 * 
 * @author Ian
 * @version 1
 */
public enum Units
{
  
  IN("in", 1.0), FEET("ft", 12.0), YARD("yd", 36.0), CM("cm", 0.3937007874), M("m", 39.3700787);

  private final String unit;
  private final double conversion;

  /**
   * Units constructor creates the unit and adds the unit and conversion number.
   */
  private Units(final String unit, final double conversion)
  {
    this.unit = unit;
    this.conversion = conversion;
  }

  /**
   * Grabs the name of the unit.
   * 
   * @return String value representing the type of unit.
   */
  public String getUnit()
  {
    return unit;
  }

  /**
   * Grabs the conversion number of the unit.
   * 
   * @return double value representing the conversion number
   */
  public double getConversion()
  {
    return conversion;
  }

}
