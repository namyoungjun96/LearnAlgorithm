package programmers.level3;

public class Q42898 {
    public static int recursive(int[][] graph, int[][] puddles, boolean[][] cache, int y, int x) {
        long answer = 0;
        if (y >= graph.length || x >= graph[0].length)
            return 0;

        cache[y][x] = true;
        if (!cache[y][x] && y>0 && x>0)
            return 1;
        else if (y == graph.length - 1 && x == graph[0].length - 1) {
            cache[y][x] = true;
            return 1;
        }

        for (int[] i : puddles) {
            int puddlesY = i[1] - 1;
            int puddlesX = i[0] - 1;

            if (y == puddlesY && x == puddlesX)
                return 0;
        }

        answer += recursive(graph, puddles, cache, y + 1, x) + recursive(graph, puddles, cache, y, x + 1);

        return (int) (answer % 1000000007);
    }
}
