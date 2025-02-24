import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        br.readLine();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, Math.abs(y-h));
        answer = Math.min(answer, Math.abs(w-x));
        answer = Math.min(answer, y);
        answer = Math.min(answer, x);

        System.out.println(answer);
        }
}
