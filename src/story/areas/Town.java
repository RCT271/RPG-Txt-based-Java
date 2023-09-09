package story.areas;

import main.Game;
import story.Area;
import story.LocalScene;
import story.Scene;
import story.Story;

public class Town extends Area{
	
	public Town(String name, Story story) {
		super(name, story);
		
		// Initialize scene map size.
		// And the initial position on that map
		sceneMap = new Scene[2][3];
		pos = new int[] {1, 1};
		
		Scene center = new Scene("Town Center");
		center.mainText = "You are at the town center. What would you like to do?";
		center.setCommand(4, "local Save Notif");
		center.setText(4, "Save");
		center.setCallback(4, () -> {
			// do the save thing here
			System.out.println("tang ina mo nasave na gago");
		});
		
		LocalScene saveNotif = new LocalScene("Save Notif", this);
		saveNotif.mainText = "Thank you for playing! Your game state has been saved";
		saveNotif.setText(4, "Confirm");
		saveNotif.setCommand(4, "leave");
		
		
		Scene tavern = new Scene("Tavern Entrance");
		tavern.mainText = "You are in front of a tavern. What Would wou like to do?";
		tavern.setCommand(0, "Tavern");
		tavern.setText(0, "Go inside the tavern");
		tavern.setCallback(0, () -> {
			Game.mainStory.player.stats.addAreaExplored("Tavern");
		});
		
		Scene shop = new Scene("Shop Entrance");
		shop.mainText = "You see a sign that says Ryan Bang's Shop";
		shop.setCommand(2, "Shop");
		shop.setText(2, "Go inside the shop");
		
		Scene questBoard = new Scene("Quest Board");
		questBoard.mainText = "You see a quest board in front of you. What would you like to do?";
		questBoard.setCommand(0, "Quest Board");
		questBoard.setText(0, "Look at the board");
		
		Scene forest = new Scene("Forest Entrance");
		forest.mainText = "You see a deep forest ahead of you";
		forest.setText(3, "Enter the forest");
		forest.setCommand(3, "Forest");
		forest.setCallback(3, () -> {
			Game.mainStory.player.stats.addAreaExplored("Forest");
		});
		
		Scene walkWay = new Scene("");
		walkWay.mainText = "You are wandering the town...";
		
		sceneMap[0][0] = walkWay;
		sceneMap[1][1] = center;
		sceneMap[1][0] = shop;
		sceneMap[0][1] = tavern;
		sceneMap[0][2] = questBoard;
		sceneMap[1][2] = forest;
		
		
	}
}
