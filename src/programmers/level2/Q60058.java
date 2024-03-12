package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q60058 {
    public static void main(String[] args) {
//        System.out.println(solution("(()())()"));
//        System.out.println(solution(")("));
//        System.out.println(solution("()))((()"));
        System.out.println(solution(")()(()"));
        // ((()))
    }

    public static String solution(String p) {
        String answer = "";

        answer = makeBalanceWord(p);
        return answer;
    }

    public static String makeBalanceWord(String p) {
        int leftCount = 0;
        int rightCount = 0;

        if (p.isEmpty())
            return p;

        Deque<Character> reader = isCorrect(p);

        if (reader.isEmpty())
            return p;

        for (char i : p.toCharArray()) {
            if (i == '(')
                leftCount += 1;
            else
                rightCount += 1;

            if (leftCount == rightCount)
                break;
        }

        String u = p.substring(0, leftCount + rightCount);
        String v = p.substring(leftCount + rightCount);

        reader = isCorrect(u);

        if (reader.isEmpty())
            return u + makeBalanceWord(v);

        StringBuilder temp = new StringBuilder("(");
        temp.append(makeBalanceWord(v));
        temp.append(')');

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                temp.append(')');
            else
                temp.append('(');
        }

        u = temp.toString();
        return u;
    }

    public static Deque<Character> isCorrect(String p) {
        Deque<Character> reader = new ArrayDeque<>();

        for (char i : p.toCharArray()) {
            if (i == '(')
                reader.add(i);
            else if (reader.isEmpty() && i == ')') {
                reader.add(i);
                return reader;
            } else
                reader.pollLast();
        }

        return reader;
    }
}

// ()의 개수가 같다 > 균형잡힌, 짝까지 맞다 > 올바른 괄호 문자열 - 올바른 균형잡힌 문자열 만들기
/*
    균형잡힌 문자열 -> 올바른 괄호 문자열로 변환
    1. 빈 문자열이면 빈 문자열 반환
    2. 문자열 w를 균형잡힌 괄호 문자열 u, v로 분리 -> u는 균형잡힌 괄호 문자열만 가능
    3. u가 올바른 괄호문자열 > v에 대해 1부터 다시 -> 수행한 결과를 u에 붙여 다시 반환 > u+v
    4. u가 올바른 괄호가 아니면 > 빈 문자열 = (
        v + 1단계부터 재귀적으로 수행한 결과 문자열
        + )
        u의 첫 번째 와 마지막 문자 제거, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 +
        문자열 반환
 */