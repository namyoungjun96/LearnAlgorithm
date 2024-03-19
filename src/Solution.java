import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        long k = 5;
        System.out.println(Arrays.toString(solution(4, k)));
        // 2432902008176640000
    }

    static Map<Long, int[]> map;

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int[] output = new int[n-1];
        int[] temp = new int[n-1];
        long count = getPermutationCount(n, k)/n;
        int index = (int) (k/count + (k % count > 0 ? 1 : 0));
        boolean[] visited = new boolean[n-1];
        int arrIndex = 0;
        for (int i = 1; i <= n; i++) {
            if(i == index)
                continue;
            temp[arrIndex++] = i;
        }

        map = new HashMap<>();

        perm(temp, output, visited, 0, n-1, n-1, k%count);
        answer[0] = index;
        index = 1;
        for(int i: map.get(k%count)) {
            answer[index++] = i;
        }
        return answer;
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, long count) {
        if (depth == r) {
            System.out.println(Arrays.toString(output) + " " + r);
            map.put((long) (map.size() + 1), output.clone());
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r, count);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }

//            if(map.size() == count)
//                break;
        }
    }

    public static long getPermutationCount(int n, long r) {
        return factorial(n) / factorial((int) (n-r));
    }

    public static long factorial(int i) {
        if(i<=1) return 1;
        else return i * factorial(i-1);
    }
}

// 2 1
// 1 2
// 2 1
// 2

// 3 5
// 5 - 2(2!)
// 1 2 3
// 1 3 2
// 2 1 3
// 2 3 1
// 3 1 2
// 3 2 1
// nPr
// 3! 2! 1!
// 5 - 3!/3(2!) -> 1
// 4 -> 4/3!/3 -> 2 Math.ceil() 1 3 3 1
// nPr -> 2P1 -> 2!
// 3 - 2(2!) -> 2 ?