package story.areas;

import main.Game;
import story.*;

public class Forest extends Area{

	public Forest(String name, Story story) {
		super(name, story);
		
		// initialize map and the initial position
		sceneMap = new Scene[3][10];
		this.pos = new int[] {1, 0};
		
		Scene entrance = new Scene("Entrance");
		entrance.clearCommands();
		entrance.mainText = "WARNING! As you wander the forest, monsters may come and attack.";
		entrance.subText = "Make sure you are well prepared with enough health and a decent setup";
		entrance.setText(0, "Continue");
		entrance.setCommand(0, "right");
		
		entrance.setText(1, "Go back");
		entrance.setCommand(1, "back");
		// change the scene if the player has entered the forest atleast 10 times
		entrance.setCallback(1, () -> {
			if (Game.mainStory.player.stats.getAreaFrequency("Forest") < 10) return;
				
			entrance.mainText = "Welcome to the forest. What would you like to do?";
			entrance.subText = "";
			entrance.resetTexts();
			entrance.resetCommands();
			entrance.setCommand(4, "back");
		});
		
		Scene monsterSpawnable = new Scene("");
		monsterSpawnable.mainText = "Putangina di pa po ito tapos";
		
		sceneMap[1][0] = entrance;
		sceneMap[1][1] = monsterSpawnable;
	}

}
