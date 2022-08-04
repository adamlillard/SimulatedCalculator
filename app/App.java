package app;

import gui.*;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

import javax.swing.SwingUtilities;

/**
 * Create and run the calculator.
 * 
 * @author team23
 * @version 04/21/2022
 *
 */
public class App 
implements Runnable
{

  /**
   * Create a new calculator.
   * 
   * @param args
   *          n/a
   * @throws InterruptedException exception
   * @throws InvocationTargetException exception
   */
  public static void main(final String[] args)
      throws InterruptedException, InvocationTargetException
  {
    SwingUtilities.invokeAndWait(new App());
  }

  /**
   * Run the calculator.
   */
  public void run()
  {
    Calculator c;
    try
    {
      c = new Calculator(Color.white);
      c.setVisible(true);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    } catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
