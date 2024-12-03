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
		player.PlayerLVL = 1;
		player.PlayerEXP = 0;
		player.CurrentWeapon = new Weapon_Fists();
		
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
		ui.LevelLabelNumber.setText("" + player.PlayerLVL);
		ui.EXPLabelNumber.setText("" + player.PlayerEXP);
	}

	public void selectPosition(String nextPosition) {
		defaultSetup();
		switch(nextPosition) {

		case "Questboard": Questboard(); break;
		case "Tavern": Tavern(); break;
		case "Shop": Shop(); break;
		case "Town": Town(); break;
		case "Barkeep": Barkeep(); break;
		case "Meal": Meal(); break;
		case "Beer": Beer(); break;

		case "Forest": Forest(); break;
		case "Camp": Camp(); break;
		case "ForestLeft": ForestLeft(); break;
		case "ForestRight": ForestRight(); break;
		case "ForestForward": ForestForward(); break;
		case "MonsterEncounterForest": MonsterEncounterForest(); break;
		case "FightForest": FightForest(); break;
		case "PlayerAttackForest": PlayerAttackForest(); break;
		case "MonsterAttackForest": MonsterAttackForest(); break;
		case "WinForest": WinForest(); break;

		case "Lost": Lost(); break;
		case "MoreTown": MoreTown(); break;
		case "MoreForest": MoreForest(); break;
		case "MoreCave": MoreCave(); break;
		case "MoreCaverns": MoreCaverns(); break;
		case "MoreDesert": MoreDesert(); break;
		case "MoreMountain": MoreMountain(); break;

		case "Save": Save(); break;

		case "Cave": Cave(); break;
		case "Caverns": Caverns(); break;
		case "CampCavern": CampCavern(); break;
		case "MonsterEncounterCaverns": MonsterEncounterCaverns(); break;
		case "FightCavern": FightCavern(); break;
		case "PlayerAttackCavern": PlayerAttackForest(); break;
		case "MonsterAttackCavern": MonsterAttackCavern(); break;
		case "WinCaverns": WinCaverns(); break;

		case "Desert" : Desert(); break;
		case "CampDesert": CampDesert(); break;
		case "MonsterEncounterDesert": MonsterEncounterDesert(); break;
		case "FightDesert": FightDesert(); break;
		case "PlayerAttackDesert": PlayerAttackDesert(); break;
		case "MonsterAttackDesert": MonsterAttackDesert(); break;
		case "WinDesert": WinDesert(); break;

		case "Mountain" : Mountain(); break;
		case "CampMountain": CampMountain(); break;
		case "MonsterEncounterMountain": MonsterEncounterMountain(); break;
		case "FightMountain": FightMountain(); break;
		case "PlayerAttackMountain": PlayerAttackMountain(); break;
		case "MonsterAttackMountain": MonsterAttackMountain(); break;
		case "WinMountain": WinMountain(); break;
		}
	}

	//Town//
	public void Town() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Town Theme.wav");
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You are In Town, What would you like to do?");
		ui.BChoice1.setText("Go To the Questboard");
		ui.BChoice2.setText("Go To the Forest");
		ui.BChoice3.setText("Go To the Tavern");
		ui.BChoice4.setText("Go To the Shop");
		ui.BChoice5.setText("More");
		
		game.nextPosition1 = "Questboard";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "Tavern";
		game.nextPosition4 = "Shop";
		game.nextPosition5 = "MoreTown";
	}

	//Shop//
public void Shop() {
	ui.mainTextArea.setText("You are now at the Town's Shop");
	ui.BChoice1.setText("Go Back to Town");
	ui.BChoice2.setText("Buy Items");
	ui.BChoice3.setText("");
	ui.BChoice4.setText("");
	ui.BChoice5.setText("More");
	
	game.nextPosition1 = "Town";
	game.nextPosition2 = "";
	game.nextPosition3 = "";
	game.nextPosition4 = "";
	game.nextPosition5 = "MoreShop";
}

	public void Questboard() {
		ui.mainTextArea.setText("Pick A Quest");
		ui.BChoice1.setText("Go Back");
		ui.BChoice2.setText("Aspirant");
		ui.BChoice3.setText("Low Rank");
		ui.BChoice4.setText("High Rank");
		ui.BChoice5.setText("More");
		
		game.nextPosition1 = "Town";
		game.nextPosition2 = "Introductions";
		game.nextPosition3 = "Low Rank";
		game.nextPosition4 = "High Rank";
		game.nextPosition5 = "MoreQuests";
		
	}

	//General Functionalities//
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
	}

		public void MoreTown(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryTown";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Town";

	}

	public void MoreForest(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryForest";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Forest";
	}

	public void MoreCave(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryCave";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Cave";
	}

	public void MoreCaverns(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryCaverns";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Caverns";
	}

	public void MoreDesert(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryDesert";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Desert";
	}

	public void MoreMountain(){
		ui.mainTextArea.setText("");
		ui.BChoice1.setText("Save");
		ui.BChoice2.setText("Inventory");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Back");

		game.nextPosition1 = "Save";
		game.nextPosition2 = "InventoryMountain";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Mountain";
	}

	//Forest//
	public void Forest() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Forest Music.wav");
		Game.bgMusic.adjustVolume(-20);
		Game.bgMusic.loop();

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
		ui.BChoice4.setText("Go to the Mountain");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounterForest";
		game.nextPosition4 = "Mountain";
		game.nextPosition5 = "Save";
		
	}
	public void ForestRight() {
		ui.mainTextArea.setText("You Went to the Right of the Forest");
		ui.BChoice1.setText("Go Back to The Forest Entrance");
		ui.BChoice2.setText("Camp a bit");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("Go to the Desert");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounterForest";
		game.nextPosition4 = "Desert";
		game.nextPosition5 = "Save";
	}

	public void ForestForward() {
		ui.mainTextArea.setText("You Went to Deeper into the Forest");
		ui.BChoice1.setText("Go Back to The Forest Entrance");
		ui.BChoice2.setText("Camp a bit");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("Go to The Caverns");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "Camp";
		game.nextPosition3 = "MonsterEncounterForest";
		game.nextPosition4 = "Caverns";
		game.nextPosition5 = "Save";
	}

	public void Camp() {
		player.PlayerHP += 10;
		if (player.PlayerHP > 100) player.PlayerHP = 100;
		ui.mainTextArea.setText("You Set Up Camp, and you feel refreshed");
		ui.BChoice1.setText("Go Back to the Forest Entrance");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}
	public void MonsterEncounterForest() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Enemy Encounter.wav");
		Game.bgMusic.loop();
		Game.bgMusic.adjustVolume(-20);
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
		
		game.nextPosition1 = "FightForest";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void FightForest() {
ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do You Do?");
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("Retreat");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		game.nextPosition1 = "PlayerAttackForest";
		game.nextPosition2 = "Town";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
		//Forest//
	public void PlayerAttackForest() {
		new Sound("src/Assets/Attack SFX.wav").play();
		int playerDMG = new java.util.Random().nextInt(player.CurrentWeapon.Weapon_dmg);
		
		ui.mainTextArea.setText("You attacked the " + monster.name + " For " + playerDMG + " DMG");
		monster.hp = monster.hp - playerDMG;
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(monster.hp>0) {
			game.nextPosition1 = "MonsterAttackForest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp<1) {
			game.nextPosition1 = "WinForest";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void MonsterAttackForest() {
		new Sound("src/Assets/Attack SFX.wav").play();
		int monsterDamage = new java.util.Random().nextInt(monster.dmg);
		ui.mainTextArea.setText(monster.AttackMSG + "\nYou Recieved " + monsterDamage + " DMG");
		player.PlayerHP = player.PlayerHP - monsterDamage;
		ui.hpLabelNumber.setText("" + player.PlayerHP);
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(player.PlayerHP>0) {
			game.nextPosition1 = "FightForest";
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
	public void WinForest() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Victory.wav");
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You are Victorious, You Defeated the " + monster.name + " You also gained some money and experience");
		
		checkLevelUp();
		player.Money += 50;
		player.PlayerEXP += 400;
		ui.BChoice1.setText("Stay and Fight More");
		ui.BChoice2.setText("Go back to the Town");
		ui.BChoice3.setText("Camp for a while");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "MonsterEncounterForest";
		game.nextPosition2 = "Town";
		game.nextPosition3 = "Camp";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";

		if(player.PlayerEXP == 1000){
			player.PlayerLVL += 1;
			ui.mainTextArea.setText("Congratulations, you leveled up");
		}
	}

		//Losing//
	public void Lost() {
		Game.bgMusic.stop();
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

		//Tavern//
	public void Tavern() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Tavern BG.wav");
		Game.bgMusic.loop();
		
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

		//Bar Functionalities//
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
	
	//Cave//
	public void Cave() {

		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Cavern.wav");
		Game.bgMusic.loop();

		ui.mainTextArea.setText("You stumble across a Cave with an Ominous Aura around it, proceed?");
		ui.BChoice1.setText("Proceed Inside");
		ui.BChoice2.setText("Go Back");
		ui.BChoice3.setText("Wait for Monsters");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Caverns";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";	
	}
		//Caverns//

		public void Caverns() {
			Game.bgMusic.stop();
			Game.bgMusic = new Sound("src/Assets/Cavern Theme.wav");
			Game.bgMusic.loop();

			ui.mainTextArea.setText("You proceeded into the Cave");
			ui.BChoice1.setText("Camp");
			ui.BChoice2.setText("Wait for Monsters");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			ui.BChoice5.setText("Save");
			
			game.nextPosition1 = "CampCavern";
			game.nextPosition2 = "MonsterEncounterCaverns";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			game.nextPosition5 = "Save";	
		}

		public void CampCavern() {
			player.PlayerHP += 10;
			if (player.PlayerHP > 100) player.PlayerHP = 100;
			ui.mainTextArea.setText("You Set Up Camp, and you feel refreshed");
			ui.BChoice1.setText("Go back to the Caverns");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			ui.BChoice5.setText("Save");
			
			game.nextPosition1 = "Caverns";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			game.nextPosition5 = "Save";
		}

		public void MonsterEncounterCaverns() {

			Game.bgMusic.stop();
			Game.bgMusic = new Sound("src/Assets/Fortuna Enemy Encounter.wav");
			Game.bgMusic.loop();
			Game.bgMusic.adjustVolume(-20);
			int i = new java.util.Random().nextInt(3)+1;
			if(i==1) {
				monster = new MonsterCavern_Bear();
			}

			else if(i==2) {
				monster = new MonsterCavern_Spider();
			}
			else if (i==3) {
				monster = new MonsterCavern_Orc();
			}
			ui.mainTextArea.setText("You Encountered a Wild " + monster.name + " while exploring the Caverns");
			
			ui.BChoice1.setText("Fight");
			ui.BChoice2.setText("Flee");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			game.nextPosition1 = "FightCavern";
			game.nextPosition2 = "Cave";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}

		public void FightCavern() {
			ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do You Do?");
					
					ui.BChoice1.setText("Attack");
					ui.BChoice2.setText("Retreat");
					ui.BChoice3.setText("");
					ui.BChoice4.setText("");
					
					game.nextPosition1 = "PlayerAttackCavern";
					game.nextPosition2 = "Town";
					game.nextPosition3 = "";
					game.nextPosition4 = "";
				}
		public void PlayerAttackCavern() {
			new Sound("src/Assets/Attack SFX.wav").play();
			int playerDMG = new java.util.Random().nextInt(player.CurrentWeapon.Weapon_dmg);
			
			ui.mainTextArea.setText("You attacked the " + monster.name + " For " + playerDMG + " DMG");
			monster.hp = monster.hp - playerDMG;
			
			ui.BChoice1.setText("Attack");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			if(monster.hp>0) {
				game.nextPosition1 = "MonsterAttackCavern";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
				game.nextPosition4 = "";
			}
			else if(monster.hp<1) {
				game.nextPosition1 = "WinCaverns";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
				game.nextPosition4 = "";
			}
		}

		public void MonsterAttackCavern() {
			new Sound("src/Assets/Attack SFX.wav").play();
			int monsterDamage = new java.util.Random().nextInt(monster.dmg);
			ui.mainTextArea.setText(monster.AttackMSG + "\nYou Recieved " + monsterDamage + " DMG");
			player.PlayerHP = player.PlayerHP - monsterDamage;
			ui.hpLabelNumber.setText("" + player.PlayerHP);
			
			ui.BChoice1.setText("Attack");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			if(player.PlayerHP>0) {
				game.nextPosition1 = "FightCaverns";
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
	
	public void WinCaverns() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Victory.wav");
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You are Victorious, You Defeated the " + monster.name + " You also gained some money and experience");

		checkLevelUp();
		player.Money += 150;
		player.PlayerEXP += 250;
		ui.BChoice1.setText("Stay and Fight More");
		ui.BChoice2.setText("Go back to the Forest");
		ui.BChoice3.setText("Camp for a while");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "MonsterEncounterCavern";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "CampCavern";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}

		//Desert//
	public void Desert() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Forest Music.wav");
		Game.bgMusic.adjustVolume(-20);
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You've reached the Desert and see a Town ahead you");
		ui.BChoice1.setText("Go Back to the Forest");
		ui.BChoice2.setText("Go Left");
		ui.BChoice3.setText("Go Right");
		ui.BChoice4.setText("Go Forward");
		ui.BChoice5.setText("Save");
	}

		public void CampDesert() {
			player.PlayerHP += 10;
			if (player.PlayerHP > 100) player.PlayerHP = 100;
			ui.mainTextArea.setText("You Set Up Camp, and you feel refreshed");
			ui.BChoice1.setText("Go back to Exploring the Desert");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			ui.BChoice5.setText("Save");
			
			game.nextPosition1 = "Desert";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			game.nextPosition5 = "Save";
		}

		public void MonsterEncounterDesert() {
			Game.bgMusic.stop();
			Game.bgMusic = new Sound("src/Assets/Fortuna Enemy Encounter.wav");
			Game.bgMusic.loop();
			Game.bgMusic.adjustVolume(-20);
			int i = new java.util.Random().nextInt(3)+1;
			if(i==1) {
				monster = new MonsterCavern_Bear();
			}
			else if(i==2) {
				monster = new MonsterCavern_Spider();
			}
			else if (i==3) {
				monster = new MonsterCavern_Orc();
			}
			ui.mainTextArea.setText("You Encountered a Wild " + monster.name + " while exploring the Desert");
			
			ui.BChoice1.setText("Fight");
			ui.BChoice2.setText("Flee");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			game.nextPosition1 = "FightDesert";
			game.nextPosition2 = "Cave";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}

		public void FightDesert() {
			ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do You Do?");
					
					ui.BChoice1.setText("Attack");
					ui.BChoice2.setText("Retreat");
					ui.BChoice3.setText("");
					ui.BChoice4.setText("");
					
					game.nextPosition1 = "PlayerAttackDesert";
					game.nextPosition2 = "Town";
					game.nextPosition3 = "";
					game.nextPosition4 = "";
				}

		public void PlayerAttackDesert() {
			new Sound("src/Assets/Attack SFX.wav").play();
			int playerDMG = new java.util.Random().nextInt(player.CurrentWeapon.Weapon_dmg);
			
			ui.mainTextArea.setText("You attacked the " + monster.name + " For " + playerDMG + " DMG");
			monster.hp = monster.hp - playerDMG;
			
			ui.BChoice1.setText("Attack");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			if(monster.hp>0) {
				game.nextPosition1 = "MonsterAttackDesert";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
				game.nextPosition4 = "";
			}
			else if(monster.hp<1) {
				game.nextPosition1 = "WinDesert";
				game.nextPosition2 = "";
				game.nextPosition3 = "";
				game.nextPosition4 = "";
			}
		}
		public void MonsterAttackDesert() {
			new Sound("src/Assets/Attack SFX.wav").play();
			int monsterDamage = new java.util.Random().nextInt(monster.dmg);
			ui.mainTextArea.setText(monster.AttackMSG + "\nYou Recieved " + monsterDamage + " DMG");
			player.PlayerHP = player.PlayerHP - monsterDamage;
			ui.hpLabelNumber.setText("" + player.PlayerHP);
			
			ui.BChoice1.setText("Attack");
			ui.BChoice2.setText("");
			ui.BChoice3.setText("");
			ui.BChoice4.setText("");
			
			if(player.PlayerHP>0) {
				game.nextPosition1 = "FightDesert";
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

	public void WinDesert() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Victory.wav");
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You are Victorious, You Defeated the " + monster.name + " You also gained some money and experience");

		checkLevelUp();
		player.Money += 150;
		player.PlayerEXP += 250;
		ui.BChoice1.setText("Stay and Fight More");
		ui.BChoice2.setText("Go back to the Desert");
		ui.BChoice3.setText("Camp for a while");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "MonsterEncounterDesert";
		game.nextPosition2 = "Forest";
		game.nextPosition3 = "CampCavern";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}

		//Mountain//
	public void Mountain() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Forest Music.wav");
		Game.bgMusic.adjustVolume(-20);
		Game.bgMusic.loop();
		ui.mainTextArea.setText("You've managed to climb the Mountain. You see a Town");
		ui.BChoice1.setText("Go Back to the Forest");
		ui.BChoice2.setText("Go to the Mountain Outpost");
		ui.BChoice3.setText("Go to the Mountain Cave");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Forest";
		game.nextPosition2 = "MountainTown";
		game.nextPosition3 = "MountainCave";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}

	public void CampMountain() {
		player.PlayerHP += 10;
		if (player.PlayerHP > 100) player.PlayerHP = 100;
		ui.mainTextArea.setText("You Set Up Camp, and you feel refreshed");
		ui.BChoice1.setText("Go back to Exploring the Mountain");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		ui.BChoice5.setText("Save");
		
		game.nextPosition1 = "Mountain";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		game.nextPosition5 = "Save";
	}

	public void MonsterEncounterMountain() {
		Game.bgMusic.stop();
		Game.bgMusic = new Sound("src/Assets/Fortuna Enemy Encounter.wav");
		Game.bgMusic.loop();
		Game.bgMusic.adjustVolume(-20);
		int i = new java.util.Random().nextInt(3)+1;
		if(i==1) {
			monster = new MonsterCavern_Bear();
		}
		else if(i==2) {
			monster = new MonsterCavern_Spider();
		}
		else if (i==3) {
			monster = new MonsterCavern_Orc();
		}
		ui.mainTextArea.setText("You Encountered a Wild " + monster.name + " while exploring the Mountain");
		
		ui.BChoice1.setText("Fight");
		ui.BChoice2.setText("Flee");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		game.nextPosition1 = "FightMountain";
		game.nextPosition2 = "Cave";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}

	public void FightMountain() {
		ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do You Do?");
				
				ui.BChoice1.setText("Attack");
				ui.BChoice2.setText("Retreat");
				ui.BChoice3.setText("");
				ui.BChoice4.setText("");
				
				game.nextPosition1 = "PlayerAttackMountain";
				game.nextPosition2 = "Town";
				game.nextPosition3 = "";
				game.nextPosition4 = "";
			}

	public void PlayerAttackMountain() {
		new Sound("src/Assets/Attack SFX.wav").play();
		int playerDMG = new java.util.Random().nextInt(player.CurrentWeapon.Weapon_dmg);
		
		ui.mainTextArea.setText("You attacked the " + monster.name + " For " + playerDMG + " DMG");
		monster.hp = monster.hp - playerDMG;
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(monster.hp>0) {
			game.nextPosition1 = "MonsterAttackMountain";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(monster.hp<1) {
			game.nextPosition1 = "WinMountain";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	public void MonsterAttackMountain() {
		new Sound("src/Assets/Attack SFX.wav").play();
		int monsterDamage = new java.util.Random().nextInt(monster.dmg);
		ui.mainTextArea.setText(monster.AttackMSG + "\nYou Recieved " + monsterDamage + " DMG");
		player.PlayerHP = player.PlayerHP - monsterDamage;
		ui.hpLabelNumber.setText("" + player.PlayerHP);
		
		ui.BChoice1.setText("Attack");
		ui.BChoice2.setText("");
		ui.BChoice3.setText("");
		ui.BChoice4.setText("");
		
		if(player.PlayerHP>0) {
			game.nextPosition1 = "FightMountain";
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

public void WinMountain() {
	Game.bgMusic.stop();
	Game.bgMusic = new Sound("src/Assets/Fortuna Victory.wav");
	Game.bgMusic.loop();
	ui.mainTextArea.setText("You are Victorious, You Defeated the " + monster.name + " You also gained some money and experience");

	checkLevelUp();
	player.Money += 150;
	player.PlayerEXP += 250;
	ui.BChoice1.setText("Stay and Fight More");
	ui.BChoice2.setText("Go back to the Mountain");
	ui.BChoice3.setText("Camp for a while");
	ui.BChoice4.setText("");
	ui.BChoice5.setText("Save");
	
	game.nextPosition1 = "MonsterEncounterMountain";
	game.nextPosition2 = "Mountain";
	game.nextPosition3 = "CampMountain";
	game.nextPosition4 = "";
	game.nextPosition5 = "Save";
}


		//Checking if Player had enough EXP to levelup
	public void checkLevelUp() {
		int expForNextLevel = player.PlayerLVL * 1000;

		if (player.PlayerEXP >= expForNextLevel) {
			// Increase level
			player.PlayerLVL++;
			player.PlayerEXP -= expForNextLevel;  // Reduce EXP by the level-up threshold
			
			// Optional: Increase stats upon leveling up
			player.PlayerHP += 50;  // Example: increase HP by 10 per level-up
			player.PlayerEXP = 0;
			ui.mainTextArea.setText("Congratulations! You leveled up to level " + player.PlayerLVL + "!");}
		}
}
