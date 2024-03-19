package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] six = new int[m];
        int[] one = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            six[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(six);
        Arrays.sort(one);

        if(n >= 6 && six[0] < one[0] * 6) {
            answer += six[0] * (n/6);
            if(n > 6)
                n %= 6;
            else
                n = 0;
        }
        else if(n < 6 && six[0] < one[0] * n) {
            answer += six[0];
            n = 0;
        }
        else {
            answer += one[0] * n;
            n = 0;
        }

        if(n > 0)
            answer += Math.min(six[0], one[0] * n);

        System.out.print(answer);
    }
}

/* 6줄 패키지,
 1개 그 이상의 줄 낱개
 끊어진 기타줄의 개수 N, 기타줄 브랜드 M
 기타줄 6개 패키지 가격, 낱개 가격
 적어도 n개

 20 - 6
 16 - 4 * 4
*/