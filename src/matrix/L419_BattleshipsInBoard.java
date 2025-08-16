package matrix;

public class L419_BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i - 1][j] == '.')
                            && (j == 0 || board[i][j - 1] == '.')) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
