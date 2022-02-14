package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int winner = 0;
		int player1Score = 0;
		int player2Score = 0;
		int drawScore = 0;
		int playAgain = 0;
		int yourTurn = 1;
		int firstToPlay = 1;

		System.out.println("     Tic Tac Toe");
		System.out.println();

		do {
			int[][] rulesBoard = new int[3][3];
			String[][] printedBoard = new String[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					printedBoard[i][j] = " ";
				}
			}

			while (winner != 1) {

				// PrintedBoard printing starts
				System.out.println("         Score");
				System.out.println("  Player 1  " + player1Score + " Score");
				System.out.println("  Player 2  " + player2Score + " Score");
				System.out.println("  Draw      " + drawScore + " Score");

				System.out.println();

				System.out.println("       0   1   2");
				System.out.println("       -   -   -");
				System.out.println(
						"   0|  " + printedBoard[0][0] + " | " + printedBoard[0][1] + " | " + printedBoard[0][2]);
				System.out.println("      -----------");
				System.out.println(
						"   1|  " + printedBoard[1][0] + " | " + printedBoard[1][1] + " | " + printedBoard[1][2]);
				System.out.println("      -----------");
				System.out.println(
						"   2|  " + printedBoard[2][0] + " | " + printedBoard[2][1] + " | " + printedBoard[2][2]);
				// End of printedBoard printing

				System.out.println();
				System.out.println();

				// Start of the conditions for victory or draw
				int conditional1 = 0;
				int conditional2 = 0;

				for (int i = 0; i < 3; i++) {

					int sum1 = 0;
					int sum2 = 0;

					for (int j = 0; j < 3; j++) {

						sum1 += rulesBoard[i][j];
						sum2 += rulesBoard[j][i];

						if (sum1 == 3 || sum2 == 3) {
							conditional1 = 1;
						} else if (sum1 == -3 || sum2 == -3) {
							conditional1 = -1;
						}
						if (rulesBoard[i][j] == 1 || rulesBoard[i][j] == -1) {
							conditional2++;
						}
					}
				}

				if (rulesBoard[0][0] + rulesBoard[1][1] + rulesBoard[2][2] == 3
						|| rulesBoard[0][2] + rulesBoard[1][1] + rulesBoard[2][0] == 3) {
					conditional1 = 1;
				} else if (rulesBoard[0][2] + rulesBoard[1][1] + rulesBoard[2][0] == -3
						|| rulesBoard[0][0] + rulesBoard[1][1] + rulesBoard[2][2] == -3) {
					conditional1 = -1;
				}

				if (conditional1 == 1) {
					winner = 1;
					player1Score += 1;
					System.out.println("Player 1 Win !!!");
				} else if (conditional1 == -1) {
					winner = 1;
					player2Score += 1;
					System.out.println("Player 2 Win !!!");
				}

				else if (conditional2 == 9) {
					winner = 1;
					drawScore += 1;
					System.out.println("Draw !!!");
				}
				// End of victory or draw conditions

				// Start of move positions
				if (winner != 1) {
					System.out.println("Player " + yourTurn + ", type a number for the line and press enter:");
					int position1 = sc.nextInt();
					System.out.println("Player " + yourTurn + ", type a number for the column and press enter:");
					int position2 = sc.nextInt();

					while (rulesBoard[position1][position2] != 0) {
						System.out.println("Position already taken, playing in a free position !");
						System.out.println("Player " + yourTurn + ", type a number for the column and press enter:");
						position1 = sc.nextInt();
						System.out.println("Player " + yourTurn + ", type a number for the line and press enter:");
						position2 = sc.nextInt();
					}

					if (yourTurn == 1) {
						rulesBoard[position1][position2] = 1;
						printedBoard[position1][position2] = "X";
						yourTurn = 2;
					} else {
						rulesBoard[position1][position2] = -1;
						printedBoard[position1][position2] = "O";
						yourTurn = 1;
					}
				}
				// End of move positions

				System.out.println();
				System.out.println();
			}

			// Exchange who starts the game
			winner = 0;
			if (firstToPlay % 2 == 0) {
				yourTurn = 1;
			} else {
				yourTurn = 2;
			}

			firstToPlay++;
			// End of the change of starters

			System.out.println("Play again?");
			System.out.println("1 Yes");
			System.out.println("0 No");
			playAgain = sc.nextInt();

		} while (playAgain > 0);
		System.out.println("Game Over !!!");
		sc.close();
	}
}
