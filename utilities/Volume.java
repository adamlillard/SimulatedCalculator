package utilities;

/**
 * All conversions for volumes in quarts.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 */
public enum Volume implements UnitInterface
{

  PT("pt", 1.99999989), QT("qt", 1.0), GAL("gal", 0.25), CC("cc", 946.352946), L("l", 0.946352946);

  private final String unit;
  private final double value;

  /**
   * Volume constructor initializes the units and value.
   */
  Volume(final String unit, final double value)
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
