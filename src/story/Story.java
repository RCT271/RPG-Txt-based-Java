package story;

import main.Game;

public class Story {
	
	
	
	public static Area currentArea, prevArea;
	
	public static Area town;
	
	public static void initialize() {
		town = new Town();
		currentArea = town;
		
		setScene(town.sceneMap[town.pos[0]][town.pos[1]]);
	}
	
	
	public static void changeScene(String actionCommand) {
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
				break;
			default:
				return;
		}
		
		setScene(currentArea.getSceneFromMap(currentArea.pos));
	}
	
	
	private static void setScene(Scene scene) {
		// enable all the buttons for the ones that have been disabled 
		// from the previous scene
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setEnabled(true);
		}
		
		// update panel's main text
		Game.mainPanel.mainText.setText(scene.mainText);
		
		// update buttons' action command
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setActionCommand(scene.commands[i]);
		}
		
		// adjust the scene's text if it's directional
		int[] pos;
		Scene futureScene; 

		for (int i = 0; i < 5; i++) {
			pos = currentArea.pos.clone();
			switch (scene.commands[i]) {
				case "up": pos[0] -= 1; break;
				case "down": pos[0] += 1; break;
				case "left": pos[1] -= 1; break;
				case "right": pos[1] += 1; break;
				default: continue;
			}
			
			scene.resetText(i);
			futureScene = currentArea.getSceneFromMap(pos[0], pos[1]);
			if (futureScene == null) {
				Game.mainPanel.buttons[i].setEnabled(false);
				scene.texts[i] = "";
			}
			else {
				if (!futureScene.getName().equals("")) {					
					scene.texts[i] += " to " + futureScene.getName();
				}
			}
		}
		
		// disable the button if it's scene doesn't have a command
		for (int i = 0; i < 5; i++) {
			if (scene.commands[i].equals("")) {
				Game.mainPanel.buttons[i].setEnabled(false);
				scene.texts[i] = "";
			}
		}
		
		// update the buttons' action command
		for (int i = 0; i < 5; i++) {
			Game.mainPanel.buttons[i].setText(scene.texts[i]);
		}
	}
	
}
