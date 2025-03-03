import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] coords = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coords, ((o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];

            return o1[1] - o2[1];
        }));

        for (int[] coord : coords) {
            System.out.println(coord[0] + " " + coord[1]);
        }
    }
}