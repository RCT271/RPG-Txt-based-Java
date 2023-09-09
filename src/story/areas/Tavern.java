package story.areas;

import story.Area;
import story.LocalScene;
import story.Scene;
import story.Story;

public class Tavern extends Area{

	public Tavern(String name, Story story) {
		super(name, story);
		
		// Initialize scene map size.
		// And the initial position on that map
		sceneMap = new Scene[2][3];
		pos = new int[] {1, 1};
		
		Scene doorEntrance = new Scene("Door");
		doorEntrance.mainText = "You are inside the tavern. What would you like to do?";
		doorEntrance.setCommand(4, "back");
		doorEntrance.setText(4, "Exit");
		
		Scene bar = new Scene("Bar");
		bar.mainText = "You see a tavernkeep filling out cups...";
		bar.setCommand(0, "local Tavernkeep");
		bar.setText(0, "Talk to him");
		
		LocalScene tavernKeep = new LocalScene("Tavernkeep", this);
		tavernKeep.mainText = "Tavernkeep: Heya there, mate! Whan can I do fer ya??";
		tavernKeep.setText(0, "Buy Meat");
		tavernKeep.setCallback(0, () -> {
			tavernKeep.mainText = "Tavernkeep: Thank you for buying meat!";
			tavernKeep.setText(0, "Buy more meat");
			story.setScene(tavernKeep);
			System.out.println("you bought meat");
		});
		
		tavernKeep.setText(1, "Buy Beer");
		tavernKeep.setCallback(1, () -> {
			tavernKeep.mainText = "Tavernkeep: Thank you for buying beer!";
			tavernKeep.setText(1, "Buy more beer");
			story.setScene(tavernKeep);
			System.out.println("you bought beer");
		});

		tavernKeep.setCommand(4, "leave");
		tavernKeep.setText(4, "Leave");
		tavernKeep.setCallback(4, () -> {
			tavernKeep.mainText = "Tavernkeep: Heya there, mate! Whan can I do fer ya??";
			tavernKeep.setText(0, "Buy meat");
			tavernKeep.setText(1, "Buy beer");
		});
		
		// place the scenes accordingly
		sceneMap[1][1] = doorEntrance;
		sceneMap[0][1] = bar;
	}
}
