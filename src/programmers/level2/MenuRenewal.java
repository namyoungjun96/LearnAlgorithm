package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        char x = 'x';
        char y = 'w';

        System.out.println(Arrays.toString(solution(orders, course)));
    }

    static Map<String, Integer> map = new HashMap<>();
    static int[] cache;
    static int cacheIndex = 0;

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        cache = new int[course.length];

        for (int i = 0; i < orders.length; i++) {
            char[] sortOrder = orders[i].toCharArray();
            Arrays.sort(sortOrder);

            orders[i] = String.valueOf(sortOrder);

            for (int j = 0; j < course.length; j++) {
                cacheIndex = j;
                for (int h = 0; h < orders[i].length(); h++) {
                    combination(orders[i], "", course[j] - 1, h);
                }
            }
        }

        for (int i = 0; i < course.length; i++) {
            cacheIndex = i;

            for (String word : map.keySet()) {
                if (word.length() == course[i]) {
                    if (map.get(word) >= cache[cacheIndex] && cache[cacheIndex] >= 2)
                        answerList.add(word);
                }
            }
        }
        Collections.sort(answerList);

        answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);
        return answer;
    }

    private static void combination(String msg, String temp, int cnt, int idx) {
        if (cnt == 0) {
            int count = map.getOrDefault(temp + msg.charAt(idx), 0);
            map.put(temp + msg.charAt(idx), count + 1);

            if (cache[cacheIndex] < count + 1)
                cache[cacheIndex] = count + 1;
            return;
        }

        String word = String.valueOf(msg.charAt(idx));

        for (int i = idx + 1; i < msg.length() - cnt + 1; i++) {
            combination(msg, temp + word, cnt - 1, i);
        }
    }
}
