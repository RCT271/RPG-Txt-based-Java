package story;

public class LocalScene extends Scene{

	public LocalScene(String name, Area area) {
		super("local " + name);
	
		
		// reset the texts
		clearTexts();
		
		// clear the commands
		clearCommands();
		
		// append this local scene to this area's localScenes
		LocalScene[] out = new LocalScene[area.localScenes.length + 1];
		
		for (int i = 0; i < area.localScenes.length; i++) {
			out[i] = area.localScenes[i];
		}
		
		out[out.length-1] = this;
		
		area.localScenes = out;
	}

}
