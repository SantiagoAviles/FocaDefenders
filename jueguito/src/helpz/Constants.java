package helpz;

public class Constants {

	public static class Projectiles {
		public static final int ARROW = 0;
		public static final int ATOM = 1;
		public static final int BOMB = 2;
		public static final int ICESPIKE = 3;
		public static final int POISONDART = 4;
		public static final int XBOWARROW = 5;
		public static final int SNIPERBULLET = 6;
		public static final int SNOWBALL = 7;

		public static float GetSpeed(int type) {
			switch (type) {
				case ARROW:
					return 8f;
				case BOMB:
					return 4f;
				case ATOM:
					return 6f;
				case ICESPIKE:
					return 5f;
				case POISONDART:
					return 7f;
				case XBOWARROW:
					return 35f;
				case SNIPERBULLET:
					return 36f;
				case SNOWBALL:
					return 11f;
			}
			return 0f;
		}
	}

	public static class Towers {
		public static final int CANNON = 0;
		public static final int ARCHER = 1;
		public static final int WIZARD = 2;
		public static final int FREEZER = 3;
		public static final int POISONER = 4;
		public static final int SNIPER = 5;
		public static final int XBOW = 6;
		public static final int INVESTOR = 7;
		public static final int CHEER = 8;
		public static final int THROWER = 9;

		public static int GetTowerCost(int towerType) {
			switch (towerType) {
				case CANNON:
					return 200;
				case ARCHER:
					return 75;
				case WIZARD:
					return 175;
				case FREEZER, POISONER:
					return 450;
				case SNIPER:
					return 800;
				case XBOW:
					return 1000;
				case INVESTOR:
					return 600;
				case CHEER:
					return 750;
				case THROWER:
					return 25;
				}
			return 0;
		}

		public static String GetName(int towerType) {
			switch (towerType) {
				case CANNON:
					return "Cañon";
				case ARCHER:
					return "Arquero Foca";
				case WIZARD:
					return "Mago Foca";
				case FREEZER:
					return "Congelador";
				case POISONER:
					return "Envenenador";
				case SNIPER:
					return "Francotirador";
				case XBOW:
					return "Ballesta";
				case INVESTOR:
					return "Inversor";
				case CHEER:
					return "Porrista";
				case THROWER:
					return "Lanzabolas";
			}
			return "";
		}

		public static int GetStartDmg(int towerType) {
			switch (towerType) {
				case CANNON:
					return 40;
				case ARCHER:
					return 10;
				case WIZARD:
					return 5;
				case FREEZER:
					return 25;
				case POISONER:
					return 35;
				case SNIPER:
					return 500;
				case XBOW, THROWER:
					return 1;
				case INVESTOR, CHEER:
					return 0;
			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
				case CANNON:
					return 75;
				case ARCHER:
					return 120;
				case WIZARD:
					return 100;
				case FREEZER:
					return 95;
				case POISONER:
					return 90;
				case SNIPER, XBOW:
					return 500;
				case INVESTOR:
					return 0;
				case CHEER:
					return 25;
				case THROWER:
					return 50;
			}
			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {
				case CANNON:
					return 120;
				case ARCHER:
					return 35;
				case WIZARD:
					return 50;
				case FREEZER:
					return 80;
				case POISONER:
					return 75;
				case SNIPER:
					return 500;
				case XBOW, THROWER:
					return 20;
				case INVESTOR, CHEER:
					return 0;
			}

			return 0;
		}
	}

	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class Enemies {

		public static final int FISH = 0;
		public static final int SEAGULL = 1;
		public static final int PENGUIN = 2;
		public static final int CRAB = 3;
		public static final int SEALION = 4;
		public static final int OCTOPUS = 5;
		public static final int REBELSEAL = 6;
		public static final int TURTLE = 7;
		public static final int WHALE = 8;
		public static final int POLARBEAR = 9;

		public static int GetReward(int enemyType) {
			switch (enemyType) {
				case FISH:
					return 10;
				case SEAGULL:
					return 20;
				case PENGUIN:
					return 50;
				case CRAB:
					return 100;
				case SEALION:
					return 250;
				case OCTOPUS:
					return 300;
				case REBELSEAL:
					return 500;
				case TURTLE:
					return 700;
				case WHALE:
					return 850;
				case POLARBEAR:
					return 1000;
				}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
				case FISH:
					return 0.9f;
				case SEAGULL:
					return 1.2f;
				case PENGUIN:
					return 0.85f;
				case CRAB:
					return 0.55f;
				case SEALION:
					return 1.4f;
				case OCTOPUS:
					return 0.8f;
				case REBELSEAL:
					return 1.1f;
				case TURTLE:
					return 0.75f;
				case WHALE:
					return 0.65f;
				case POLARBEAR:
					return 0.45f;
			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
				case FISH:
					return 25;
				case SEAGULL:
					return 50;
				case PENGUIN:
					return 100;
				case CRAB:
					return 350;
				case SEALION:
					return 135;
				case OCTOPUS:
					return 475;
				case REBELSEAL:
					return 700;
				case TURTLE:
					return 1250;
				case WHALE:
					return 3500;
				case POLARBEAR:
					return 5000;
			}
			return 0;
		}
	}

	public static class Tiles {
		public static final int WATER_TILE = 0;
		public static final int GRASS_TILE = 1;
		public static final int ROAD_TILE = 2;
	}

}
