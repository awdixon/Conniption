//Michael Jeandron   
//Driver Class for Conniption

import java.util.Scanner;

public class Driver {
	public static void main(String Args[]) {

		int flips1 = 4;
		int flips2 = 4;
		String flip = "";
		String lastMove = "";
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		System.out.println("How many players? (0, 1, or 2)");
		int players = Integer.parseInt(scan.nextLine());
		if (players == 0) {

		}
		if (players == 1) {

		}
		if (players == 2) {
			while (!(board.isWin('W') || board.isWin('R'))) {
				if (lastMove != "flip" && flips1 > 0) {
					System.out.println("Player one, do you want to flip? (y or n)");
					flip = scan.nextLine();
					if (flip.equals("y")) {
						flips1--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
				System.out.println("Player one, in which column would you like to place a chip? (0-6)");
				board.makeMove(Integer.parseInt(scan.nextLine()), 'W');
				lastMove = "drop";
				board.printBoard();
				if (flips1 > 0) {
					System.out.println("Player one, do you want to flip? (y or n)");
					flip = scan.nextLine();
					if (flip.equals("y")) {
						flips1--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
				if (board.isWin('W')) {
					System.out.println("The winner is player one.");
					break;
				}
				if (lastMove != "flip" && flips2 > 0) {
					System.out.println("Player two, do you want to flip? (y or n)");
					flip = scan.nextLine();
					if (flip.equals("y")) {
						flips2--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
				System.out.println("Player two, in which column would you like to place a chip? (0-6)");
				board.makeMove(Integer.parseInt(scan.nextLine()), 'R');
				lastMove = "drop";
				board.printBoard();
				if (flips2 > 0) {
					System.out.println("Player two, do you want to flip? (y or n)");
					flip = scan.nextLine();
					if (flip.equals("y")) {
						flips2--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
			}
			if (board.isWin('R')) {
				System.out.println("The winner is player two.");
			}
		}
	}
}
