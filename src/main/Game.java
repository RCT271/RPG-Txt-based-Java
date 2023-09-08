package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Assets.*;
import main.GUI.*;
import story.Story;

public class Game {

	public static JFrame window = new JFrame("Fortuna");
	public static MainPanel mainPanel;
	public static TitlePanel titlePanel;
	public static ChoiceHandler choiceHandler;
	
	public static int selectorPos = -1;
	
	public static Story mainStory;
	
	public static void main(String[] args) {
		new Game();
	}
	
	Game() {
		// sounds
		
		// window
		window = new JFrame("Fortuna");
		window.setMinimumSize(new Dimension(800, 600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.addComponentListener(new WindowSizeHandler());

		// handlers
		choiceHandler = new ChoiceHandler();
		window.addKeyListener(new KeyboardHandler());
		
		// panels
		titlePanel = new TitlePanel();
		mainPanel = new MainPanel();
		
		window.add(titlePanel);
		window.add(mainPanel);
		
		// start the story
		mainStory = new Story();
	}
	
	
	class WindowSizeHandler implements ComponentListener {

		@Override
		public void componentResized(ComponentEvent e) {
			// TODO Auto-generated method stub
			if (titlePanel == null) return;
			
			titlePanel.updateSize();
			mainPanel.updateSize();
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	class ChoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new Sound("src/Assets/Click Fortuna.wav").play();
			
			// title panel
			if (e.getActionCommand().equals("Start")) {
				titlePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
			
			// main panel
			for (int i = 0; i < mainPanel.buttons.length; i++) {
				FortunaButton b = mainPanel.buttons[i];
				
				if (e.getSource() == b) {
					Game.Callback callback = mainStory.currentArea.currentScene.callbacks[i]; 					
					
					if (callback != null) {
						callback.call();
					}
					
					mainStory.doCommand(b.getActionCommand());
					break;
				}
			}
			
			
		}
	}
	
	
	
	class KeyboardHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// if the main panel is not yet visible
			if (!mainPanel.isVisible()) return;
			
			boolean changed = false;
			
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					selectorPos -= 1;
					if (selectorPos < 0) {
						selectorPos = 4;
					}
					// prevent selecting the disabled buttons
					while (!mainPanel.buttons[selectorPos].isEnabled()) {
						selectorPos -= 1;
						if (selectorPos < 0) {
							selectorPos = 4;
						}
					}
					changed = true;
					break;
					
					
				case KeyEvent.VK_DOWN:
					selectorPos += 1;
					if (selectorPos >= 5) {
						selectorPos = 0;
					}
					// prevent selecting the disabled buttons
					while (!mainPanel.buttons[selectorPos].isEnabled()) {
						selectorPos += 1;
						if (selectorPos >= 5) {
							selectorPos = 0;
						}
					}
					changed = true;
					break;
					
				
				case KeyEvent.VK_ENTER:
					if (selectorPos < 0) return;
					mainPanel.buttons[selectorPos].doClick(60);
					mainPanel.buttons[selectorPos].setBorder(FortunaButton.defaultBorder);
					selectorPos = -1;
					new Sound("src/Assets/Click Fortuna.wav", 6f).play();
					break;
					
			}
			
			if (!changed) return;
			
			// reset all the button's border
			for (JButton b : mainPanel.buttons) {
				b.setBorder(FortunaButton.defaultBorder);
			}			
			
			// then update the border of the selected button
			mainPanel.buttons[selectorPos].setBorder(BorderFactory.createLineBorder(Color.white, 3));
		
			// play hover sound
			new Sound("src/Assets/Hover Fortuna.wav", 6f).play();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public interface Callback {
		void call();
	}
}
