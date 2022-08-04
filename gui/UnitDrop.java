package gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import utilities.*;

/**
 * This class represents the unit drop-down in the input display.
 * 
 * @author team23
 * @version 04/20/2022
 */
@SuppressWarnings("rawtypes")
public class UnitDrop extends JComboBox
{

  /**
   * List of length conversions.
   */
  private Length[] lengths;
  
  /**
   * List of money conversions.
   */
  private Money[] currencies;
  
  /**
   * List of time conversions.
   */
  private Time[] times;
  
  /**
   * List of volume conversions.
   */
  private Volume[] volumes;
  
  /**
   * List of weight conversions.
   */
  private Weight[] weights;

  /**
   * Display.
   */
  private ActionListener l;

  private final static String ALL = "ALL";

  /**
   * Dropdown ID.
   */
  static private final long serialVersionUID = 6090617072604431566L;

  /**
   * Constructor.
   * 
   * @param l
   *          incoming display
   */
  public UnitDrop(final ActionListener l)
  {
    super();

    lengths = utilities.Length.values();
    currencies = utilities.Money.values();
    times = utilities.Time.values();
    volumes = utilities.Volume.values();
    weights = utilities.Weight.values();

    this.l = l;
    setupLayout();
  }

  /**
   * Setup the layout of the drop-down menu.
   */
  @SuppressWarnings("unchecked")
  private void setupLayout()
  {
    updateDisplay(ALL);
    setToolTipText("Select Unit");
    setBackground(Color.LIGHT_GRAY);
    setBounds(300, 110, 60, 57);
    setEditable(true);
    addActionListener(l);
  }

  /**
   * Display for a specific set of units.
   * 
   * @param version
   *          is the recent expressions in the display
   */
  @SuppressWarnings("unchecked")
  public void updateDisplay(final String version)
  {

    removeAllItems();
    addItem("");

    if (version.equals(ALL))
    {
      addAll();
    }
    else
    {
      if (version.equals("LENGTH"))
      {
        for (Length length : lengths)
        {
          addItem(length.getUnit());
        }
      }
      else if (version.equals("MONEY"))
      {
        for (Money money : currencies)
        {
          addItem(money.getUnit());
        }
      }
      else if (version.equals("TIME"))
      {
        for (Time time : times)
        {
          addItem(time.getUnit());
        }
      }
      else if (version.equals("VOLUME"))
      {
        for (Volume volume : volumes)
        {
          addItem(volume.getUnit());
        }
      }
      else if (version.equals("WEIGHT"))
      {
        for (Weight weight : weights)
        {
          addItem(weight.getUnit());
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void addAll()
  {
    for (Length length : lengths)
    {
      addItem(length.getUnit());
    }

    /**for (Money money : currencies)
    {
      addItem(money.getUnit());
    }

    for (Time time : times)
    {
      addItem(time.getUnit());
    }

    for (Volume volume : volumes)
    {
      addItem(volume.getUnit());
    }

    for (Weight weight : weights)
    {
      addItem(weight.getUnit());
    }
    */
  }

  /**
   * Reset to default.
   */
  public void resetText()
  {
    ((JTextField) getEditor().getEditorComponent()).setText("");
  }

  /**
   * Simple getter.
   * 
   * @return current text
   */
  public String getCurrentText()
  {
    return ((JTextField) getEditor().getEditorComponent()).getText();
  }
}
