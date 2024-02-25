package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[m];
        List<Integer> board = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            board.add(i);
        }

        System.out.println(solution(board, numbers));
    }

    private static int solution(List<Integer> board, int[] numbers) {
        int res = 0;
        int index = 0;

        while(index < numbers.length && !board.isEmpty()) {
            int numIndex = board.indexOf(numbers[index]);

            if(numbers[index] == board.get(0)) {
                board.remove(0);
                index += 1;
            }
            else if(numIndex > board.size()/2) {
                board.add(0, board.remove(board.size() - 1));
                res += 1;
            }
            else {
                board.add(board.remove(0));
                res += 1;
            }
        }

        return res;
    }
}
