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

		// handler
		choiceHandler = new ChoiceHandler();
		
		// panels
		titlePanel = new TitlePanel();
		mainPanel = new MainPanel();
		
		window.add(titlePanel);
		window.add(mainPanel);
		
		Story.initialize();
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
			new Sound("src/Assets/Click Fortuna.wav", -18f).play();
			
			
			for (FortunaButton b : mainPanel.buttons) {
				if (e.getSource() == b) {
					Story.changeScene(b.getActionCommand());
				}
			}
			
			
			switch (e.getActionCommand()) {
				case "Start":
					titlePanel.setVisible(false);
					mainPanel.setVisible(true);
					break;
			}
			
		}
	}
}
