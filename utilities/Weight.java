package utilities;

/**
 * All conversions for weights in pounds.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 *
 */
public enum Weight implements UnitInterface
{

  OZ("oz", 16.0), LB("lb", 1.0), TON("ton", 0.0005), G("g", 453.59237), KG("kg", 0.45359237);

  private final String unit;
  private final double value;

  /**
   * Weight contstructor initializes the units and value.
   */
  Weight(final String unit, final double value)
  {
    this.unit = unit;
    this.value = value;
  }

  @Override
  public String getUnit()
  {
    return unit;
  }

  @Override
  public double getValue()
  {
    return value;
  }
}
