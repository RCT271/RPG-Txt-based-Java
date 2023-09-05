package story;

import main.Game;

public class Town extends Area{
	
	public Town() {
		pos = new int[] {1, 1};
		sceneMap = new Scene[2][4];
		
		Scene center = new Scene("Town Center");
		center.mainText = "You are at the town center. What would you like to do?";
		
		Scene tavern = new Scene("Tavern Entrance");
		tavern.mainText = "You are in front of a tavern. What Would wou like to do?";
		tavern.setCommand(0, "Tavern");
		tavern.setText(0, "Go inside the tavern");
		
		Scene questBoard = new Scene("Quest Board");
		questBoard.mainText = "You see a quest board in front of you. What would you like to do?";
		questBoard.setCommand(0, "Quest Board");
		questBoard.setText(0, "Look at the quest board");
		
		Scene walkWay = new Scene("");
		walkWay.mainText = "You are still in town...";
		
		sceneMap[1][1] = center;
		sceneMap[0][1] = tavern;
		sceneMap[0][2] = questBoard;
		for (int r = 0; r < sceneMap.length; r++) {
			for (int c = 0; c < sceneMap[0].length; c++) {
				if (sceneMap[r][c] == null) {
					sceneMap[r][c] = walkWay;
				}
			}
		}
	}
}
