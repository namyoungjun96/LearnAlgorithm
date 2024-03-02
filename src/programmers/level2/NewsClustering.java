package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> jakard = new HashMap<>();
        Map<String, Integer> jakard2 = new HashMap<>();
        int size = 0;

        for(int i=0; i<str1.length()-1; i++) {
            String word = str1.substring(i, i+2).toLowerCase();
            if(word.matches("^[a-zA-Z]*$")) {
                int temp = jakard.getOrDefault(word, 0);
                jakard.put(word, temp + 1);
//                jakard.merge(word, 1, (key, value) -> value + 1);
            }
        }

        for(int i=0; i<str2.length()-1; i++) {
            String word = str2.substring(i, i+2).toLowerCase();
            if(word.matches("^[a-zA-Z]*$")) {
                int temp = jakard2.getOrDefault(word, 0);
                jakard2.put(word, temp + 1);
//                jakard2.merge(word, 1, (key, value) -> value + 1);
            }
        }

        for(Integer value: jakard2.values())
            size += value;

        for(String key: jakard.keySet()) {
            Integer value1 = jakard.get(key);

            if(jakard2.containsKey(key)) {
                Integer value2 = jakard2.get(key);
                answer += value1 <= value2 ? value1 : value2;

                size +=  value1 >= value2 ? value1 - value2 : 0;
            }
            else {
                size += value1;
            }
        }

        System.out.println(answer + " / " + size);
        System.out.println(jakard);
        System.out.println(jakard2);

        return jakard.size() == 0 ? 65536 : answer*65536/size;
    }
}
