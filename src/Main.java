import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] cache;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 10;
        cache = new int[n+1];
        cache[2] = 1;
        cache[3] = 1;
        Arrays.fill(cache, Integer.MAX_VALUE);

        System.out.println(solution(n));
    }

    public static int solution(int x) {
        if(x == 1) return 0;
        if(cache[x] != Integer.MAX_VALUE) return cache[x];

        if(x%3 == 0) cache[x] = Math.min(solution(x/3) + 1, cache[x]);
        if(x%2 == 0) cache[x] = Math.min(solution(x/2) + 1, cache[x]);

        cache[x] = Math.min(solution(x-1) + 1, cache[x]);

        return cache[x];
    }
}

// 12 /3 /2 4 6