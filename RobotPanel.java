import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class RobotPanel extends JPanel{
	
	RobotModel model = new RobotModel();
	
	RobotPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.75;
		c.weighty = 0.75;
		c.gridx = 0;
		c.gridy = 0;
		RobotButton rotateLButton = new RobotButton("RLeft", model);
		add(rotateLButton, c);
		
		c.gridx = 1;
		c.gridy = 0;
		RobotButton fowardButton = new RobotButton("Foward", model);
		add(fowardButton, c);
		
		c.gridx = 2;
		c.gridy = 0;
		RobotButton rotateRButton = new RobotButton("RRight", model);
		add(rotateRButton, c);
		
		c.gridx = 0;
		c.gridy = 1;
		RobotButton leftButton = new RobotButton("Left", model);
		add(leftButton, c);
		
		c.gridx = 1;
		c.gridy = 1;
		RobotButton backButton = new RobotButton("Back", model);
		add(backButton, c);
		
		c.gridx = 2;
		c.gridy = 1;
		RobotButton rightButton = new RobotButton("Right", model);
		add(rightButton, c);
		
		c.gridx = 0;
		c.gridy = 2;
		RobotButton upButton = new RobotButton("Up", model);
		add(upButton, c);
		
		c.gridx = 1;
		c.gridy = 2;
		JLabel sliderLabel = new JLabel("Speed", JLabel.CENTER);
		JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 25, 25);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setMajorTickSpacing(5);
		speedSlider.setPaintLabels(true);
		speedSlider.setPaintTicks(true);
		speedSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				if (!source.getValueIsAdjusting()) {
					model.setSpeed(((double)source.getValue())*0.01);
					//System.out.println("Yo i was changed: " + ((double)source.getValue())*0.01);
				}    
			}
		});
		add(sliderLabel, c);
		add(speedSlider, c);
		
		c.gridx = 2;
		c.gridy = 2;
		RobotButton downButton = new RobotButton("Down", model);
		add(downButton, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		RobotButton takeOffButton = new RobotButton("Take Off", model);
		add(takeOffButton, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		RobotButton landButton = new RobotButton("Land", model);
		add(landButton, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		RobotButton stopButton = new RobotButton("Stop", model);
		add(stopButton, c);
	}
	
}