import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
//        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(solution(4, 3, new int[][]{{1, 3}, {3, 1}}));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[n][m];
        int[][] cache = new int[n][m];

        for (int[] i : puddles) {
            if (i[0] > 0 && i[1] > 0)
                cache[i[1] - 1][i[0] - 1] = -1;
        }

        return (int) (recursive(graph, cache, 0, 0) % 1000000007);
    }

    public static long recursive(int[][] graph, int[][] cache, int y, int x) {
        if (y >= graph.length || x >= graph[0].length || cache[y][x] == -1)
            return 0;

        if (cache[y][x] > 0) {
            cache[y][x] += 1;
            return cache[y][x];
        }
        else if (y == graph.length - 1 && x == graph[0].length - 1) {
            return 1;
        }

        cache[y][x] += 1;

        cache[y][x] = (int) (recursive(graph, cache, y + 1, x) + recursive(graph, cache, y, x + 1));
        return (long) cache[graph.length-1][graph[0].length-2] + (long) cache[graph.length-2][graph[0].length-1];
    }

//    public static long recursive(int[][] graph, int[][] cache, int y, int x) {
//        if (y >= graph.length || x >= graph[0].length || cache[y][x] == -1)
//            return 0;
//
//        cache[y][x] = 1;
//        if (cache[y][x] == 0 && y > 0 && x > 0)
//            return 1;
//        else if (y == graph.length - 1 && x == graph[0].length - 1) {
//            cache[y][x] = 1;
//            return 1;
//        }
//
//        return recursive(graph, cache, y + 1, x) + recursive(graph, cache, y, x + 1);
//    }

    public static long search(int[][] graph, int[][] visited) {
        int[][] coord = new int[][]{{1, 0}, {0, 1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int y = temp.getY();
            int x = temp.getX();

            for (int[] ints : coord) {
                int nextY = ints[0] + y;
                int nextX = ints[1] + x;

                if (nextY < graph.length && nextX < graph[0].length && visited[nextY][nextX] != -1) {
                    queue.add(new Pair(nextY, nextX));
                    visited[nextY][nextX] += 1;
                }
            }
        }

        return (long) visited[visited.length - 2][visited[0].length - 1] + (long) visited[visited.length - 1][visited[0].length - 2];
    }

    // 오른쪽, 아래  x+1, y+1

    public static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}

/*
 1. answer / 최단 경로의 개수 1000000007
 2. 오른쪽과 아래쪽만 움직일 수 있음
 3. graph = m * n
*/