import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }

    static int count = 0;
    static int[] answer;

    public static int[] solution(int n, long k) {
        int[] temp = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            temp[i-1] = i;
        }

        permutation(temp, 0, n, n);
        return answer;
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(arr) + ", " + r);
            return;
        }

        int count = 0;

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, long k) {
        if (depth == r) {
            count ++;
            if(count == k) {
                answer = output;
            }
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r, k);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }
}
