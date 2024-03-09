package versus;
import java.util.Scanner;
public class Player {
			
			private String name;
    private int totalDamage;
    private static final String[] weaponsList = {"Staff", "Knife", "Sword", "Gun", "Bow", "Axe"};
    private String[] chosenWeapons = new String[3];
    private int[] weaponDamages = new int[3];

    public Player(String name) {
        this.name = name;
    }

    public void chooseWeapons(Scanner scanner) {
        System.out.println("\n" + name + ", select 3 weapons:");
        for (int i = 0; i < weaponsList.length; i++) {
            System.out.println((i + 1) + ". " + weaponsList[i]);
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("Choice " + (i + 1) + ": ");
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= weaponsList.length) {
                chosenWeapons[i] = weaponsList[choice - 1];
                weaponDamages[i] = (int) (Math.random() * 100) + 1;
            } else {
                System.out.println("Invalid choice, try again.");
                i--; //Decrement to allow another attempt for the current choice
            }
        }
        printChosenWeapons();
    }

    private void printChosenWeapons() {
        System.out.println("\n" + name + "'s selected weapons: ");
        for (int i = 0; i < chosenWeapons.length; i++) {
            System.out.println(chosenWeapons[i]);
        }
    }

    public void calculateDamage() {
        totalDamage = 0;
        System.out.println("\n" + name + " Weapon Damage:");
        for (int i = 0; i < chosenWeapons.length; i++) {
            System.out.println(chosenWeapons[i] + " Dmg: " + weaponDamages[i]);
            totalDamage += weaponDamages[i];
        }
        System.out.println("Total Damage: " + totalDamage);
    }

    public int getTotalDamage() {
        return totalDamage;
    }
			
}