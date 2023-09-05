package main;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel{

	public JLabel titleLabel = new JLabel("FORTUNA");
	public JButton startButton = new JButton("ENTER FORTUNA");
	
	
	public TitlePanel() {
		this.setBounds(0, 0, Game.window.getWidth(), Game.window.getHeight());
		this.setBackground(Color.black);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, getWidth(), (int) (this.getHeight()*0.25)));
		
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(GUI.titleFont);
		
		startButton = new GUI.FortunaButton("ENTER FORTUNA", "Start");
		startButton.setRolloverEnabled(true);
		
		this.add(titleLabel);
		this.add(startButton);
	}
	
	
	public void updateSize() {
		this.setBounds(0, 0, Game.window.getWidth(), Game.window.getHeight());
	}
	
}
