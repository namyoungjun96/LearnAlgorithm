package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(br.readLine());
        int index = 0;
        int count = 1;
        int sum = 1;

        while (sum < n) {
            index += 6;

            sum += index;
            count++;
        }

        System.out.println(count);
    }
}
