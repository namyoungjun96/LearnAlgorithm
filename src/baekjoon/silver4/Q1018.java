package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        System.out.println(solution(n, m, board));
    }

    private static int solution(int n, int m, char[][] board) {
        int res = 32;

        for (int height = 0; height < n - 7; height++) {
            for (int width = 0; width < m - 7; width++) {
                int count = 0;
                int countCompare = 0;
                char[][] copyBoard = board.clone();
                char match = board[height][width];
                char matchCompare;

                if(match == 'B')
                    matchCompare = 'W';
                else
                    matchCompare = 'B';

                for (int heightSearch = height; heightSearch < height + 8; heightSearch++) {
                    for(int widthSearch = width; widthSearch < width + 8; widthSearch++) {
                        if(copyBoard[heightSearch][widthSearch] != match) {
                            count += 1;
                        }

                        if(copyBoard[heightSearch][widthSearch] != matchCompare) {
                            countCompare += 1;
                        }

                        if(matchCompare == 'B')
                            matchCompare = 'W';
                        else
                            matchCompare = 'B';

                        if(match == 'B')
                            match = 'W';
                        else
                            match = 'B';
                    }
                    if(matchCompare == 'B')
                        matchCompare = 'W';
                    else
                        matchCompare = 'B';

                    if(match == 'B')
                        match = 'W';
                    else
                        match = 'B';
                }

                if(count < res)
                    res = count;

                if(countCompare < res)
                    res = countCompare;
            }
        }

        return res;
    }
}