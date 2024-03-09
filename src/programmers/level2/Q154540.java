package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

class Q154540 {
    public static void main(String[] args) {
        int[] answer = solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println(Arrays.toString(answer));
    }

    static int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[] solution(String[] maps) {
        int[] answer = {};
        char[][] graph = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        PriorityQueue<Integer> temp = new PriorityQueue<>();

        for (int i = 0; i < maps.length; i++) {
            graph[i] = maps[i].toCharArray();
        }

        for (int i = 0; i<graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] != 'X' && !visited[i][j])
                    temp.add(dfs(graph, visited, i, j));
            }
        }

        answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.poll();
        }
        return answer;
    }

    public static int dfs(char[][] graph, boolean[][] visited, int y, int x) {
        if(graph[y][x] == 'X' || visited[y][x])
            return 0;

        visited[y][x] = true;

        int answer = Character.getNumericValue(graph[y][x]);

        for(int[] coord: next) {
            int nextY = coord[0] + y;
            int nextX = coord[1] + x;

            if (nextY >= 0 && nextY < graph.length
                    && nextX >= 0 && nextX < graph[0].length) {
                answer += dfs(graph, visited, nextY, nextX);
            }
        }

        return answer;
    }

//    public static int[] solution(String[] maps) {
//        int[] answer = {};
//        int[][] graph = new int[maps.length][maps[0].length()];
//        boolean[][] visited = new boolean[graph.length][graph[0].length];
//        PriorityQueue<Integer> temp = new PriorityQueue<>();
//
//        for (int i = 0; i < maps.length; i++) {
//            for (int j = 0; j < maps[i].length(); j++) {
//                if(maps[i].charAt(j) != 'X')
//                    graph[i][j] = Integer.parseInt(maps[i].substring(j, j+1));
//            }
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                if (graph[i][j] != 0 && !visited[i][j]) {
//                    temp.add(bfs(graph, visited, new Pair(i, j)));
//                }
//            }
//        }
//
//        if(temp.isEmpty())
//            answer = new int[]{-1};
//        else {
//            answer = new int[temp.size()];
//
//            for (int i = 0; i < answer.length; i++) {
//                answer[i] = temp.poll();
//            }
//        }
//
//        return answer;
//    }
//
//    public static int bfs(int[][] graph, boolean[][] visited, Pair mapPair) {
//        int answer = 0;
//        Queue<Pair> mapsQueue = new LinkedList<>();
//        mapsQueue.add(mapPair);
//
//        int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//        while (!mapsQueue.isEmpty()) {
//            Pair pair = mapsQueue.poll();
//
//            int y = pair.getY();
//            int x = pair.getX();
//
//            if(!visited[y][x])
//                answer += graph[y][x];
//
//            visited[y][x] = true;
//
//            for (int[] coord : next) {
//                int nextY = coord[0] + y;
//                int nextX = coord[1] + x;
//
//                if (nextY >= 0 && nextY < graph.length
//                        && nextX >= 0 && nextX < graph[0].length
//                        && graph[nextY][nextX] != 0 && !visited[nextY][nextX]) {
//                    mapsQueue.add(new Pair(nextY, nextX));
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    public static class Pair {
//        int y;
//        int x;
//
//        Pair(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//
//        public int getX() {
//            return this.x;
//        }
//
//        public int getY() {
//            return this.y;
//        }
//    }
}
// 1~9 X는 바다, 숫자는 무인도
// 3 <= maps.length <= 100
// 3 <= maps[i].length() <= 100
// maps[i] == x || 1 ~ 9
// 지도는 직사각형 == 가로, 세로가 다를수도 있다.
// input ex == ["X591X","X1X5X","X231X", "1XXX1"]
// input ex == ["XXX","XXX","XXX"]
// 각 숫자는 머물 수 있는 날수다. 오름차순으로 머물 수 있는 날 수를 출력

/*
    1. 상하좌우 중 붙어 있으면 더하는 섬이다.
    2. 탐색은 상하좌우만 하면 된다.
    3. 캐싱을 해 탐색한 섬은 체크한다.
    4. 최대가 아니라 머물 수 있는 전체를 계산해야 한다.
 */