import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer st;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] card = new int[N];

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < card.length; i++) {
            for (int j = i+1; j < card.length; j++) {
                for (int k = j+1; k < card.length; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if(answer < sum && M >= sum)
                        answer = sum;
                }
            }
        }

        System.out.println(answer);
    }
}