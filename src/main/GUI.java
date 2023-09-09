package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import Assets.*;
//import main.FortunaButton.ML;

public abstract class GUI {
	public static Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	public static Font normalFont = new Font("Times New Roman", Font.PLAIN, 15);
	public static Font textFont = new Font("Times New Roman", Font.PLAIN, 20);
	public static Font subTextFont = new Font("Times New Roman", Font.PLAIN, 18);
	
	// pre defined classes
	@SuppressWarnings("serial")
	public static class FLabel extends JLabel {
		
		public FLabel(String text, int horizontalAlignMent) {
			setText(text);
			setHorizontalAlignment(horizontalAlignMent);
			setForeground(Color.white);
			setFont(GUI.normalFont);
		}
		
		public FLabel() {
			this("", JLabel.CENTER);
		}
		
		public FLabel(String text) {
			this(text, JLabel.CENTER);
		}
		
	}
	
	
	
	@SuppressWarnings("serial")
	public static class FortunaButton extends JButton{

		public static Border defaultBorder;
		
		public FortunaButton(String text, String actionCommand) {
			this.setText(text);
			this.setBackground(Color.black);
			this.setForeground(Color.white);
			this.setFont(GUI.normalFont);
			this.setFocusable(false);
			this.addActionListener(Game.choiceHandler);
			this.addMouseListener(new ML());
			this.setActionCommand(actionCommand);
			
			defaultBorder = this.getBorder();
		}
		
		
		class ML implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (!isEnabled()) return;
				
				new Sound("src/Assets/Hover Fortuna.wav", 6f).play();
				setBorder(defaultBorder);
				Game.window.setCursor(Cursor.HAND_CURSOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(defaultBorder);
				Game.window.setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		}
		
		
		
	}
}
