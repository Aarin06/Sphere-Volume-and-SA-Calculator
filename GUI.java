import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

import javax.swing.*;

public class GUI {
	
	int radius;	
	double SA; 
	double V;
	private JFrame frame;
	private JPanel panel;
	private JButton button1;
	private JLabel titleLabel;
	private JLabel radiusLabel;
	private JLabel SALabel;
	private JLabel VLabel;
	private JLabel Validate;
	private JTextField inputRadius;
	private int width;
	private int height;

	public GUI(int w, int h)  {		
		frame = new JFrame();
		inputRadius = new JTextField(8);
		button1 = new JButton("Calculate");
		titleLabel = new JLabel ("Sphere Calculator");
		radiusLabel = new JLabel("Enter Radius");
		Validate= new JLabel("");
		SALabel = new JLabel ("");
		VLabel = new JLabel("");
		width = w;
		height = h;

		panel = new JPanel();	
	}
	public void setUpBounds() {
		titleLabel.setBounds(85,10,150,25);
		radiusLabel.setBounds(10, 40, 80, 25);
		inputRadius.setBounds(100, 40,165, 25);
		button1.setBounds(85, 80, 165, 25);
		SALabel.setBounds(10,120,250,25);
		VLabel.setBounds(10,150,250,25);
		Validate.setBounds(85,130,150,25);
	}
	
	public void setUpGUI() {
		panel.setLayout(null);
		panel.add(titleLabel);
		panel.add(radiusLabel);
		panel.add(inputRadius);
		panel.add(button1);
		panel.add(SALabel);
		panel.add(VLabel);
		panel.add(Validate);
		
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sphere");
		button1.setSize(100,20);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void setUpButtonListeners() {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {	
				Validate.setText("");
		
				try {
					String Tradius = inputRadius.getText();
					radius = Integer.parseInt(Tradius);
				}catch (NumberFormatException e) {
					Validate.setText("Invalid Number");
					SALabel.setText("");
					VLabel.setText("");
				}
				
				V = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
				SA = 4.0 * Math.PI * Math.pow(radius, 2);
				SA = Math.round(SA*100)/100d;
				V = Math.round(V*100)/100d;
				if (Validate.getText().equals("")) {
					SALabel.setText("Surface Area: " + SA);
					VLabel.setText("Volume: " + V);
				}	
			}
		};
		
		button1.addActionListener(buttonListener);
	}
	
}
