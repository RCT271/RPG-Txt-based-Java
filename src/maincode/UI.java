package maincode;

import java.awt.*;
import javax.swing.*;

import maincode.Game.ChoiceHandler;

public class UI {
	JFrame window;
	JPanel TitlenamePanel, StartButtonPanel, mainTextPanel, ButtonPanel, UserPanel;
	JLabel TitlenameLabel, hpLabel, hpLabelNumber, WeaponLabel, WeaponLabelName, goldLabelNumber, goldLabel;
	JButton StartButton, BChoice1, BChoice2, BChoice3, BChoice4;
	JTextArea mainTextArea;
	
	Font TitleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 15);
	Font TextFont = new Font("Times New Roman", Font.PLAIN, 20);
	
	public void createUI(ChoiceHandler cHandler) {
		//Window
		
		window = new JFrame("Fortuna");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		
		//Title
		TitlenamePanel = new JPanel();
		TitlenamePanel.setBounds(100, 100, 600, 150);
		TitlenamePanel.setBackground(Color.black);
		TitlenameLabel = new JLabel("Fortuna");
		TitlenameLabel.setForeground(Color.white);
		TitlenameLabel.setFont(TitleFont);
		TitlenamePanel.add(TitlenameLabel);
		
		StartButtonPanel = new JPanel();
		StartButtonPanel.setBounds(300, 400, 200, 100);
		StartButtonPanel.setBackground(Color.black);
		StartButton = new JButton("START ADVENTURE");
		StartButton.setBackground(Color.black);
		StartButton.setForeground(Color.white);
		StartButton.setFont(normalFont);
		StartButton.setFocusPainted(false);
		StartButton.addActionListener(cHandler);
		StartButton.setActionCommand("Start");
		StartButtonPanel.add(StartButton);
		
		window.add(TitlenamePanel);
		window.add(StartButtonPanel);
		TitlenamePanel.setVisible(false);
		StartButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		mainTextArea = new JTextArea("Grata to Fortuna, What would you like to do?");
		mainTextArea.setEditable(false);
		mainTextArea.setBounds(100, 100, 500, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(TextFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextPanel.add(mainTextArea);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBounds(250, 350, 300, 150);
		ButtonPanel.setBackground(Color.black);
		ButtonPanel.setLayout(new GridLayout(4,1));
		window.add(ButtonPanel);
		
		BChoice1 = new JButton("==========");
		BChoice1.setBackground(Color.black);
		BChoice1.setForeground(Color.white);
		BChoice1.setFont(normalFont);
		BChoice1.setFocusPainted(false);
		BChoice1.addActionListener(cHandler);
		BChoice1.setActionCommand("Command1");
		ButtonPanel.add(BChoice1);
		
		
		BChoice2 = new JButton("==========");
		BChoice2.setBackground(Color.black);
		BChoice2.setForeground(Color.white);
		BChoice2.setFont(normalFont);
		BChoice2.setFocusPainted(false);
		BChoice2.addActionListener(cHandler);
		BChoice2.setActionCommand("Command2");
		ButtonPanel.add(BChoice2);
		
		BChoice3 = new JButton("==========");
		BChoice3.setBackground(Color.black);
		BChoice3.setForeground(Color.white);
		BChoice3.setFont(normalFont);
		BChoice3.setFocusPainted(false);
		BChoice3.addActionListener(cHandler);
		BChoice3.setActionCommand("Command3");
		ButtonPanel.add(BChoice3);
		
		BChoice4 = new JButton("==========");
		BChoice4.setBackground(Color.black);
		BChoice4.setForeground(Color.white);
		BChoice4.setFont(normalFont);
		BChoice4.setFocusPainted(false);
		BChoice4.addActionListener(cHandler);
		BChoice4.setActionCommand("Command4");
		ButtonPanel.add(BChoice4);
		
		UserPanel = new JPanel();
		UserPanel.setLayout(new GridLayout(2,5));
		UserPanel.setBounds(100, 15, 550, 50);
		UserPanel.setBackground(Color.black);
		UserPanel.setLayout(new GridLayout(4,2));
		window.add(UserPanel);

		
		goldLabel = new JLabel("Gold:");
		goldLabel.setFont(normalFont);
		goldLabel.setForeground(Color.white);
		UserPanel.add(goldLabel);
		goldLabelNumber = new JLabel();
		
		goldLabelNumber.setFont(normalFont);
		goldLabelNumber.setForeground(Color.white);
		UserPanel.add(goldLabelNumber);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		UserPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		UserPanel.add(hpLabelNumber);
		
		WeaponLabel = new JLabel("Weapon:");
		WeaponLabel.setFont(normalFont);
		WeaponLabel.setForeground(Color.white);
		UserPanel.add(WeaponLabel);
		WeaponLabelName = new JLabel();
		WeaponLabelName.setFont(normalFont);
		WeaponLabelName.setForeground(Color.white);
		UserPanel.add(WeaponLabelName);
		
		window.setVisible(true);
	}
}
