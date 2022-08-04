package utilities;
/**
 * All conversions for time in hours.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 *
 */
public enum Time implements UnitInterface
{ 
  
  SEC("sec", 0.00027777778), HR("hr", 1.0), DAY("day", 24.0), 
  MON("mon", 730.484397), YR("yr", 8765.81278);
  
  private final String unit;
  private final double value;

  Time(final String unit, final double value)
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
