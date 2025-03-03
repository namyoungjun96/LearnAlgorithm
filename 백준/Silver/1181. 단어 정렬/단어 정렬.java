import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(br.readLine());
        Set<String> distinct = new HashSet<>();

        for (int i = 0; i < n; i++) {
            distinct.add(br.readLine());
        }

        String[] arr = distinct.toArray(new String[0]);
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
