package chap08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    static int n;
    static int[] S;
    static int[] cache;

    public static void main(String[] args) {
//        System.out.println(lis1(Arrays.asList(3, 2, 1, 7, 5, 4, 2, 6)));

        n = 8;
        S = new int[]{3, 2, 1, 7, 5, 4, 2, 6};
        cache = new int[8];
        System.out.println(lis2(0));

        int maxLen = 0;
        for(int begin = -1; begin < n-1; begin ++)
            maxLen = Math.max(maxLen, lis3(begin));

        System.out.println(maxLen);
    }

    static int lis3(int start) {
        if(cache[start+1] != -1) return cache[start+1];

        cache[start+1] = 1;

        for(int next = start+1; next < n; next ++)
            if(start == -1 || S[start] < S[next])
                cache[start+1] = Math.max(cache[start+1], lis3(next) + 1);

        return cache[start+1];
    }

    static int lis2(int start) {
        if(cache[start] != 0) return cache[start];

        cache[start] = 1;

        for(int next = start+1; next < n; next++)
            if(S[start] < S[next])
                cache[start] = Math.max(cache[start], lis2(next) + 1);

        return cache[start];
    }

    public static int lis1(List<Integer> a) {
        if(a.isEmpty()) return 1;

        int ret = 0;

        for (int i = 0; i < a.size(); i++) {
            List<Integer> b = new ArrayList<>();

            for (int j = i+1; j < a.size(); j++) {
                int first = a.get(i);
                int second = a.get(j);

                if(first < second)
                    b.add(second);
                ret = Math.max(ret, 1+lis1(b));
            }
        }

        return ret;
    }
}
