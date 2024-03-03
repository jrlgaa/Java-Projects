package versus;

public class PlayerOne {

	public void playerOneDetails() {
		System.out.println("Player 1 Weapons: \n1. Sword \n2. Dagger \n3. Long Sword");
	}

	public class playerOneDmg {
		int Sword, Dagger, LongSword, totalDamage;

		public playerOneDmg() {
			Sword = (int) (Math.random() * 100) + 1;
			Dagger = (int) (Math.random() * 100) + 1;
			LongSword = (int) (Math.random() * 100) + 1;
			totalDamage = Sword + Dagger + LongSword;
			System.out.println("\nPlayer 1 Weapon Damage:");
			System.out.println("Sword Dmg:      " + Sword);
			System.out.println("Dagger Dmg:     " + Dagger);
			System.out.println("Long Sword Dmg: " + LongSword);
			System.out.println("Total Damage:   " + totalDamage);
		}
	}

}