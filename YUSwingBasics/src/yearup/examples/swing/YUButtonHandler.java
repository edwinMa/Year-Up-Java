package yearup.examples.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class YUButtonHandler implements ActionListener
{
	YUSwingWelcome myFrame;
	
	// create a new constructor that gives us access to the parent window's frame
	public YUButtonHandler (YUSwingWelcome mainFrame)
	{
		myFrame = mainFrame;
	}

	/*
	 * This class implements the ActionListener interface and so it we must have an
	 * actionPerformed method to handle the button events from the main frame
	 */
	public void actionPerformed(ActionEvent event)
	{
		// check the ActionEvent source to figure out which button was clicked
		JButton clickedButton = (JButton)event.getSource();
		
		if (clickedButton == myFrame.enterButton)
		{
			// enter button was clicked
			handleEnterButtonClicked();
		}
		else if (clickedButton == myFrame.clearButton)
		{
			// clear button was clicked
			handleClearButtonClicked();
		}
		else 
		{
			// the done button was clicked
			myFrame.exit();
		}

	}
	
	private void handleEnterButtonClicked ()
	{
		// the enter button was pressed so get the input values from the 
		// text buttons and update the welcome label
		
		String hometown = myFrame.homeText.getText();
				
		String name = myFrame.nameText.getText();
				
		String message = null;
		if (!name.equals("") && !hometown.equals(""))
		{
			message = "Hello " + name + " from " + hometown;
					
		}
		else
		{
			// user didn't enter one of the text input values so give them a
			// notice to make sure they enter proper values
			message = "Please enter your name and where you are from";
		}
				
		myFrame.welcomeLabel.setText (message);
	}
	
	
	private void handleClearButtonClicked()
	{
		System.out.println ("Clear button clicked");
		
		// the clear button was pressed so clear everything out
		myFrame.nameText.setText("");
		myFrame.homeText.setText("");
		myFrame.welcomeLabel.setText("");
	}
}

