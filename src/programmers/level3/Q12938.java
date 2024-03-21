package programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q12938 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 10)));
    }

    public static int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s) {
            return new int[]{-1};
        }

        for(int i=0; i<n; i++) {
            if(s%n > 0 && i >= answer.length - s%n) {
                answer[i] = s/n+1;
            }
            else
                answer[i] = s/n;
        }

        return answer;
    }

    public static int[] loop(int n, int s) {
        int[] answer = new int[n];
        int sum = 0;

        if(n > s) {
            return new int[]{-1};
        }

        while(sum < s) {
            for(int i=0; i<n; i++) {
                if(sum < s) {
                    answer[i] += 1;
                    sum++;
                }
                else
                    break;
            }
        }

        Arrays.sort(answer);
        return answer;
    }

    public static int[] prioritiQueue(int n, int s) {
        int[] answer = new int[n];
        int sum = 0;

        if(n > s) {
            return new int[]{-1};
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            queue.add(1);
            sum += 1;
        }
        System.out.println(queue);

        for(int i=sum; i<=s; i++) {
            int temp = queue.poll();
            queue.add(temp+1);
        }

        for(int i=0; i<n; i++)
            answer[i] = queue.poll();

        return answer;
    }
}
