package story;

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
	
	public String mainText = "";
	
	public String[] commands = {"up", "down", "left", "right", ""};
	private String[] ogTexts = {"Go north", "Go south", "Go left", "Go right", "Go back"};
	public String[] texts = ogTexts.clone();
	
	private String name;
	
	public Scene(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void resetText(int i) {
		texts[i] = ogTexts[i];
	}
	
	public void clearSceneTexts() {
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
	
}
