package story.areas;

import story.*;

public class Quest extends Area{

	public Quest(String name, Story story) {
		super(name, story);
		
		// initialize scene map
		sceneMap = new Scene[1][1];
		pos = new int[] {0, 0};
		
		Scene frontPage = new Scene("frontPage");
		frontPage.mainText = "Come back for more dude. Still not implemented";
		frontPage.setText(4, "Exit");
		frontPage.setCommand(4, "back");
		
		
		// add scenes to map
		sceneMap[0][0] = frontPage;
	}

}
