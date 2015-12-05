import java.util.Arrays;
import java.util.Vector;

/**
 * Programmer: Peter Salu
 * Created on: November 24, 2015
 * Description: Tests conniption functionality.
 */

public class Test {
	private static final char RED = 'R';
	private static final char WHITE = 'W';

	static void testMakeMove() {
		Board board = new Board();

		board.makeMove(0, RED);
		board.makeMove(1, RED);
		board.makeMove(0, WHITE);
		board.makeMove(5, RED);
		board.makeMove(1, RED);

		board.printBoard();
	}

	static void testChildrenOf() {
		Board board = new Board();
		AlphaBetaPruning alphaBetaPruning = new AlphaBetaPruning();

		Vector<Board> children = alphaBetaPruning.childrenOf(board, RED);
		System.out.println(children.toString());
	}
}
