package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * History is used by the calculator to save recent expressions.
 * 
 * @author team23
 * @version 1
 */
public class History extends JDialog
{
  /**
   * x coordinate for JDialog.
   */
  private final int openX = -8;
  
  /**
   * Width.
   */
  private final int width = 250;
  
  /**
   * Height.
   */
  private final int height = 400;
  
  /**
   * Counter.
   */
  private int counter;
  
  /**
   * x coordinate with closed history panel.
   */
  private final int closeX = openX - width;

  /**
   * Offset of y-position.
   */
  private final int yOffset = 50;

  /**
   * Content history.
   */
  private JPanel historyContent;

  /**
   * If the animation works.
   */
  private static boolean isAnimating;
  
  /**
   * If the history panel is open.
   */
  private boolean isOpen;

  /**
   * current x position.
   */
  private int currX;

  /**
   * History contructor creates the history tab and changes its color.
   * 
   * @param color
   *          changes the color of the history tab
   */
  public History(Color color)
  {
    setSize(new Dimension(width, height));
    setUndecorated(true);
    currX = closeX;
    isAnimating = false;
    isOpen = false;
    counter = 1;

    historyContent = new JPanel();
    historyContent.setSize(new Dimension(width - 100, height - 100));
    historyContent.setBackground(color);
    historyContent.setLayout(new BoxLayout(historyContent, BoxLayout.Y_AXIS));
    add(historyContent);
  }

  /**
   * Add content to history bar.
   * 
   * @param history incoming
   */
  public void addContent(String history)
  {
    System.out.println("this: " + history);
    historyContent.add(new JLabel("     " + counter++ + ": " + history));
    historyContent.validate();
    validate();
  }

  /**
   * This is a getter method.
   * 
   * @return A jpanel with all history content.
   */
  public JPanel getHistoryContent()
  {
    return this.historyContent;
  }

  /**
   * Sets the location of the history when it slides out and in.
   * 
   * @param x incoming
   * @param y incoming
   */
  public void setHistoryLocation(int x, int y)
  {
    setLocation(x + currX, y + yOffset);
  }

  /**
   * Creates the animation of the history tab.
   */
  public void toggleAnimate()
  {
    if (isAnimating)
      return;

    isAnimating = true;

    int frames = 30;
    int interval = 30;

    int target = isOpen ? closeX : openX;

    int diff = !isOpen ? width : -width;

    new Timer(interval, new ActionListener()
    {
      int currentFrame = 0;

      @Override
      public void actionPerformed(ActionEvent e)
      {
        int diffChange = (int) Math.floor(diff * (1. / frames));
        currX += diffChange;
        setLocation(getLocation().x + diffChange, getLocation().y);
        if (currentFrame != frames)
        {
          currentFrame++;
        }
        else
        {
          setLocation(getLocation().x + (target - currX), getLocation().y);
          currX = target;
          isOpen = !isOpen;
          ((Timer) e.getSource()).stop();
          isAnimating = false;
        }
      }
    }).start();
  }
}
