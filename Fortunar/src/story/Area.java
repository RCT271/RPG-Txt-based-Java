package story;

import main.Game;

public abstract class Area {
	
	public int pos[] = {0, 0};
	
	Scene[][] sceneMap;
	
	
	public void move(String actionCommand) {
		
	}
	
	public Scene getSceneFromMap(int r, int c) {
		try {			
			return sceneMap[r][c];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public Scene getSceneFromMap(int[] pos) {
		return getSceneFromMap(pos[0], pos[1]);
	}
	
}
