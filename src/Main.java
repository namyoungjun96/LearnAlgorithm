import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int testcase = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < testcase; i++) {
//             st = new StringTokenizer(br.readLine(), " ");
//
//             int n = Integer.parseInt(st.nextToken());
//             int m = Integer.parseInt(st.nextToken());
//
//            sb.append(solution(n, m, new int[n+1][m+1])).append("\n");
//        }
//
//        System.out.print(sb);

//        int n = Integer.parseInt(st.nextToken());
//
//        long[] line = new long[testcase];
//
//        long high = 0;
//        for(int t=0; t<testcase; t++) {
//            int num = Integer.parseInt(br.readLine());
//            line[t] = num;
//
//            if(high < num)
//                high = num;
//        }

        int n = 2;
        int m = 3;

        System.out.println(solution(n, m, new int[30][30]));
    }

    public static int solution(int n, int m, int[][] cache) {
        if(cache[n][m] != 0) return cache[n][m];
        if(n == 1) return cache[n][m] = m;

        return solution(n-1, m-1, cache) + solution(n-1, m, cache);
    }
}