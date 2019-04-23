/* PokerGUI creates a functional, multipurpose interface for users to interact
 * with the poker game.
 *
 */

import java.awt.*; 
import javax.swing.*;
import java.util.*;



public class PokerGUI
{

    public static void main(String[] args)
    {
	EventQueue.invokeLater(() ->
		{
		    CardGUI gui = new CardGUI();
		    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    gui.setVisible(true);
		    gui.setTitle("Quick Poker");
		    gui.setBackground(Color.red);
		});
    }
}


class CardGUI extends JFrame 
{
    // prevents throwing serialVersionUID error
   private static final long serialVersionUID = 1234567890;

    // Frame Size Values dependent on size of screen
   /*Toolkit kit = Toolkit.getDefaultToolkit();
   Dimension screenSize = kit.getScreenSize();
   int screenHeight = screenSize.height;
   int screenWidth = screenSize.width;
   */

    // DEFAULT SIZE VALUES 
   private static final int DEFAULT_WIDTH = 800;
   private static final int DEFAULT_HEIGHT = 600;


   public CardGUI()
   {
       setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
       setLocationByPlatform(true);
   }

    
    
}//end of Poker class
