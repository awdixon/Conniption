//Austin Dixon
//Evaluation Function

import java.util.Random;

public class Evaluation {
	private static int[][] evaluationTable = {{3, 4, 5, 7, 5, 4, 3}, 
												{4, 6, 8, 10, 8, 6, 4},
												{5, 8, 11, 13, 11, 8, 5}, 
												{5, 8, 11, 13, 11, 8, 5},
												{4, 6, 8, 10, 8, 6, 4},
												{3, 4, 5, 7, 5, 4, 3}};

	Board board = new Board();
	char[][] spaces = board.getBoard();
	String flip;

	// public int evalTypeF(int num){
	// 	if (num == 1)
	// 		this.randFlip();
	// 	else if (num == 2){
	// 		int i = 0;
	// 	}
	// 	return 0;
	// }

	// public int evalTypeC(int num) {
	// 	if (num == 1)
	// 		this.randColumn();
	// 	else if (num == 2){
	// 		int i = 0;
	// 	}
	// 	return 0;
	//}

	public int randFlip() {

		Random rand = new Random();
		int num = rand.nextInt(500) % 2;

		return num;
	}

	public int randColumn() {

		Random rand = new Random();
		int num = rand.nextInt(1000) % 7;
		return num;
	}


	// public int evaluate() {

	//     int utility = 128;
	//     int sum = 0;

	//     for (int i = 0; i < rows; i++)
	//         for (int j = 0; j <columns; j++)
	//             if (board[i][j] == 'R')
	//                 sum += evaluationTable[i][j];

	//             else if (board[i][j] == 'W')
	//                 sum -= evaluationTable[i][j];

	//     return utility + sum;
 //    }
}