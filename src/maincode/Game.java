package maincode;

import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import Assets.Sound;


public class Game {
	
	UI ui = new UI();
	Transition Tr = new Transition(ui);
	ChoiceHandler cHandler = new ChoiceHandler();
	Story story = new Story(this, ui, Tr);
	String ClickSound;
	public static Sound bgMusic, clickSFX;

	String nextPosition1, nextPosition2, nextPosition3, nextPosition4, nextPosition5;
	public static void main(String[] args) {
		
		new Game();
	}

	public Game() {
		
		ui.createUI(cHandler);
		story.defaultSetup();
		Tr.ShowTitleScreen();
		ClickSound = ".//src/Assets/Click Fortuna.wav";
		
		bgMusic = new Sound("src/Assets/RPG Theme Fortuna.wav");
		bgMusic.adjustVolume(-10f);
		bgMusic.loop();
		
		clickSFX = new Sound("src/Assets/Click Fortuna.wav");
		clickSFX.adjustVolume(-10f);
		
	
		
	}

	
	public 	class ChoiceHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
//				se.setFile(ClickSound);
//				se.play();

			clickSFX.play();
			
			String UserInput = event.getActionCommand();
			
			switch(UserInput) {
			case "Start":
			Tr.TitletoStarter();
			story.Town(); break;
			case "Command1": story.selectPosition(nextPosition1);break;
			case "Command2": story.selectPosition(nextPosition2);break; 
			case "Command3": story.selectPosition(nextPosition3);break;
			case "Command4": story.selectPosition(nextPosition4);break;
			case "Command5": story.selectPosition(nextPosition5);break;
			
			
			}
		}
		
	}
}

		
		