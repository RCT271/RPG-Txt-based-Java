package story;

import main.Game;
import main.Game.Callback;
import objects.*;
import story.areas.*;


public class Story {
	
	public Area[] areas = new Area[0];
	
	public Area currentArea, prevArea;
	
	public Player player;
	
	public Story() {
		player = new Player();
		
		// initialize areas
			// Areas found in town
		currentArea = new Town("Town", this);
		new Tavern("Tavern", this);
		new Quest("Quest Board", this);
		
			// Areas found in the wilderness
		new Forest("Forest", this);
		
		
		setScene(currentArea.sceneMap[currentArea.pos[0]][currentArea.pos[1]]);
	}
	
	
	
	// this method is what's called when the user clicks a button
	public void doCommand(String actionCommand) {
		if (actionCommand.contains("local")) {
			setScene(currentArea.getLocalScene(actionCommand));
			return;
		}
		
		switch (actionCommand) {
			case "up":
				currentArea.pos[0] -= 1; break;
			case "down":
				currentArea.pos[0] += 1; break;
			case "left":
				currentArea.pos[1] -= 1; break;
			case "right":
				currentArea.pos[1] += 1; break;
			case "back":
				currentArea = prevArea;
				break;
			case "leave":
				break;
			case "callback":
				return;
			case "save":
				return;
			default:
				changeArea(actionCommand);
				return;
		}
		
		setScene(currentArea.getSceneFromMap(currentArea.pos));
	}
	
	
	
	private void changeArea(String actionCommand) {
		prevArea = currentArea;
		
		// look for the area that is stored in the action command
		for (int i = 0; i < areas.length; i++) {
			if (areas[i].name.equals(actionCommand)) {
				currentArea = areas[i];
				break;
			}
		}
		
		setScene(currentArea.getSceneFromMap(currentArea.pos));
	}
	
	
	
	public void setScene(Scene scene) {
		// update the current scene
		currentArea.currentScene = scene;
		
		// update panel's main text
		Game.mainPanel.mainText.setText(scene.mainText);
		
		// update the subtext if there is any
		if (!scene.mainText.equals("")) {
			Game.mainPanel.subText.setVisible(true);
			Game.mainPanel.subText.setText(scene.subText);
		}
		else {
			Game.mainPanel.subText.setVisible(false);
		}
		
		// update buttons' action command
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setActionCommand(scene.commands[i]);
		}
		
		// enable all the buttons for the ones that have been disabled 
		// from the previous scene
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setEnabled(true);
		}
		
		// disable the button if its scene doesn't have a command
		for (int i = 0; i < 5; i++) {
			if (scene.commands[i].equals("")) {
				Game.mainPanel.buttons[i].setEnabled(false);
//				scene.texts[i] = "";
			}
		}		
		
		// adjust the scene's text if it's directional
		int[] pos;
		Scene futureScene; 

		for (int i = 0; i < 5; i++) {
			// adjust the pos based on the direction of the command
			pos = currentArea.pos.clone();
			switch (scene.commands[i]) {
				case "up": pos[0] -= 1; break;
				case "down": pos[0] += 1; break;
				case "left": pos[1] -= 1; break;
				case "right": pos[1] += 1; break;
				case "back":
					if (scene.texts[4].equals(scene.defaultTexts[4])) {						
						scene.texts[4] = "Go back to " + prevArea.name;
					}
					continue;
					
				default: continue;
			}
			
			futureScene = currentArea.getSceneFromMap(pos[0], pos[1]);
			// if there is no future scene (i.e., there is no scene on that adjusted pos on the sceneMap)
			if (futureScene == null) {
				Game.mainPanel.buttons[i].setEnabled(false);
//				scene.texts[i] = "";
			}
			else {
				// only adjust the scene's text if it's the default text.
				// and if the future scene has a name
				if (!futureScene.getName().equals("") && scene.texts[i].equals(scene.defaultTexts[i])) {					
					scene.texts[i] = scene.defaultTexts[i] + " to " + futureScene.getName();
				}
			}
		}
		
		// update the buttons' adjusted texts
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setText(scene.texts[i]);
		}
	}
	
}
