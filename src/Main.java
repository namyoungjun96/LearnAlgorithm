import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(br.readLine());
        System.out.println(Integer.bitCount(x));

//        System.out.println(solution(x, 64));
    }

    public static int solution(int x, int bar) {
        int answer = (1 << bar) - 1;

        if(bar/2 > x)
            answer = solution(x, bar/2);

        return 0;
    }
}

/*
 64 -> X 막대는 더 작은 막대로 자름
 처음에는 64 합이 더 큰 경우
 1. 가지고있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
 2. 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 x보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
 막대 /2 > 남아있는 길이의 합 x == 나머지 막대도 버림
 3. 남아있는 모든 막대의 합 = X

 64가 X가 되기위해 필요한 막대!
*/
