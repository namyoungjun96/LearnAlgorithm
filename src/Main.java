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
//        int[] answer = new int[testcase];
//        for(int t=0; t<testcase; t++) {
//            int n = Integer.parseInt(br.readLine());
//            int[] cache = new int[11];
//            cache[1] = 1;
//            cache[2] = 2;
//            if(n < 3)
//                answer[t] = cache[n];
//            else
//                answer[t] = solution(n, cache);
//        }
//
//        for(int i : answer)
//            System.out.println(i);
        int n = 7;
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;

        System.out.println(solution(n, cache));
    }

    public static int solution(int x, int[] cache) {
        if(x == 0) return 1;
        if(cache[x] != 0) return cache[x];

        cache[x] = solution(x-1, cache) + solution(x-2, cache) + solution(x-3, cache);

        return cache[x];
    }
}
// n = solution[x-1] + solution[x-2] + 1;
// 1 2 4 7 13?
// - 1
// - 2
// 1 1
// 2
// - 3
// 1 1 1
// 1 2
// 2 1
// 3
// - 4
// 1+1+1+1
// 1+1+2
// 1+2+1
// 2+1+1
// 2+2
// 1+3
// 3+1
/* 5
* 1 1 1 1 1
* 1 1 1 2
* 1 1 2 1
* 1 2 1 1
* 2 1 1 1
* 1 2 2
* 2 1 2
* 2 2 1
* 1 3 1
* 3 1 1
* 1 1 3
* 2 3
* 3 2
*/