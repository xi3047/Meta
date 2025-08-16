package matrix;

public class L73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // Boolean to track if the first column needs to be zeroed
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
        // First pass: mark zeros using first row and first column
        for (int i = 0; i < R; i++) {
            // Check if the first column should be zeroed
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            // Check the rest of the row
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    // Mark corresponding row and column in first cell
                    matrix[0][j] = 0; // Mark column j for zeroing
                    matrix[i][0] = 0; // Mark row i for zeroing
                }
            }
        }
        // Second pass: use the marks to set zeroes (excluding first row/column)
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                // If either row or column is marked, set cell to 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Handle the first row separately (based on marker at matrix[0][0])
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        // Handle the first column separately (based on isCol flag)
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
