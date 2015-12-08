import java.util.ArrayList;
import java.util.function.Function;

/**
 * Programmer: Peter Salu
 * Created on: November 24, 2015
 * Description:
 */

public class AlphaBetaPruning {
	private static final int MAX_DEPTH = 4;

	public int alphaBeta(Board state, char piece, Function<Board, Integer> evaluationFunction) {
		final int ALPHA = Integer.MIN_VALUE;
		final int BETA = Integer.MAX_VALUE;

		return maxValue(evaluationFunction, state, MAX_DEPTH, ALPHA, BETA, piece);
	}

	private int maxValue(
			Function<Board, Integer> evaluationFunction,
			Board state,
			int depth,
			int alpha,
			int beta,
			char piece
	) {
		final char otherPlayer = piece == state.WHITE ? state.RED : state.WHITE ;
		final boolean winForPlayer = state.isWin(piece);
		final boolean winForOtherPlayer = state.isWin(otherPlayer);
		final boolean terminalState = winForPlayer || winForOtherPlayer;

		if (terminalState || depth == 0) {
			return evaluationFunction.apply(state);
		}

		int bestValue = Integer.MIN_VALUE;

		for (int column : nonFullColumns(state)) {
			state.makeMove(column, piece);
			int minValue = minValue(evaluationFunction, state, depth - 1, alpha, beta, piece);
			state.undoMove(column);
			bestValue = Math.max(bestValue, minValue);

			if (bestValue >= beta) {
				return bestValue;
			}

			alpha = Math.max(alpha, bestValue);
		}

		return bestValue;
	}

	private int minValue(
			Function<Board, Integer> evaluationFunction,
			Board state,
			int depth,
			int alpha,
			int beta,
			char piece
	) {
		final char otherPlayer = piece == state.WHITE ? state.RED : state.WHITE ;
		final boolean winForPlayer = state.isWin(piece);
		final boolean winForOtherPlayer = state.isWin(otherPlayer);
		final boolean terminalState = winForPlayer || winForOtherPlayer;

		if (terminalState || depth == 0) {
			return evaluationFunction.apply(state);
		}

		int bestValue = Integer.MAX_VALUE;

		for (int column : nonFullColumns(state)) {
			state.makeMove(column, piece);
			int maxValue = maxValue(evaluationFunction, state, depth - 1, alpha, beta, piece);
			state.undoMove(column);
			bestValue = Math.min(bestValue, maxValue);

			if (bestValue <= alpha) {
				return bestValue;
			}

			alpha = Math.min(alpha, bestValue);
		}

		return bestValue;
	}

	/**
	 * Returns a list of valid columns pieces can be placed in.
	 *
	 * @param board The board to check valid columns for.
	 * @return A list of non full columns.
     */
	ArrayList<Integer> nonFullColumns(Board board) {
		ArrayList<Integer> children = new ArrayList<>();

		for (int column = 0; column < board.spaces.length; column++) {
			if (board.isValid(column)) {
				children.add(column);
			}
		}

		return children;
	}
}
