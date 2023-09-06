package story;

public abstract class Area {
	
	public int pos[] = {0, 0};
	
	LocalScene[] localScenes = new LocalScene[0];
	Scene[][] sceneMap;
	String name;
	
	public Scene currentScene;
	
	public Area(String name, Story story) {
		this.name = name;
		
		// append this area to this story's areas
		Area[] out = new Area[story.areas.length + 1];
		
		for (int i = 0; i < story.areas.length; i++) {
			out[i] = story.areas[i];
		}
		
		out[out.length-1] = this;
		
		story.areas = out;
	}
	
	
	// getters
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
	
	public Scene getLocalScene(String name) {
//		for (int i = 0; i < localScenes.length; i++) {
//			if (localScenes[i].getName().equals(name)) {
//				return localScenes[i];
//			}
//		}
		
		for (LocalScene scene : localScenes) {
			if (scene.getName().equals(name)) {
				return scene;
			}
		}
		
		return null;
	}
	
	
	// adders
	
}
