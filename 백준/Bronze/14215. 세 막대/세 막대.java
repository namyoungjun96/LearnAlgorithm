import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer st;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a == b && a == c){
            System.out.println(a * 3);
        }
        else if(a >= b && a > c){
            if(a > b + c) {
                a = b + c - 1;
            }

            System.out.println(a + b + c);
        }
        else if(b > a && b > c){
            if(b >= a + c) {
                b = a + c - 1;
            }

            System.out.println(a + b + c);
        }
        else {
            if(c >= a + b) {
                c = a + b - 1;
            }

            System.out.println(a + b + c);
        }
    }
}