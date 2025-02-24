import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s;
        StringTokenizer st;

        while(!(s = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a > b && a > c && a >= b + c) {
                System.out.println("Invalid");
                continue;
            }
            else if(c > a && c > b && c >= b + a) {
                System.out.println("Invalid");
                continue;
            }
            else if(b > a && b > c && b >= a + c) {
                System.out.println("Invalid");
                continue;
            }

            if(a == b && b == c) System.out.println("Equilateral");
            else if(a == b) System.out.println("Isosceles");
            else if(a == c) System.out.println("Isosceles");
            else if(b == c) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}
