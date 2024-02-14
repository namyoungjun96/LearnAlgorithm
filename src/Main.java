import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;

        int testcase = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] line = new long[testcase];

        long high = 0;
        for(int t=0; t<testcase; t++) {
            int num = Integer.parseInt(br.readLine());
            line[t] = num;

            if(high < num)
                high = num;
        }

//        int k = 4;
//        int n = 11;
//        int high = 0;
//
//        int[] line = {802, 743, 457, 539};
//        for(int i: line)
//            if(high < i)
//                high = i;

        high ++;
        System.out.println(solution(n, line, high));
    }

    public static long solution(int n, long[] line, long high) {
        long low = 0;
        long mid;

        while(low < high) {
            long sum = 0;
            mid = (low + high) / 2;

            for(long i: line)
                sum += i/mid;

            if(sum < n)
                high = mid;
            else
                low = mid + 1;
        }

        return low - 1;
    }
}