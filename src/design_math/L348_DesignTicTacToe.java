package design_math;

public class L348_DesignTicTacToe {
    class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antiDiagonal;
        private int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int toAdd = player == 1? 1: - 1;
            rows[row] += toAdd;
            cols[col] += toAdd;
            if (row == col) diagonal += toAdd;
            if (row + col == n - 1) antiDiagonal += toAdd;

            if (Math.abs(rows[row]) == n
                    || Math.abs(cols[col]) == n
                    || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
                return player;
            }
            return 0;
        }
    }
}
