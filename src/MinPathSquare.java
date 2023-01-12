import java.util.Arrays;

public class MinPathSquare {
    public static int minPath(int[][] grid, int x, int y) {
        int[][] resultGrid = new int[y + 1][x + 1];
        resultGrid[0][0] = grid[0][0];

        for(int i = 1; i <= x; i++) {
            resultGrid[0][i] = grid[0][i] + resultGrid[0][i - 1];
        }
        for(int i = 1; i <= y; i++) {
            resultGrid[i][0] = grid[i][0] + resultGrid[i - 1][0];
        }

        for(int i = 1; i <= y; i++) {
            for(int j = 1; j <= x; j++) {
                resultGrid[i][j] = grid[i][j] + Math.min(resultGrid[i - 1][j], resultGrid[i][j - 1]);
            }
        }

        return resultGrid[y][x];
    }

    public static void main(String[] args) {
        int[][] smallSquare = new int[][]
                {
                        {1, 2, 3, 6, 2, 8, 1},
                        {4, 8, 2, 4, 3, 1, 9},
                        {1, 5, 3, 7, 9, 3, 1},
                        {4, 9, 2, 1, 6, 9, 5},
                        {7, 6, 8, 4, 7, 2, 6},
                        {2, 1, 6, 2, 4, 8, 7},
                        {8, 4, 3, 9, 2, 5, 8}
                };
//        System.out.println(minPath(smallSquare, 2, 2));
//        System.out.println(minPath(smallSquare, 4, 5));
        System.out.println(minPath(smallSquare, 0, 1));
    }
}
