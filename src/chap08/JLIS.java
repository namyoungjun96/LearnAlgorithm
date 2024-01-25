package chap08;

public class JLIS {
    static int n, m;
    static int[] A;
    static int[] B;
    static int[][] cache;

    public static void main(String[] args) {
        A = new int[]{1, 2, 4};
        B = new int[]{3, 4, 7};
        n = 3;
        m = 3;
        cache = new int[101][101];

        System.out.println(jlis(-1, -1) -1);
    }

    static int jlis(int indexA, int indexB) {
        if(cache[indexA+1][indexB+1] != 0) return cache[indexA+1][indexB+1];

        cache[indexA+1][indexB+1] = 2;

        long a = indexA == -1 ? Long.MIN_VALUE : A[indexA];
        long b = indexB == -1 ? Long.MIN_VALUE : B[indexB];
        long maxElement = Math.max(a, b);

        for (int nextA = indexA+1; nextA < n; nextA++)
            if(maxElement < A[nextA])
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(nextA, indexB) + 1);

        for (int nextB = indexB+1; nextB < m; nextB++)
            if(maxElement < B[nextB])
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], jlis(indexA, nextB) + 1);

        return cache[indexA+1][indexB+1];
    }
}
