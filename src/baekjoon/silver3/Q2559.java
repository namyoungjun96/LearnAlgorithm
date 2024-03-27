package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr, m));
    }

    public static int solution(int[] arr, int m) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(i>= m) {
                sum -= arr[i-m];
            }

            if(sum > answer && i>=m-1) {
                answer = sum;
            }
        }

        return answer;
    }
}
