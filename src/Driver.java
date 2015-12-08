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
         System.out.println("Play against random or eval?");
         if (scan.nextLine().charAt(0) == 'r'){
            while (!(board.isWin('W') || board.isWin('R'))){
               if (lastMove != "flip" && flips1 > 0) {
                  System.out.println("Player one, do you want to flip? (y or n)");
                  flip = scan.nextLine();
                  if (flip.equals("y")){
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
               if (flips1 > 0){
                  System.out.println("Player one, do you want to flip? (y or n)");
                  flip = scan.nextLine();
                  if (flip.equals("y")){
                     flips1--;
                     board = board.flipBoard();
                     lastMove = "flip";
                     board.printBoard();
                  }
               }
               if (board.isWin('W')){
                  break;
               }
               if (lastMove != "flip" && flips2 > 0) {
                  if ((int)(Math.random()*2) == 0){
                     flips2--;
                     board = board.flipBoard();
                     lastMove = "flip";
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                  }
               }
               int d = (int)(Math.random()*7);
               board.makeMove(d, 'R');
               lastMove = "drop";
               board.printBoard();
               System.out.println("Computer has dropped in column " + d + ". Press Enter.");
               scan.nextLine();
               if (flips2 > 0){
                  if ((int)(Math.random()*2) == 0){
                     flips2--;
                     board = board.flipBoard();
                     lastMove = "flip";
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                  }
               }
            }
            if (board.isWin('W')){
               System.out.println("The winner is player one.");
            }
            if (board.isWin('R')){
               System.out.println("The winner is player two.");
            }
         }
         else{
            int[] es = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            Evaluation e = new Evaluation();
            AlphaBetaPruning abp = new AlphaBetaPruning();
            Vector<Board> v1 = abp.childrenOf(board, 'R');
            board = board.flipBoard();
            Vector<Board> v2 = abp.childrenOf(board, 'R');
            board = board.flipBoard();
            while (!(board.isWin('W') || board.isWin('R'))){
               if (lastMove != "flip" && flips1 > 0) {
                  System.out.println("Player one, do you want to flip? (y or n)");
                  flip = scan.nextLine();
                  if (flip.equals("y")){
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
               if (flips1 > 0){
                  System.out.println("Player one, do you want to flip? (y or n)");
                  flip = scan.nextLine();
                  if (flip.equals("y")){
                     flips1--;
                     board = board.flipBoard();
                     lastMove = "flip";
                     board.printBoard();
                  }
               }
               if (board.isWin('W')){
                  break;
               }
               if (lastMove != "flip" && flips2 > 0) {
                  for (int i = 0; i < v1.size(); i++){
                     es[i] = e.evaluate(v2.elementAt(i).spaces);
                     if (flips2 > 1){
                        v2.set(i, v2.elementAt(i).flipBoard());
                        es[7+i] = e.evaluate(v2.elementAt(i).spaces);
                        v2.set(i, v2.elementAt(i).flipBoard());
                     }
                     es[14+i] = e.evaluate(v1.elementAt(i).spaces);
                     if (flips2 > 1){
                        v1.set(i, v1.elementAt(i).flipBoard());
                        es[21+i] = e.evaluate(v1.elementAt(i).spaces);
                        v1.set(i, v1.elementAt(i).flipBoard());
                     }
                  }
               }
               else{
                  for (int i = 0; i < v1.size(); i++){
                     es[14+i] = e.evaluate(v1.elementAt(i).spaces);
                     if (flips2 > 0){
                        v1.set(i, v1.elementAt(i).flipBoard());
                        es[21+i] = e.evaluate(v1.elementAt(i).spaces);
                        v1.set(i, v1.elementAt(i).flipBoard());
                     }
                  }
               }
               int maxes = maxIndex(es);
               for (int i = 0; i < board.spaces[0].length; i++){
                  if (maxes == i){
                     board = board.flipBoard();
                     flips2--;
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                     board.makeMove(i, 'R');
                     board.printBoard();
                     System.out.println("Computer has dropped in column " + i + ". Press Enter.");
                     scan.nextLine();
                     lastMove = "drop";
                  }
               }
               for (int i = 0; i < board.spaces[0].length; i++){
                  if (maxes == i+7){
                     board = board.flipBoard();
                     flips2--;
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                     board.makeMove(i, 'R');
                     board.printBoard();
                     System.out.println("Computer has dropped in column " + i + ". Press Enter.");
                     scan.nextLine();
                     lastMove = "drop";
                     board = board.flipBoard();
                     flips2--;
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                  }
               }
               for (int i = 0; i < board.spaces[0].length; i++){
                  if (maxes == i+14){
                     board.makeMove(i, 'R');
                     board.printBoard();
                     System.out.println("Computer has dropped in column " + i + ". Press Enter.");
                     scan.nextLine();
                     lastMove = "drop";
                  }
               }
               for (int i = 0; i < board.spaces[0].length; i++){
                  if (maxes == i+21){
                     board.makeMove(i, 'R');
                     board.printBoard();
                     System.out.println("Computer has dropped in column " + i + ". Press Enter.");
                     scan.nextLine();
                     lastMove = "drop";
                     board = board.flipBoard();
                     flips2--;
                     board.printBoard();
                     System.out.println("Computer has flipped the board. Press Enter.");
                     scan.nextLine();
                  }
               }
            }
            if (board.isWin('W')){
               System.out.println("The winner is player one.");
            }
            if (board.isWin('R')){
               System.out.println("The winner is player two.");
            }
         }
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
   	public static int maxIndex(int[] es){
      		int temp = 0;
      		int max = es[0];
      		for (int i = 0; i < es.length; i++){
         		if (es[i] > max){
            			temp = i;
         		}
      		}
      		return temp;
   	}
}
