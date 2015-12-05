import java.util.Vector;

/**
 * Programmer: Peter Salu
 * Created on: November 24, 2015
 * Description:
 */

public class AlphaBetaPruning {
	Vector<Board> childrenOf(Board initial, char player) {
		Board current = initial;
		Vector<Board> children = new Vector<>();

		for (int column = 0; column < current.spaces.length; column++) {
			current.makeMove(column, player);
			children.add(current);
			current.undoMove(column);
		}

		return children;
	}
}
