import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        st = new StringTokenizer(br.readLine(), " ");

        String s;
        int n;
        int sum;
        StringBuilder sb;

        while(!(s = br.readLine()).equals("-1")) {

            sum = 0;
            sb = new StringBuilder();
            n = Integer.parseInt(s);
            sb.append(n).append(" = ");

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sb.append(i).append(" + ");
                    sum += i;
                }
            }

            if(sum == n) {
                sb.delete(sb.length()-3, sb.length());

                System.out.println(sb);
            }
            else System.out.println(n + " is NOT perfect.");
        }
    }
}