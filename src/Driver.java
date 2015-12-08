//Michael Jeandron   
//Driver Class for Conniption

import java.util.Scanner;
import java.util.Random;

public class Driver {
	public static void main(String Args[]) {

		int flips1 = 4;
		int flips2 = 4;
		int flipAI;
		String flip = "";
		String lastMove = "";
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		Evaluation eval = new Evaluation();
		Random rand = new Random();
		// int num = eval.randColumn();
		// System.out.println(num);
		System.out.println("How many players? (0, 1, or 2)");
		int players = Integer.parseInt(scan.nextLine());
		int evalFunc;

		if (players == 0) {

			System.out.println("Which evaluation function do you want to use?");
			System.out.println("1 = Random, 2 = Simple");
			evalFunc = scan.nextInt();
			int useFlip = 0;
			int useColumn = 0;

			while (!(board.isWin('W') || board.isWin('R'))) {
				
				if (evalFunc == 1) {
					useFlip = eval.randFlip();
					useColumn = eval.randColumn();
				} else {
					//int useFlip = eval.simpleFlip();
					//int useFlip = eval.simpleColumn();
				}

				if (lastMove != "flip" && flips1 > 0) {
					System.out.println("Player one, do you want to flip? (y or n)");
					System.out.println(useFlip);
					flipAI = useFlip;
					System.out.println(String.valueOf(flipAI));
					if (flipAI == 0) {
						flips1--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
				System.out.println("Player one, in which column would you like to place a chip? (0-6)");
				board.makeMove(useColumn, 'W');
				lastMove = "drop";
				board.printBoard();
				if (flips1 > 0) {
					System.out.println("Player one, do you want to flip? (y or n)");
					flipAI = useFlip;
					System.out.println(String.valueOf(flipAI));
					if (flipAI == 0) {
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
					flipAI = useFlip;
					System.out.println(String.valueOf(flipAI));
					if (flipAI == 0) {
						flips2--;
						board = board.flipBoard();
						lastMove = "flip";
						board.printBoard();
					}
				}
				System.out.println("Player two, in which column would you like to place a chip? (0-6)");
				board.makeMove(useColumn, 'R');
				lastMove = "drop";
				board.printBoard();
				if (flips2 > 0) {
					System.out.println("Player two, do you want to flip? (y or n)");
					flipAI = useFlip;
					System.out.println(String.valueOf(flipAI));
					if (flipAI == 0) {
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
