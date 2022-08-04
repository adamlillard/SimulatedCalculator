package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import calculate.Expression;
import calculate.ExpressionManager;
import utilities.Calculations;

/**
 * Display holds the display and input fields, the history tab button, and Unit Droppers.
 * 
 * @author team23
 * @version 1
 */
public class Display extends JPanel implements ActionListener
{
  /**
   * History.
   */
  History history;
  
  /**
   * String of previous expression.
   */
  String prevExpression;
  
  /**
   * Input field.
   */
  protected JTextField inputField;
  
  /**
   * Display field.
   */
  protected JTextField displayField;
  
  /**
   * Predefined units.
   */
  protected UnitDrop comboBox = new UnitDrop(this);
  
  /**
   * Result units.
   */
  protected UnitDrop comboBox2 = new UnitDrop(this);

  /**
   * Display frame ID.
   */
  private static final long serialVersionUID = 1L;

  private final static String CLEAR = "C";
  private final static String RESET = "R";
  private final static String PLUS = "+";
  private final static String MINUS = "-";
  private final static String MULTIPLY = "*";
  private final static String DIVIDE = "/";
  private final static String POWER = "^";
  private final static String EQUAL = "=";
  private final static String HISTORY = ">";
  private final static String BACKSPACE = "\u232B";
  private final static String POSNEG = "\u00B1";
  private final static String INVERSE = "1/x";

  /**
   * Expression manager.
   */
  ExpressionManager expression = new ExpressionManager();

  /**
   * Display constructor uses a helper method setupLayout to setup the display.
   * 
   * @param history incoming
   * @param color incoming
   */
  public Display(final History history, Color color)
  {
    super();
    setupLayout();
    prevExpression = "";
    displayField.setBackground(color);
    this.history = history;
  }

  /**
   * setupLayout is a helper method that is used to initialize the input and display fields, and
   * history tab.
   */
  private void setupLayout()
  {
    inputField = new JTextField("");
    inputField.setText("");
    inputField.setEditable(false);
    inputField.setBounds(42, 110, 259, 58);
    inputField.setHorizontalAlignment(JTextField.CENTER);
    inputField.setColumns(10);

    displayField = new JTextField("");
    displayField.setText("");
    displayField.setEditable(false);
    displayField.setBackground(Color.PINK);
    displayField.setBounds(42, 40, 316, 58);
    displayField.setColumns(10);

    comboBox2.setBounds(354, 40, 60, 57);
  }

  /**
   * actionPerformed handles action listeners case by case and responds accordingly.
   * 
   * @param e
   *          action event taken in by the listener
   */
  public void actionPerformed(final ActionEvent e)
  {
    String ac = e.getActionCommand();

    switch (ac)
    {
      case CLEAR:
        inputField.setText("");
        break;

      case RESET:
        fullReset();
        break;

      case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0":
        String tempInputString = inputField.getText();
        if (tempInputString == null || tempInputString.equals(""))
        {
          inputField.setText(ac);
        }
        else
        {
          tempInputString += ac;
          inputField.setText(tempInputString);
        }
        break;

      case BACKSPACE:
        String str = inputField.getText();
        inputField.setText("");
        for (int i = 0; i < str.length() - 1; i++)
        {
          inputField.setText(inputField.getText() + str.charAt(i));
        }
        break;

      case POSNEG:
        double temp = Double.parseDouble(inputField.getText().strip());
        temp *= -1;
        inputField.setText(String.valueOf(temp));
        break;

      case PLUS, MINUS, MULTIPLY, DIVIDE, POWER:
        if (expressionAdd())
        {
          expression.addOperator(ac);
          updateDisplay();
        }
        break;

      case EQUAL:
        if (expressionAdd())
        {
          if (!expression.getCurrExpression().getOperands()[0].getDefined()
              .equals(expression.getCurrExpression().getOperands()[1].getDefined()))
          {
            fullResetError();
          }
          else
          {
            expression.getCurrExpression().setResultUnit(getUnitDropper2().getCurrentText());
            expression.addOperator(ac);
            updateDisplay();
          }
        }
        break;

      case INVERSE:
        double tempInv = Double.parseDouble(inputField.getText().strip());
        tempInv = Calculations.inverse(tempInv);
        inputField.setText(String.valueOf(tempInv));
        // expressionAdd();
        // updateDisplay();
        break;

      case HISTORY:
        history.toggleAnimate();
        break;
      default:
        break;
    }
  }

  /**
   * updateDisplay puts the text into the display field and history tab while also clearing the
   * input field.
   * 
   * @param pressedEquals
   */
  private void updateDisplay()
  {
    displayField.setText(expression.toString());
    inputField.setText("");
    if (!prevExpression.equals(expression.getLastExpression()))
    {
      prevExpression = expression.getLastExpression();
      history.addContent(prevExpression);
    }
  }

  /**
   * This method attempts to take the current unit and create an expression.
   * 
   * @return true if expression was added successfully & false otherwise
   */
  private boolean expressionAdd()
  {
    // String[] data = inputField.getText().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    String data = getUnitDropper().getCurrentText();
    char[] chars = data.toCharArray();

    try
    {
      if (chars.length == 0)
      {
        expression.addOperand(Double.parseDouble(inputField.getText()), "");
      }
      else if (checkForSlashDash(chars))
      {
        fullResetError();
        return false;
      }
      else
      {

        Expression curr = expression.getCurrExpression();
        String defined = utilities.UnitConversions.findPredefinedUnit(data.strip(), "");

        if (curr.getOperands()[0] == null)
        {
          expression.addOperand(Double.parseDouble(inputField.getText()), data.strip());
          curr.getOperands()[0].setDefined(defined);
        }
        else if (curr.getOperands()[1] == null)
        {
          expression.addOperand(Double.parseDouble(inputField.getText()), data.strip());
          curr.getOperands()[1].setDefined(defined);
        }

        getUnitDropper2().updateDisplay(defined);

      }
    }
    catch (

    NumberFormatException c)
    {
      fullResetError();
    }

    getUnitDropper().resetText();
    return true;
  }

  /**
   * Helper method to do a full reset of ui.
   */
  private void fullReset()
  {
    inputField.setText("");
    displayField.setText("");
    expression.getCurrExpression().setNull();
    comboBox.resetText();
    comboBox2.resetText();
  }

  /**
   * Helper method to reset all but input.
   */
  @SuppressWarnings("unused")
  private void mostReset()
  {
    displayField.setText("");
    expression.getCurrExpression().setNull();
  }

  /**
   * Helper method to do a full reset and throw error.
   */
  private void fullResetError()
  {
    inputField.setText("");
    displayField.setText("ERROR!");
    expression.getCurrExpression().setNull();
  }

  /**
   * Check if the incoming array of characters adds up to a valid unit.
   * 
   * @param chars
   * @return true if invalid
   */
  private boolean checkForSlashDash(final char[] chars)
  {
    if (chars[chars.length - 1] == '/' || chars[chars.length - 1] == '-')
    {
      return true;
    }

    return false;
  }

  /**
   * Basic getter for the inputField text box.
   * 
   * @return JTextField represented as the inputField
   */
  public JTextField getInputField()
  {
    return inputField;
  }

  /**
   * Basic getter for the displayField text box.
   * 
   * @return JTextField represented as the displayField
   * 
   */
  public JTextField getDisplayField()
  {
    return displayField;
  }

  /**
   * Basic getter for the inputField Unit selector.
   * 
   * @return JComboBox represented as the comboBox
   */
  public UnitDrop getUnitDropper()
  {
    return comboBox;
  }

  /**
   * Basic getter for the displayField Unit selector.
   * 
   * @return JComboBox represented as the comboBox
   */
  public UnitDrop getUnitDropper2()
  {
    comboBox2.setEditable(false);
    comboBox2.updateDisplay("");
    return comboBox2;
  }
}
