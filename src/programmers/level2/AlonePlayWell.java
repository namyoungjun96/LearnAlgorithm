package programmers.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AlonePlayWell {
    public static void main(String[] args) {
        int[] cards = {1, 2};

        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            int index = cards[i] - 1;
            cards[i] = 0;

            if (index > 0) {
                answer += 1;
                map.put(answer, 1);

                while (cards[index] > 0) {
                    int temp = cards[index] - 1;

                    int value = map.getOrDefault(answer, 0);
                    map.put(answer, value + 1);

                    cards[index] = 0;
                    index = temp;
                }
            }
        }

        queue.addAll(map.values());

        if(!queue.isEmpty())
            answer *= queue.poll();
        else
            answer *= 0;
        return answer;
    }
}
