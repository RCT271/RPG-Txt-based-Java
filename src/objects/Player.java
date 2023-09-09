package objects;

import objects.weapons.*;

public class Player {
	
	
	public float health, gold, defense, level;
	
	public Weapon[] inventory = new Weapon[0];
	public Weapon weapon;
	
	public Stats stats;
	
	public Player() {
		health = 100;
		gold = 0;
		addWeapon(new Stick());
		equipWeapon("Stick");
		
		stats = new Stats();
	}
	
	
	
	// general methods
	public void addWeapon(Weapon item) {
		Weapon[] out = new Weapon[inventory.length+1];
		
		System.arraycopy(inventory, 0, out, 0, inventory.length);
		out[out.length-1] = item;
		
		inventory = out;
	}
	
	public void equipWeapon(String weaponName) {
		for (Weapon w : inventory) {
			if (!w.name.equals(weaponName)) continue;
			
			weapon = w;
			break;
		}
	}
	
}
