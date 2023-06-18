package maincode;

import java.awt.event.*;
public class Game {
	
	UI ui = new UI();
	Transition Tr = new Transition(ui);
	ChoiceHandler cHandler = new ChoiceHandler();
	Story story = new Story(this, ui, Tr);
	
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4, nextPosition5;
	public static void main(String[] args) {
		
		new Game();
	}

	public Game() {
		
		ui.createUI(cHandler);
		story.defaultSetup();
		Tr.ShowTitleScreen();
	}
	
	
	public 	class ChoiceHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			String UserInput = event.getActionCommand();
			
			switch(UserInput) {
			case "Start": Tr.TitletoStarter(); story.Town(); break;
			case "Command1": story.selectPosition(nextPosition1);break;
			case "Command2": story.selectPosition(nextPosition2);break; 
			case "Command3": story.selectPosition(nextPosition3);break;
			case "Command4": story.selectPosition(nextPosition4);break;
			case "Command5": story.selectPosition(nextPosition5);break;
			
			
			}
		}
		
	}
}

		
		