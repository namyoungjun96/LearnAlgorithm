import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(br.readLine());
        int index = 0;
        int count = 0;
        boolean isFlag = true;

        while (index < n) {
            count ++;
            index += count;
            isFlag = !isFlag;
        }

        int numerator = 1, denominator = count, end = index - count + 1;

        if(!isFlag) {
            numerator = count;
            denominator = 1;

            for (int i = 0; i < n - end; i++) {
                numerator --;
                denominator ++;
            }
        } else {
            for (int i = 0; i < n - end; i++) {
                numerator ++;
                denominator --;
            }
        }

        System.out.println(numerator + "/" + denominator);

//        System.out.println(count);
//        System.out.println(index);
//        System.out.println(isFlag ? "위" : "아래");
    }
}