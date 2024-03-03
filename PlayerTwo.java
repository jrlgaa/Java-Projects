package versus;

public class PlayerTwo {
			
			    public void playerTwoDetails() {
        System.out.println("\nPlayer 2 Weapons: \n1. Dagger \n2. Bow \n3. Staff");
    }
			    public class playerTwoDmg {
        int Dagger, Bow, Staff, totalDamage;

        public playerTwoDmg() {
            Dagger = (int)(Math.random() * 100) + 1;
            Bow = (int)(Math.random() * 100) + 1;
            Staff = (int)(Math.random() * 100) + 1;
            totalDamage = Dagger + Bow + Staff;
            System.out.println("\nHestia Weapon Damage:");
            System.out.println("Dagger Dmg:   " + Dagger);
            System.out.println("Bow Dmg:      " + Bow);
            System.out.println("Staff Dmg:    " + Staff);
            System.out.println("Total Damage: " + totalDamage);
        }
    }
			
}