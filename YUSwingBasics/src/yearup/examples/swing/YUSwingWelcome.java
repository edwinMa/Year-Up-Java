package yearup.examples.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class YUSwingWelcome extends JFrame {
	
	// set some constants for the width and height of the main window frame
	private static int FrameWidth = 400;
	private static int FrameHeight = 200;
	
	private static int TextFieldLen = 20; // constant for width of text fields
	
	protected JTextField nameText;
	protected JTextField homeText;
	protected JLabel welcomeLabel;
	protected JButton enterButton;
	protected JButton clearButton;
	protected JButton doneButton;
	
	public YUSwingWelcome()
	{
		// set the size of the main window frame
		setSize (FrameWidth, FrameHeight);
		
		// set the layout manger for the main window frame
		// a GridLayout with a row of 0 and column of 1 will let me 
		// add as many rows as I want, but keep everything vertically aligned in a 
		// single column
		setLayout (new GridLayout(0,1));
		
		// create the name panel to hold the name label and name textfield
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		
		// create name label and text field
		JLabel nameLabel = new JLabel("What is your name?");
		nameText = new JTextField (TextFieldLen);
		
		// add the name label and text field to the name panel
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		// add the name panel to the main window frame
		this.getContentPane().add(namePanel);
		
		// create the from panel
		JPanel fromPanel = new JPanel();
		fromPanel.setLayout(new FlowLayout());
		
		// create the from label and text field
		JLabel homeLabel = new JLabel("Where are you from?");
		homeText = new JTextField (TextFieldLen);
		
		// add the from label and textfield to the from panel
		fromPanel.add(homeLabel);
		fromPanel.add(homeText);
		
	
		// add the from panel to the main window frame
		this.getContentPane().add(fromPanel);
		
		// create a button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		// create an enter button and add it to the button panel
		enterButton = new JButton ("Enter");
		buttonPanel.add(enterButton);
		
		// create an enter button and add it to the button panel
		clearButton = new JButton ("Clear");
		buttonPanel.add(clearButton);
		
		// create a done button and add it to the button panel
		doneButton = new JButton ("Done");
		buttonPanel.add(doneButton);
		
		// add the button panel to the main window frame
		this.getContentPane().add(buttonPanel);
		
		// create a welcome panel
		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(new FlowLayout());
		
		// create a welcome label and add it to the welcome panel
		// note the label text is initially blank since we dont want anything
		// to show up until the user presses enter
		welcomeLabel = new JLabel("");
		welcomePanel.add(welcomeLabel);
		
		
		// add the welcome panel to the main window frame
		this.getContentPane().add(welcomePanel);
		
		// add an action listener to the enter button so we can do 
		// something when the user clicks the button
		enterButton.addActionListener (new YUButtonHandler(this));
		
		// add an action listener to the enter button so we can do 
		// something when the user clicks the button
		clearButton.addActionListener (new YUButtonHandler(this));
		
		// add an action listener to the enter button so we can do 
		// something when the user clicks the button
		doneButton.addActionListener (new YUButtonHandler(this));
		/*
		 * note that the enter, clear and done buttons above use the same button event handler
		 * the YUButtonHandler class will differentiate its actions based on which button was clicked
		 */
		
		// set the main window frame to visible so we can see it
		setVisible (true);
	}
	
	protected void exit()
	{
		System.out.println("Good bye");
		System.exit(0);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		YUSwingWelcome frame = new YUSwingWelcome();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		    	frame.exit();
		    }
		});
	}

}
