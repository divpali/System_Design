import java.util.*;
//https://leetcode.com/problems/snakes-and-ladders/

public class Design_Snake_And_Ladder {

    int rollDiceSides = 6;

    public int snakesAndLadders(int[][] board) {

        /**
         *
         * we can do it by bsf
         *          1
         *   2 3 4 5 6 7   --> adding each dice number with the start point and
         *                     if we find any ladder or a number which is not -1
         *                     in the board then it means we found a ladder or
         *                     snake and the current position would be that number
         *                     and that would be counted as single move
         */

        int minSteps = 0;
        int rows = board.length;
        int start = 1, end = rows * rows;
        boolean[][] isVisited = new boolean[rows][rows];
        LinkedList<Integer> queue = new LinkedList<>();

        isVisited[rows - 1][0] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentPosition = queue.pop();
                if (currentPosition == end) return minSteps;
                //Rolling Dice upto 6 and adding those possible destinations to Queue.
                for (int dice = 1; dice <= 6; dice++) {
                    if (dice + currentPosition > end) break;

                    int[] nextPosition = findCoordinates(currentPosition + dice, rows);
                    int nextRow = nextPosition[0], nextColumn = nextPosition[1];
                    if (!isVisited[nextRow][nextColumn]) {
                        isVisited[nextRow][nextColumn] = true;
                        if (board[nextRow][nextColumn] != -1) queue.add(board[nextRow][nextColumn]);
                        else queue.add(currentPosition + dice);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private int[] findCoordinates(int currentPosition, int n) {
        int r = n - (currentPosition - 1) / n - 1;
        int c = (currentPosition - 1) % n;
        if (r % 2 == n % 2) {
            return new int[]{r, n - 1 - c};
        }
        else {
            return new int[]{r, c};
        }
    }

    public static void main(String[] args) {

        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        Design_Snake_And_Ladder d = new Design_Snake_And_Ladder();
        int moves = d.snakesAndLadders(board);
        System.out.println(moves);

    }
}
