import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer st;

        String s = br.readLine();
        char[] chars = s.toCharArray();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        Arrays.sort(arr);

        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
