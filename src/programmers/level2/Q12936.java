package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q12936 {
    public static void main(String[] args) {
        int n=4;
        int fact = (int) factorial(n);

        for(int i=1; i<=fact; i++) {
            System.out.println(Arrays.toString(solution(n, i)));
        }


//        System.out.println(Arrays.toString(solution(3, 4)));
        // 2432902008176640000
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int arrayIndex = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (n > 1) {
            long numCase = factorial(n) / n--;
            long index = (k / numCase) + (k % numCase > 0 ? 1 : 0);
            k -= numCase * (index - 1);

            if (index > 0) {
                answer[arrayIndex++] = list.get((int) (index - 1));
                list.remove((int) index - 1);
            } else
                break;
        }

        while (!list.isEmpty()) {
            answer[arrayIndex++] = list.get(0);
            list.remove(0);
        }

        return answer;
    }

    public static long factorial(long n) {
        if (n == 1) return 1;

        return n * factorial(n - 1);
    }
}

// [1, 2]
// [2, 1]


//  [2, 3, 4, 5]
//  [2, 3, 5, 4]
//  [2, 4, 3, 5]
//  [2, 4, 5, 3]
//  [2, 5, 3, 4]
//  [2, 5, 4, 3]
//  [3, 2, 4, 5]
//  [3, 2, 5, 4]
//  [3, 4, 2, 5]
//  [3, 4, 5, 2]
//  [3, 5, 2, 4]
//  [3, 5, 4, 2]
//  [4, 2, 3, 5]
//  [4, 2, 5, 3]
//  [4, 3, 2, 5]
//  [4, 3, 5, 2]
//  [4, 5, 2, 3]
//  [4, 5, 3, 2]
//  [5, 2, 3, 4]
//  [5, 2, 4, 3]
//  [5, 3, 2, 4]
//  [5, 3, 4, 2]
//  [5, 4, 2, 3]
//  [5, 4, 3, 2]