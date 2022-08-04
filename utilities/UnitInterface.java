package utilities;

/**
 * Interface for all units.
 * 
 * @author Ian Gregory
 * @version 04/29/2022
 *
 */
public interface UnitInterface
{
  /**
   * Simple getter for unit name.
   * 
   * @return unit type
   */
  String getUnit();
  
  /**
   * Simple getter for conversion.
   * 
   * @return unit conversion
   */
  double getValue();
}
