import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> answer = solution(n, l);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> solution(int n, int l) {
        List<Integer> sequence = new LinkedList<>();
        long sum = n * 2L;
        int count = 0;
        int listCount = 0;

        for (int i = l; i <= 100; i++) {
            for (int j = (int) (sum / l + 1); j > n / 100000; j--) {
                long temp = (long) i * (j - i + 1 + j);

                if (sum == temp) {
                    count = j;
                    listCount = i;
                    break;
                } else if (sum > temp) {
                    break;
                }
            }

            if (count != 0)
                break;
        }

        if (count - listCount < -1 || count == 0)
            return Collections.singletonList(-1);

        for (int i = count; i > count - listCount; i--) {
            sequence.add(0, i);
        }

        return sequence;
    }
}