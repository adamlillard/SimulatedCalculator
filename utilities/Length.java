package utilities;

/**
 * All conversions for lengths in feet.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 */
public enum Length implements UnitInterface
{
  IN("in", 12.0), FT("ft", 1.0), YD("yd", 0.33333333333333333),
  MM("mm", 304.8), CM("cm", 30.48), M("m", 0.3048), 
  MI("mi", 0.0001893939), KM("km", 0.0003048);

  private final String unit;
  private final double value;

  Length(final String unit, final double value)
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
