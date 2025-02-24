import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st;
        int[][] coord = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            coord[i][0] = a;
            coord[i][1] = b;
        }

        int y, x;

        if(coord[0][0] == coord[1][0]) y = coord[2][0];
        else if(coord[1][0] == coord[2][0]) y = coord[0][0];
        else y = coord[1][0];

        if(coord[0][1] == coord[1][1]) x = coord[2][1];
        else if(coord[1][1] == coord[2][1]) x = coord[0][1];
        else x = coord[1][1];

        System.out.println(y + " " + x);
    }
}