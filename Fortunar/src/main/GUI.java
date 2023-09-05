package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Assets.*;
//import main.FortunaButton.ML;

public abstract class GUI {
	public static Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	public static Font normalFont = new Font("Times New Roman", Font.PLAIN, 15);
	public static Font textFont = new Font("Times New Roman", Font.PLAIN, 20);
	
	// pre defined classes
	@SuppressWarnings("serial")
	public static class FLabel extends JLabel {
		
		public FLabel(String text, int horizontalAlignMent) {
			setText(text);
			setHorizontalAlignment(horizontalAlignMent);
			setForeground(Color.white);
			setFont(GUI.normalFont);
			
//			setBorder(BorderFactory.createLineBorder(Color.red, 1));
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

		public FortunaButton(String text, String actionCommand) {
			this.setText(text);
			this.setBackground(Color.black);
			this.setForeground(Color.white);
			this.setFont(GUI.normalFont);
			this.setFocusable(false);
			this.addActionListener(Game.choiceHandler);
			this.addMouseListener(new ML());
			this.setActionCommand(actionCommand);
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
				JButton source = (JButton) e.getSource();
				
				if (!source.isEnabled()) return;
				
				new Sound("src/Assets/Hover Fortuna.wav").play();
				Game.window.setCursor(Cursor.HAND_CURSOR);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				Game.window.setCursor(Cursor.DEFAULT_CURSOR);
			}
			
		}
		
		
		
	}
}
