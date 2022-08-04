package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * OperatorPad is a panel that holds every button in the calculator.
 * 
 * @author team23
 * @version 1
 */
public class OperatorPad extends JPanel
{

  /**
   * Button frame ID.
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * Display.
   */
  private ActionListener listener;
  
  /**
   * Font for the buttons.
   */
  private final Font buttonfont = new Font("Lucida Grande", Font.PLAIN, 20);

  /**
   * OperatorPad constructor uses the setupLayout helper to create each button and add
   * ActionListeners to the panel.
   * 
   * @param listener
   *          associated with the panel
   * @param color incoming
   */
  public OperatorPad(final ActionListener listener, Color color)
  {
    super();
    this.listener = listener;
    setupLayout(color);
  }

  /**
   * setupLayout is a helper that is used to create and add each button to the OperatorPad.
   */
  private void setupLayout(Color color)
  {
    JButton plusMinus = button("\u00B1", 42, 180, 50, 50, color);
    add(plusMinus);
    JButton clear = button("C", 104, 180, 50, 50, color);
    add(clear);
    JButton restart = button("R", 165, 180, 50, 50, color);
    add(restart);
    JButton plus = button("+", 251, 180, 50, 50, color);
    add(plus);
    JButton minus = button("-", 251, 242, 50, 50, color);
    add(minus);
    JButton multiply = button("*", 251, 304, 50, 50, color);
    add(multiply);
    JButton divide = button("/", 251, 366, 50, 50, color);
    add(divide);
    JButton equals = button("=", 251, 428, 50, 50, color);
    add(equals);
    JButton backspace = button("\u232B", 165, 428, 50, 50, color);
    add(backspace);
    JButton zero = button("0", 42, 428, 111, 50, color);
    add(zero);
    JButton one = button("1", 42, 366, 50, 50, color);
    add(one);
    JButton two = button("2", 104, 366, 50, 50, color);
    add(two);
    JButton three = button("3", 165, 366, 50, 50, color);
    add(three);
    JButton four = button("4", 42, 304, 50, 50, color);
    add(four);
    JButton five = button("5", 104, 304, 50, 50, color);
    add(five);
    JButton six = button("6", 165, 304, 50, 50, color);
    add(six);
    JButton seven = button("7", 42, 242, 50, 50, color);
    add(seven);
    JButton eight = button("8", 104, 242, 50, 50, color);
    add(eight);
    JButton nine = button("9", 165, 242, 50, 50, color);
    add(nine);
    JButton histMenu = button(">", 385, 255, 29, 29, color);
    add(histMenu);
    JButton integer = button("^", 313, 180, 50, 50, color);
    add(integer);
    JButton inverse = button("1/x", 313, 242, 50, 50, color);
    add(inverse);
    /**
     * JButton lParenthesis = button("(", 313, 304, 50, 50, color); add(lParenthesis); JButton
     * rParenthesis = button(")", 313, 366, 50, 50, color); add(rParenthesis);
     */

  }

  /**
   * button helper that helps create the buttons.
   * 
   * @param text
   *          the text displayed in the button
   * @param x
   *          position of the button on the x axis
   * @param y
   *          position of the button on the y axis
   * @param w
   *          width of the button
   * @param h
   *          height of the button
   * @return JButton that has each of the attributes from the parameter
   */
  private JButton button(final String text, final int x, final int y, final int w, final int h,
      Color color)
  {
    JButton button = new JButton(text);
    button.setFont(buttonfont);
    button.setBounds(x, y, w, h);
    button.addActionListener(listener);
    button.setBackground(color);
    button.setFocusable(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    return button;
  }
}
