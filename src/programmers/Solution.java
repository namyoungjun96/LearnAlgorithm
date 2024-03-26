package programmers;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "lot", "dog", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];

        answer = dfs(begin, target, words, 0, visited);
        return answer;
    }

    public static int dfs(String begin, String target, String[] words, int cnt, boolean[] visited) {
        int answer = 0;

        if (begin.equals(target)) {
            return cnt;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true;
                answer = dfs(words[i], target, words, cnt + 1, visited);
                visited[i] = false;
            }
        }

        return answer;
    }
}

/*
 1. answer / 최단 경로의 개수 1000000007
 2. 오른쪽과 아래쪽만 움직일 수 있음
 3. graph = m * n
*/