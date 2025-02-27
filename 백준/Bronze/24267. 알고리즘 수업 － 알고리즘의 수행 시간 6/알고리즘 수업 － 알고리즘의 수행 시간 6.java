import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(br.readLine());
        long answer = 0;
        long num = 0;
        long count = 0;

        for (int i = 2; i < n; i++) {
            count ++;
            num += count;
            answer += num;
        }

        System.out.println(answer);
        System.out.println(3);
    }
}