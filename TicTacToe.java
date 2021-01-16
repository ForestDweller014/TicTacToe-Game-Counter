public class TicTacToe {
	public static int[][] board = new int[3][3];

	public static void main(String[] args) {
		System.out.println(countGames(2));
	}

	public static int countGames(int startingPiece) {
		int result = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					board[i][j] = startingPiece;
					if (winCheck(i, j)) {
						result += 1;
					} else {
						result += Math.max(1, countGames(startingPiece % 2 + 1));
					}
					board[i][j] = 0;
				}
			}
		}
		return result;
	}

	public static boolean winCheck(int i, int j) {
		if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
			return true;
		}

		if (board[0][j] != 0 && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
			return true;
		}

		if (board[1][1] != 0 && ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
			return true;
		}

		return false;
	}
}