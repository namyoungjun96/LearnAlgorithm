import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer st;

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 1; i < N; i++) {
            answer = i;
            int num = i;

            while(num > 0) {
                answer += num % 10;
                num /= 10;
            }

            if(answer == N) {
                answer = i;
                break;
            }

            if(i == N-1) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
