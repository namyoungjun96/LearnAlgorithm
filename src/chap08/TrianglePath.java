package chap08;

import java.util.StringTokenizer;

public class TrianglePath {
    static int n;
    static int[][] triangle = new int[100][100];
    static int[][] cache = new int[100][100];

    public static void main(String[] args) {
        n = 5;
        triangle = new int[][]{{6}, {1, 2}, {3, 7, 4}, {9, 4, 1, 7}, {2, 7, 5, 9, 4}};

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                cache[i][j] = -1;
//            }
//        }

        System.out.println(path2(0, 0));
    }

//    public static int path1(int y, int x, int sum) {
//        if(y == n-1) return sum + triangle[y][x];
//        if(cache[y][x][sum] != -1) return cache[y][x][sum];
//
//        sum += triangle[y][x];
//
//        return cache[y][x][sum] = Math.max(path1(y+1, x+1, sum), path1(y+1, x, sum));
//    }

    public static int path2(int y, int x) {
        if(y == n-1) return triangle[y][x];
        if(cache[y][x] != 0) return cache[y][x];

        return cache[y][x] = Math.max(path2(y+1, x+1), path2(y+1, x)) + triangle[y][x];
    }
}
