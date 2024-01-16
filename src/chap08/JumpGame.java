package chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());

        for(int t=0; t<testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            int[][] cache = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    cache[i][j] = -1;
                }
            }

            System.out.println(memoization(0, 0, board, cache));
        }
    }

    public static int memoization(int y, int x, int[][] board, int[][] cache) {
        if(y >= board.length || x >= board.length) return 0;
        if(y == board.length-1 && x == board.length-1) return 1;
        if(cache[y][x] != -1) return cache[y][x];

        int jumpSize = board[y][x];

        return cache[y][x] = memoization(y + jumpSize, x, board, cache) | memoization(y, x+jumpSize, board, cache);
    }
}
