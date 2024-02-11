import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] distance = new long[testcase-1];
        for(int i=0; i<testcase-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        long[] cities = new long[testcase];
        for(int i=0; i<testcase; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

//        int n = 4;
//        int[] distance = {2, 3, 1};
//        int[] cities = {5, 2, 4, 1};

        System.out.println(solution(distance, cities));
    }

    public static long solution(long[] distance, long[] cities) {
        long answer = 0;
        long cost = cities[0];

        for (int i=0; i<distance.length; i++) {
            if(cities[i] < cost)
                cost = cities[i];

            answer += distance[i] * cost;
        }

        return answer;
    }
}