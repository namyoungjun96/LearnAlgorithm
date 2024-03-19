package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q12936 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
        // 2432902008176640000
    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        int arrayIndex = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        while(n > 1) {
            int numCase = factorial(n)/n--;
            int index = k < numCase ? (int) ((k/numCase) + (k%numCase > 0 ? 1 : 0)) : (int) ((int) (k / 2) + (k % 2));
            System.out.println(index);

//            if(numCase > k)
//                answer[i] = (int) (k / index) + (k % index > 0 ? 1 : 0);
//            else
//                answer[i] = (int) (k / index) + (k % index > 0 ? 1 : 0);

            answer[arrayIndex++] = list.get(index-1);
            list.remove(index-1);
//
//            for(int j = (int) (index-1); j<visited.length; j++) {
//                if(!visited[j]) {
//                    answer[arrayIndex++] = j + 1;
//                    visited[j] = true;
//                    break;
//                }
//            }
        }

        return answer;
    }

    public static int factorial(int n) {
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