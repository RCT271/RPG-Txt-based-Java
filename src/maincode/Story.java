package maincode;

import java.io.File;

import Assets.*;

public class Story {
	
	Game game;
	UI ui;
	Transition Tr;
	Player player = new Player();
	Super_Monster monster;
	
	
	public Story(Game g, UI UserInterface, Transition Trans) {
		player.PlayerHP = 100;
		player.Money = 50;
		player.CurrentWeapon = new Weapon_Warhammer();
		
		File file = new File("src/Assets/saveload.sav");
		if (file.exists()) {
			load();
		}
		
		game = g;
		ui = UserInterface;
		Tr = Trans;
		
	}
	public void defaultSetup() {
		ui.hpLabelNumber.setText(""	+ player.PlayerHP);
		ui.goldLabelNumber.setText("" + player.Money);
		ui.WeaponLabelName.setText(player.CurrentWeapon.Weapon_name);
	}
	public void selectPosition(String nextPosition) {
		defaultSetup();
		switch(nextPosition) {
		case "Questboard": Questboard(); break;
		case "Forest": Forest(); break;
		case "ForestLeft": ForestLeft(); break;
		case "ForestRight": ForestRight(); break;
		case "ForestForward": ForestForward(); break;
		case "MonsterEncounter": MonsterEncounter(); break;
		case "Tavern": Tavern(); break;
		case "Shop": Shop(); break;
		case "Town": Town(); break;
		case "Fight": Fight(); break;
		case "PlayerAttack": PlayerAttack(); break;
		case "MonsterAttack": MonsterAttack(); break;
		case "Win": Win(); break;
		case "Lost": Win(); break;
		case "Camp": Camp(); break;
		case "Barkeep": Barkeep(); break;
		case "Meal": Meal(); break;
		case "Beer": Beer(); break;
		case "Save": Save(); break;		
		}
	}
	public void Town() {
		ui.mainTextArea.setText("You are In Town, What would you like to do?");
		ui.BChoice1.setText("Go To the Questboard");
		ui.BChoice2.setText("Go To the Forest");
		ui.BChoice3.setText("Go To the Tavern");
		ui.BChoice4.setText("Go To the Shop");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Questboard";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "Tavern";
		game.nextPosition4 = "Shop";
		game.nextPosition5 = "Save";
	}
	public void Save() {
		DataStorage data = new DataStorage();
		data.PlayerHP = player.PlayerHP;
		data.PlayerMoney = player.Money;
		data.PlayerWeapon = player.CurrentWeapon.Weapon_name;
		
		SaveLoad.saveObject("src/Assets/saveload.sav", data);
	}
	
	public void load() {
		DataStorage data = (DataStorage) SaveLoad.loadObject("src/Assets/saveload.sav");
		player.PlayerHP = data.PlayerHP;
		player.Money = data.PlayerMoney;
//		player.PlayerWeapon = data.play
	}
	
	public void Questboard() {
		ui.mainTextArea.setText("This Area is still not done.");
		ui.BChoice1.setText("Go Back");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
		
	}
	public void Forest() {
		ui.mainTextArea.setText("You Went to the Forest");
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Go Left");
		ui.BChoice3.setText("Go Right");
		ui.BChoice4.setText("Go Forward");
		ui.BChoice5.setText("Save");
		
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "ForestLeft";
		game.nextPosition3 = "ForestRight";
		game.nextPosition4 = "ForestForward";
		game.nextPosition5 = "Save";
	}
	public void ForestLeft() {
		ui.mainTextArea.setText("You Went to the Left of the Forest");
		ui.BChoice1.setText("Go Back to The Forest Entrance");
		ui.BChoice2.setText("Camp a bit");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounter";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
		
	}
	public void ForestRight() {
		ui.mainTextArea.setText("You Went to the Right of the Forest");
		ui.BChoice1.setText("Go Back to The Forest Entrance");
		ui.BChoice2.setText("Camp a bit");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounter";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void ForestForward() {
		ui.mainTextArea.setText("You Went to Deeper into the Forest");
		ui.BChoice1.setText("Go Back to The Forest Entrance");
		ui.BChoice2.setText("Camp a bit");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounter";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void Camp() {
		player.PlayerHP += 5;
		if (player.PlayerHP > 100) player.PlayerHP = 100;
		ui.mainTextArea.setText("You Set Up Camp, and you feel refreshed");
		ui.BChoice1.setText("Go Back to the Forest Entrance");
		ui.BChoice2.setText("Save");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void MonsterEncounter() {
		
		int i = new java.util.Random().nextInt(3)+1;
		if(i==1) {
			monster = new Monster_Goblin();
		}
		else if(i==2) {
			monster = new Monster_Wolf();
		}
		else if (i==3) {
			monster = new Monster_Zombie();
		}
		ui.mainTextArea.setText("You Encountered a Wild " + monster.name + " whilst in the Forest");
		
		ui.BChoice1.setText("Fight");
		ui.BChoice2.setText("Flee");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		game.nextPosition1 = "Fight";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void Fight() {
ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do You Do?");
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("Retreat");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		game.nextPosition1 = "PlayerAttack";
		game.nextPosition2 = "Town";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void PlayerAttack() {
		int playerDMG = new java.util.Random().nextInt(player.CurrentWeapon.Weapon_dmg);
		
		ui.mainTextArea.setText("You attacked the " + monster.name + " For " + playerDMG + " DMG");
		monster.hp = monster.hp - playerDMG;
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(monster.hp>0) {
			game.nextPosition1 = "MonsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp<1) {
			game.nextPosition1 = "Win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void MonsterAttack() {
		int monsterDamage = new java.util.Random().nextInt(monster.dmg);
		ui.mainTextArea.setText(monster.AttackMSG + "\nYou Recieved " + monsterDamage + " DMG");
		player.PlayerHP = player.PlayerHP - monsterDamage;
		ui.hpLabelNumber.setText("" + player.PlayerHP);
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(player.PlayerHP>0) {
			game.nextPosition1 = "Fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(player.PlayerHP<1) {
			game.nextPosition1 = "Lost";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	public void Win() {
		ui.mainTextArea.setText("You are Victorious, You Defeated the " + monster.name + " You also gained some money");
		
		player.Money += 50;
		ui.BChoice1.setText("Stay and Fight More");
		ui.BChoice2.setText("Go back to the Town");
		ui.BChoice3.setText("Camp for a while");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "MonsterEncounter";
		game.nextPosition2 = "Town";
		game.nextPosition3 = "Camp";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void Lost() {
		player.PlayerHP += 100;
		ui.mainTextArea.setText("You Lost, but you were rescued back to Town");
		ui.BChoice1.setText("Go to the Town Center");
		ui.BChoice2.setText("Go back to the Forest");
		ui.BChoice3.setText("Go to the Shop");
		ui.BChoice4.setText("Go to the Tavern");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "Shop";
		game.nextPosition4 = "Tavern";
		game.nextPosition5 = "Save";
	}
	public void Tavern() {
		ui.mainTextArea.setText("You are now in the Tavern");
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Go Talk to the Barkeep");
		ui.BChoice3.setText("Buy Beer");
		ui.BChoice4.setText("Buy a Meal");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Barkeep";
		game.nextPosition3 = "Beer";
		game.nextPosition4 = "Meal";
		game.nextPosition5 = "Save";
		
	}
	public void Meal() {
		ui.mainTextArea.setText("You bought a Meal from the Tavern and feel refreshed");
		player.PlayerHP = +5;
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Go Talk to the Barkeep");
		ui.BChoice3.setText("Buy Beer");
		ui.BChoice4.setText("Buy another Meal");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Barkeep";
		game.nextPosition3 = "Beer";
		game.nextPosition4 = "Meal";
		game.nextPosition5 = "Save";
		
	}
	public void Beer() {
		ui.mainTextArea.setText("You bought some Beer/Mead from the Tavern and feel refreshed");
		player.PlayerHP = +5;
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Go Talk to the Barkeep");
		ui.BChoice3.setText("Buy another Beer");
		ui.BChoice4.setText("Buy A Meal");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Barkeep";
		game.nextPosition3 = "Beer";
		game.nextPosition4 = "Meal";
		game.nextPosition5 = "Save";
	}
	public void Barkeep() {
		ui.mainTextArea.setText("This is still not implemented");
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Buy Beer");
		ui.BChoice3.setText("Buy A Meal");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Beer";
		game.nextPosition3 = "Meal";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void Shop() {
		ui.mainTextArea.setText("You are now at the Town's Shop");
		ui.BChoice1.setText("Go Back to Town");
		ui.BChoice2.setText("Buy Items");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}

}
