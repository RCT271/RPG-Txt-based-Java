package objects;

public class Stats {

	// areas explored
	String[] areas = new String[0];
	int[] frequency = new int[0];
	// name of enemies killed
	String[] enemies = new String[0];
	// how many of that enemies are killed
	int[] kills = new int[0];
	
	
	public Stats() {
		addAreaExplored("Town");
	}
	
	
	public void addAreaExplored(String areaName) {
		for (int i = 0; i < areas.length; i++) {
			if (!areas[i].equals(areaName)) continue;
			frequency[i] += 1;
			return;
		}
		
		// if the area is not found within the areas..,
		// append the area to the areas
		String[] newAreas = new String[areas.length+1];
		
		System.arraycopy(areas, 0, newAreas, 0, areas.length);
		newAreas[newAreas.length-1] = areaName;
		
		areas = newAreas;
		
		
		// as well as the frequency count as well
		int[] newFrequency = new int[frequency.length+1];
		
		System.arraycopy(frequency, 0, newFrequency, 0, frequency.length);
		newFrequency[newFrequency.length-1] = 1;
		
		frequency = newFrequency;
	}
	
	public void addEnemyKill(String enemyName) {
		for (int i = 0; i < enemies.length; i++) {
			if (!enemies[i].equals(enemyName)) continue;
			kills[i] += 1;
			return;
		}
		
		// if the enemy is not found within the enemies..,
		// append the enemy to the enemies
		String[] newEnemis = new String[enemies.length+1];
		
		System.arraycopy(enemies, 0, newEnemis, 0, enemies.length);
		newEnemis[newEnemis.length-1] = enemyName;
		
		enemies = newEnemis;
		
		
		// as well as the kill count as well
		int[] newKills = new int[kills.length+1];
		
		System.arraycopy(kills, 0, newKills, 0, kills.length);
		newKills[newKills.length-1] = 1;
		
		kills = newKills;
	}
	
	public int getAreaFrequency(String areaName) {
		
		for (int i = 0; i < areas.length; i++) {
			if (areas[i].equals(areaName)) {
				return frequency[i];
			}
		}
		
		return 0;
	}
	
}
