import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if(!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }

            map.get(age).add(name);
        }

        int[] ages = map.keySet().stream().mapToInt(x -> x).toArray();
        Arrays.sort(ages);

        for (int age: ages) {
            String[] list = map.get(age).toArray(String[]::new);

            for (String name: list) {
                System.out.println(age + " " + name);
            }
        }
    }
}
