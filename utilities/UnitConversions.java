package utilities;

/**
 * Class to convert like units back and forth.
 * 
 * @author Ian Gregory
 * @version 05/02/2022
 */
public class UnitConversions
{

  /**
   * Conversions for lengths.
   * 
   * @param name
   * @param incoming
   * @param result
   * @return result conversion
   */
  public static double lengthConversions(final String name, final double incoming, 
      final String result) 
  {
    
    double resultConversion = incoming;
    
    Length before = null;
    Length after = null;
    
    for (Length length: Length.values()) 
    {
      if (name.equals(length.getUnit())) 
      {
        before = length;
      }
      
      if (result.equals(length.getUnit())) 
      {
        after = length;
      }
    }
    
    if (!before.equals(after) && before != null && after != null) 
    {
      if (before.equals(Length.FT)) 
      {
        resultConversion *= after.getValue();
      } else if (after.equals(Length.FT)) 
      {
        resultConversion /= before.getValue();
      } else
      {
        double temp = (resultConversion / before.getValue());
        resultConversion = temp;
        resultConversion *= after.getValue();
      }
    }
    
    return resultConversion;
  }
  
  /**
   * Conversions for currencies.
   * 
   * @param name
   * @param incoming
   * @param result
   * @return result conversion
   */
  public static double moneyConversions(final String name, final double incoming, 
      final String result) 
  {
    
    double resultConversion = incoming;
    
    Money before = null;
    Money after = null;
    
    for (Money currency: Money.values()) 
    {
      if (name.equals(currency.getUnit())) 
      {
        before = currency;
      }
      
      if (result.equals(currency.getUnit())) 
      {
        after = currency;
      }
    }
    
    if (!before.equals(after)) 
    {
      if (before.equals(Money.$))  
      {
        resultConversion *= after.getValue();
      } else 
      {
        double temp = (resultConversion / before.getValue()) * after.getValue();
        resultConversion = temp;
      }
    }
    
    return resultConversion;
  }
  
  /**
   * Conversions for times.
   * 
   * @param name
   * @param incoming
   * @param result
   * @return result conversion
   */
  public static double timeConversions(final String name, final double incoming, 
      final String result) 
  {
    
    double resultConversion = incoming;
    
    Time before = null;
    Time after = null;
    
    for (Time time: Time.values()) 
    {
      if (name.equals(time.getUnit())) 
      {
        before = time;
      }
      
      if (result.equals(time.getUnit())) 
      {
        after = time;
      }
    }
    
    if (!before.equals(after)) 
    {
      if (before.equals(Time.HR))  
      {
        resultConversion *= after.getValue();
      } else 
      {
        double temp = (resultConversion / before.getValue()) * after.getValue();
        resultConversion = temp;
      }
    }
    
    return resultConversion;
  }
  
  /**
   * Conversions for volumes.
   * 
   * @param name
   * @param incoming
   * @param result
   * @return result conversion
   */
  public static double volumeConversions(final String name, final double incoming, 
      final String result) 
  {
    
    double resultConversion = incoming;
    
    Volume before = null;
    Volume after = null;
    
    for (Volume volume: Volume.values()) 
    {
      if (name.equals(volume.getUnit())) 
      {
        before = volume;
      }
      
      if (result.equals(volume.getUnit())) 
      {
        after = volume;
      }
    }
    
    if (!before.equals(after)) 
    {
      if (before.equals(Volume.QT))  
      {
        resultConversion *= after.getValue();
      } else 
      {
        double temp = (resultConversion / before.getValue()) * after.getValue();
        resultConversion = temp;
      }
    }
    
    return resultConversion;
  }
  
  /**
   * Conversions for weights.
   * 
   * @param name
   * @param incoming
   * @param result
   * @return result conversion
   */
  public static double weightConversions(final String name, final double incoming, 
      final String result) 
  {
    
    double resultConversion = incoming;
    
    Weight before = null;
    Weight after = null;
    
    for (Weight weight: Weight.values()) 
    {
      if (name.equals(weight.getUnit())) 
      {
        before = weight;
      }
      
      if (result.equals(weight.getUnit())) 
      {
        after = weight;
      }
    }
    
    if (!before.equals(after)) 
    {
      if (before.equals(Weight.LB))  
      {
        resultConversion *= after.getValue();
      } else 
      {
        double temp = (resultConversion / before.getValue()) * after.getValue();
        resultConversion = temp;
      }
    }
    
    return resultConversion;
  }
  
  /**
   * Set a specific key if the incoming unit is predefined.
   * 
   * @param name
   * @param key
   * @return "" if not applicable
   */
  public static String findPredefinedUnit(final String name, final String key) 
  {
    String defined = key;
    
    for(Length length: Length.values()) 
    {
      if (name.equals(length.getUnit())) 
      {
        defined = "LENGTH";
        break;
      }
    }
    
    for(Money currency: Money.values()) 
    {
      if (name.equals(currency.getUnit())) 
      {
        defined = "MONEY";
        break;
      }
    }
    
    for(Time time: Time.values()) 
    {
      if (name.equals(time.getUnit())) 
      {
        defined = "TIME";
        break;
      }
    }
    
    for(Volume volume: Volume.values()) 
    {
      if (name.equals(volume.getUnit())) 
      {
        defined = "VOLUME";
        break;
      }
    }
    
    for(Weight weight: Weight.values()) 
    {
      if (name.equals(weight.getUnit())) 
      {
        defined = "WEIGHT";
        break;
      }
    }
    
    return defined;
  }
}
