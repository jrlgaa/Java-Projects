package versus;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		PlayerOne detailsOne = new PlayerOne();
		PlayerTwo detailsTwo = new PlayerTwo();

		detailsOne.playerOneDetails();
		detailsTwo.playerTwoDetails();
		
		while (true) {
			PlayerOne.playerOneDmg playerOneDmg = detailsOne.new playerOneDmg();
			PlayerTwo.playerTwoDmg playerTwoDmg = detailsTwo.new playerTwoDmg();

			if (playerOneDmg.totalDamage > playerTwoDmg.totalDamage) {
				System.out.println("\nPlayer One win!");
			} else if (playerTwoDmg.totalDamage > playerOneDmg.totalDamage) {
				System.out.println("\nPlayer Two win!");
			} else {
				System.out.println("\nIt's a draw!");
			}
			System.out.print("\nDo you want to play again? Y/N: ");
			char playAgain = input.next().charAt(0);

			if (playAgain == 'N' || playAgain == 'n') {
				System.out.println("Thank you for playing.");
				break;
			}
		}
	}
}