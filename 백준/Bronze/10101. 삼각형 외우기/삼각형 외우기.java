import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer st;
        int[] x = new int[3];
        int count = 0;
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        if(x[0] == x[1]) count += 2;
        if(x[1] == x[2]) count += 2;
        if(x[2] == x[0]) count += 2;
        sum += x[0];
        sum += x[1];
        sum += x[2];

        if(sum != 180) System.out.println("Error");
        else if(count == 2) System.out.println("Isosceles");
        else if(count == 6) System.out.println("Equilateral");
        else System.out.println("Scalene");
    }
}