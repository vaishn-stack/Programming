// Program to demonstrate concept of adapter class

import java.awt.*;
import java.awt.event.*;

class AWT_Frame6 extends Frame
{
	AWT_Frame6(String name)	
	{
		// call Frame class constructor
		super(name);
	}

	public static void main(String args[])
	{
		// Create new frame
		AWT_Frame6 f = new AWT_Frame6("Marvellous Infosystems");
		
		// Decide size of that Frame
		f.setSize(500,500);

		// Display that frame
		f.setVisible(true);
		
		// Add action listener to frame
		// Pass the object of class which implments WindowListener
		f.addWindowListener(new WindowHandler6());	
	}
}

// Class which extends windowAdapter
class WindowHandler6 extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}