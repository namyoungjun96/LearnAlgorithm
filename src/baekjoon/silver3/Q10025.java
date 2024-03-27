package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            maxIndex = Math.max(index, maxIndex);
            arr[index] = ice;
        }

        System.out.println(solution(arr, k, maxIndex));
    }

    public static int solution(int[] arr, int k, int maxIndex) {
        int answer = 0;
        int window = 2 *k + 1;
        int sum = 0;

        for (int i = 0; i < maxIndex+1; i++) {
            sum += arr[i];

            if(i == window-1) {
                answer = sum;
            }

            if(i >= window) {
                sum -= arr[i-window];
            }

            if (sum > answer)
                answer = sum;
        }

        return answer;
    }
}
