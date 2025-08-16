package bdfs;

import java.util.LinkedList;
import java.util.Queue;

public class L200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null ||grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c <cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    grid[r][c] = '0';

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] direction :directions) {
                            int x = current[0] + direction[0];
                            int y = current[1] + direction[1];
                            if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == '1') {
                                queue.offer(new int[]{x, y});
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
