package story;

import main.Game.Callback;

public class Scene {
	
//	public String
//		choice1 = "up",
//		choice2 = "down",
//		choice3 = "left",
//		choice4 = "right",
//		choice5 = "back"
//	;
//	
//	public String
//		scene1 = "Go up",
//		scene2 = "Go down",
//		scene3 = "Go left",
//		scene4 = "Go right",
//		scene5 = "Go back",
//		mainText = ""
//	;
	
	public final String[] defaultTexts = {"Go north", "Go south", "Go left", "Go right", "Go back"};
	public final String[] defaultCommands = {"up", "down", "left", "right", ""};
	
	public String mainText = "", subText = "";
	public String[] commands = defaultCommands.clone();
	public String[] texts = defaultTexts.clone();
	public Callback[] callbacks = new Callback[5];
	
	private String name;
	
	public Scene(String name) {
		this.name = name;
	}
	
	
	
	// getters
	public String getName() {
		return name;
	}
	
	public Callback getCallback(String name) {
		name = name.replace("callback ", "");
		int i = Integer.parseInt(name);
		
		return callbacks[i];
	}
	
	
	
	// setters
	public void resetText(int i) {
		texts[i] = defaultTexts[i];
	}
	
	public void resetTexts() {
		texts = defaultTexts.clone();
	}
	
	public void resetCommands() {
		commands = defaultCommands.clone();
	}
	
	public void clearCommands() {
		for (int i = 0; i < commands.length; i++) {
			commands[i] = "";
		}
	}
	
	public void clearTexts() {
		for (int i = 0; i < texts.length; i++) {
			texts[i] = "";
		}
	}
	
	public void setCommand(int i, String newCommand) {
		commands[i] = newCommand;
	}
	
	public void setText(int i, String newText) {
		texts[i] = newText;
	}
	
	public void setCallback(int i, Callback callback) {
		if (commands[i].equals("")) commands[i] = "callback";
		callbacks[i] = callback;
	}
}
