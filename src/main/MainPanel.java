package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;

import Assets.Sound;
import main.GUI.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	JPanel statsPanel, textPanel, buttonPanel;
	
	public FortunaButton[] buttons = new FortunaButton[5];
	public JLabel mainText, subText;
	public FLabel pHpLabel, pGoldLabel, pWeaponLabel, questLabel;
	public FLabel npcHpLabel, npcGoldLabel, npcWeaponLabel;
	
	public MainPanel() {
		setVisible(false);
		setBounds(0, 0, Game.window.getWidth(), Game.window.getHeight());
		setLayout(new BorderLayout());
		this.setFocusable(true);
		
		// initialize panels
		statsPanel = new JPanel();
		statsPanel.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() * 0.15)));
		statsPanel.setBackground(Color.black);
		statsPanel.setLayout(new GridLayout(1, 2));
			// create a separate panel for each stats
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(5, 2, 10, 0));
		playerPanel.setAlignmentX(LEFT_ALIGNMENT);
		pHpLabel = new FLabel("", JLabel.LEFT);
		pGoldLabel = new FLabel("", JLabel.LEFT);
		pWeaponLabel = new FLabel("", JLabel.LEFT);
		questLabel = new FLabel("", JLabel.LEFT);
		
		playerPanel.add(new FLabel("health : ", JLabel.RIGHT));
		playerPanel.add(pHpLabel);
		playerPanel.add(new FLabel("gold : ", JLabel.RIGHT));
		playerPanel.add(pGoldLabel);
		playerPanel.add(new FLabel("weapon : ", JLabel.RIGHT));
		playerPanel.add(pWeaponLabel);
		playerPanel.add(new FLabel("quest : ", JLabel.RIGHT));
		playerPanel.add(questLabel);
		
		JPanel npcPanel = new JPanel();
		npcPanel.setBackground(Color.black);
		npcPanel.setLayout(new GridLayout(5, 2, 10, 0));
		npcHpLabel = new FLabel("", JLabel.LEFT);
		npcGoldLabel = new FLabel("", JLabel.LEFT);
		npcWeaponLabel = new FLabel("", JLabel.LEFT);
		
		npcPanel.add(new FLabel("health : ", JLabel.RIGHT));
		npcPanel.add(npcHpLabel);
		npcPanel.add(new FLabel("gold : ", JLabel.RIGHT));
		npcPanel.add(npcGoldLabel);
		npcPanel.add(new FLabel("weapon : ", JLabel.RIGHT));
		npcPanel.add(npcWeaponLabel);
		
			// add those separate panels to the stats panel
		statsPanel.add(playerPanel);
		statsPanel.add(npcPanel);
		
		
		textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() * 0.45)));
		textPanel.setBackground(Color.black);
		textPanel.setLayout(new GridLayout(2, 1, 0, 15));
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(getWidth(), (int) (getHeight() * 0.40)));
		buttonPanel.setBackground(Color.black);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, Game.window.getWidth(), 0));
		
		// initialize ui buttons
		for (int i = 0; i < 5; i++) {
			FortunaButton b = new FortunaButton("", "");
			b.setPreferredSize(new Dimension(300, 35));
			buttons[i] = b;
			buttonPanel.add(b);
		}
		
		/// initialize main text area
		mainText = new JLabel();
		mainText.setText("This an area for the text of the water is a test for the text are on the main board");
		mainText.setForeground(Color.white);
//		mainText.setForeground(new Color(235, 160, 9));
		mainText.setFont(GUI.textFont);
		mainText.setHorizontalAlignment(JLabel.CENTER);
		mainText.setVerticalAlignment(JLabel.BOTTOM);
		textPanel.add(mainText);
		
		subText = new JLabel();
		subText.setText("This an area for the text of the water is a test for the text are on the main board");
		subText.setForeground(Color.gray);
		subText.setForeground(new Color(235, 160, 9));
		subText.setFont(GUI.subTextFont);
		subText.setVisible(false);
		subText.setHorizontalAlignment(JLabel.CENTER);
		subText.setVerticalAlignment(JLabel.TOP);
		textPanel.add(subText);
		
		// add the components
		this.add(statsPanel, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void updateSize() {
		this.setBounds(0, 0, Game.window.getWidth(), Game.window.getHeight());
	}
	
}
