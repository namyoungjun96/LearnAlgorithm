import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int testcase = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] treeList = new int[testcase];
        int high = 0;
        for(int t=0; t<testcase; t++) {
            int num = Integer.parseInt(st.nextToken());
            treeList[t] = num;

            if(high < num)
                high = num;
        }

//        int n = 4;
//        int m = 7;
//        int[] treeList = {20, 15, 10, 17};

//        int n = 5;
//        int m = 20;
//        int[] treeList = {4, 42, 40, 26, 46};

        System.out.println(solution(m, treeList, high));
    }

    public static long solution(int m, int[] treeList, int high) {
        int low = 0;

        while (low < high) {
            int mid = (high + low) / 2;
            long sum = 0;

            for (int i : treeList) {
                if(i - mid > 0)
                    sum += i - mid;
            }

            if (sum < m) {
                high = mid;
            } else {
                low = mid + 1;
            }

            System.out.println(mid);
        }

        System.out.println(high + ", " + low);

        return low - 1;
    }
}