package gui;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.awt.print.*;

/**
 * This is the main class for all menubar related objects.
 * 
 * @author team23
 */
public class MenuBar extends JMenuBar
{
  /**
   * Display bar. (input, display fields)
   */
  Display display;

  /**
   * This is the default constructor.
   * 
   * @throws IOException
   *           if help.html file does not open
   *           
   * @param display incoming
   */
  public MenuBar(Display display) throws IOException
  {
    super();
    setUp();
    this.display = display;
  }

  /**
   * This method creates all the items inside of the menu bar.
   */
  private void setUp()
  {
    // This sets up all the actions of the menu

    AbstractAction printerAction = new AbstractAction("Print")
    {
      public void actionPerformed(ActionEvent e)
      {
        JTextPane jtp = new JTextPane();
        jtp.setText(display.expression.getHistory());
        try
        {
          jtp.print();
        }
        catch (PrinterException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

      }
    };

    AbstractAction helpAction = new AbstractAction("Help")
    {

      public void actionPerformed(ActionEvent e)
      {

        try
        {
          // File htmlFile = new File(url.toURI());
          // File htmlFile = new File(url.toURI());
          Desktop.getDesktop()
              .open(new File(this.getClass().getResource("BlogPostAssets/help.html").getPath()));
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
      }
    };

    AbstractAction aboutAction = new AbstractAction("About")
    {
      public void actionPerformed(ActionEvent e)
      {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("About");
        JOptionPane.showMessageDialog(jFrame, "Version: 1.0\nProperty of Sagacious Media", "About",
            JOptionPane.PLAIN_MESSAGE);
      }
    };

    //

    JMenuItem help = new JMenuItem(helpAction);
    JMenuItem about = new JMenuItem(aboutAction);

    JMenu fileMenu = new JMenu("File");
    JMenu aboutMenu = new JMenu("Help");

    aboutMenu.add(about);

    fileMenu.add(new JMenuItem(printerAction));

    add(fileMenu);
    add(aboutMenu);
  }

}
