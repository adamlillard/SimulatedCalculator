package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Calculator is used as the main Jframe window which has all of the components inside.
 * 
 * @author team23
 * @version 1
 */
public class Calculator extends JFrame implements ComponentListener, MouseListener
{
  /**
   * 
   */
  private static final long serialVersionUID = -5685371610364263161L;
  
  /**
   * Calculator history.
   */
  History history;
  
  /**
   * Calculator display.
   */
  Display display;
  
  /**
   * Calculator reader.
   */
  Scanner configFile;
  
  /**
   * Calculator constructor puts together the operator pad, display, and menu bar into one JFrame.
   * 
   * @throws IOException exception
   * @throws URISyntaxException exception
   * 
   * @param color incoming
   */
  public Calculator(Color color) throws IOException, URISyntaxException
  {
    super();
    InputStream is = this.getClass().getResource("BlogPostAssets/config.txt").openStream();

    configFile = new Scanner(is);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout();

    this.addComponentListener(this);

    MenuBar bar = new MenuBar(this.display);
    setJMenuBar(bar);
    setSize(440, 540);
    setVisible(true);
  }

  /**
   * setLayout is a helper method that is used in the constructor. It it adds all components to the
   * JFrame window.
   * @throws IOException 
   */
  private void setLayout() throws IOException
  {
    Container content = getContentPane();
    setTitle("CALCULATOR");
    setBounds(100, 100, 440, 500);
    setLayout(null);

    history = new History(Color.decode(configFile.nextLine()));
    history.setVisible(true);

    display = new Display(history, Color.decode(configFile.nextLine()));

    componentMoved(null);

    OperatorPad buttons = new OperatorPad(display, Color.decode(configFile.nextLine()));
    Component[] c = buttons.getComponents();

    content.add(display.getInputField());
    content.add(display.getDisplayField());
    content.add(display.getUnitDropper());
    content.setBackground(Color.decode(configFile.nextLine()));
    content.add(display.getUnitDropper2());
    
    JPanel pic = new JPanel();
    pic.setBounds(10, 0,  100,  33);
    content.add(pic);

    // BufferedImage img = ImageIO.read(new File("logo.png"));
    URL url = this.getClass().getResource("photosCalc/logo.png");
    BufferedImage img = ImageIO.read(url);

    Image scaledImg = img.getScaledInstance(100, 33, 0);
    JLabel logo = new JLabel(new ImageIcon(scaledImg));
    pic.add(logo);

    for (Component l : c)
    {
      content.add(l);
    }

    addKeyListener(new KeyAdapter()
    {
      @SuppressWarnings("static-access")
      public void keyPressed(final KeyEvent e)
      {

        display.actionPerformed(new ActionEvent(e, e.getID(), Character.toString(e.getKeyChar())));

        if (Character.toString(e.getKeyChar()).equals("r"))
        {
          display.actionPerformed(new ActionEvent(e, e.getID(), "R"));
        }
        else if (Character.toString(e.getKeyChar()).equals("c"))
        {
          display.actionPerformed(new ActionEvent(e, e.getID(), "C"));
        }
        else if (e.getKeyCode() == e.VK_BACK_SPACE)
        {
          display.actionPerformed(new ActionEvent(e, e.getID(), "\u232B"));
        }
        else if (e.getKeyCode() == e.VK_ENTER)
        {
          display.actionPerformed(new ActionEvent(e, e.getID(), "="));
        }

      }
    });
    setFocusable(true);
    
    addMouseListener(this);
  }



  @Override
  public void componentResized(final ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentMoved(final ComponentEvent e)
  {
    int x = this.getX() + this.getWidth();
    int y = this.getY();

    history.setHistoryLocation(x, y);
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
      requestFocusInWindow();
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
    // TODO Auto-generated method stub
    
  }
}
