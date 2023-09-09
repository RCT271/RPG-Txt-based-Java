package objects;

public abstract class Weapon {
	
	// special effects of some weapon
	public static final int
		NONE = 404, STUN = 0, BURN = 1, ELECTRIFY = 3, POISION = 5
	;
	
	
	public String name;
	public float damage, critChance;
	
	public Weapon(String name) {
		this.name = name;
	}
	
}	
