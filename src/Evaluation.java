//Austin Dixon
//Evaluation Function


public class Evaluation {
	private static int[][] evaluationTable = {{3, 4, 5, 7, 5, 4, 3}, 
												{4, 6, 8, 10, 8, 6, 4},
												{5, 8, 11, 13, 11, 8, 5}, 
												{5, 8, 11, 13, 11, 8, 5},
												{4, 6, 8, 10, 8, 6, 4},
												{3, 4, 5, 7, 5, 4, 3}};

	public int evaluate() {

		int utility = 128;
		int sum = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <columns; j++) {
				if (board[i][j] == 'R')
					sum += evaluationTable[i][j];

				else if (board[i][j] == 'W')
					sum -= evaluationTable[i][j];

				return utility + sum;
			}
		}
	}
}