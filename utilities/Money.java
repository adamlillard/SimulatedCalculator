package utilities;
/**
 * All conversions for money in dollars.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 */
public enum Money implements UnitInterface
{
  
  C("c", 0.01), $("$", 1.0);
  
  private final String unit;
  private final double value;

  Money(final String unit, final double value)
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
