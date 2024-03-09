package versus;

import java.util.Scanner;

public class Main {
			
			public static void main(String[] args) {
						
						     Scanner scanner = new Scanner(System.in);
        Player playerOne = new Player("Player One");
        Player playerTwo = new Player("Player Two");

        System.out.println("Welcome to the Weapon Battle Game!");

       
        char playAgain;
        do {
           
            playerOne.chooseWeapons(scanner);
            playerTwo.chooseWeapons(scanner);
         
            playerOne.calculateDamage();
            playerTwo.calculateDamage();
   
            determineWinner(playerOne, playerTwo);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Thank you for playing!");
    }

    private static void determineWinner(Player playerOne, Player playerTwo) {
        int damageOne = playerOne.getTotalDamage();
        int damageTwo = playerTwo.getTotalDamage();

        System.out.println("\nFinal Results:");
        System.out.println("Player One Total Damage: " + damageOne);
        System.out.println("Player Two Total Damage: " + damageTwo);

        if (damageOne > damageTwo) {
            System.out.println("Player One wins!");
        } else if (damageTwo > damageOne) {
            System.out.println("Player Two wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
						
						
			}
			
