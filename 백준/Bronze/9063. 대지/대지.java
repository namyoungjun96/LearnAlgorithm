import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int y1 = Integer.MIN_VALUE;
        // 맨 위
        int y2 = Integer.MAX_VALUE;
        // 맨 아래
        int x1 = Integer.MAX_VALUE;
        // 맨 왼쪽
        int x2 = Integer.MIN_VALUE;
        // 맨 오른쪽

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(y > y1) {
                y1 = y;
            }
            if(y < y2) {
                y2 = y;
            }
            if(x < x1) {
                x1 = x;
            }
            if(x > x2) {
                x2 = x;
            }
        }

        if(y1 == y2 || x1 == x2) System.out.println(0);
        else System.out.println(Math.abs(((y1 - y2) * (x1 - x2))));
    }
}