package chap07;

import java.util.List;

public class Fence {
    public static int[] fenceHeight;

    public static void main(String[] args) {
        System.out.println(solution(7, new int[]{7, 1, 5, 9, 6, 7, 3}));
        System.out.println(solution(7, new int[]{1, 4, 4, 4, 4, 1, 1}));
        System.out.println(solution(4, new int[]{1, 8, 2, 2}));

        fenceHeight = new int[]{7, 1, 5, 9, 6, 7, 3};
        System.out.println(solve(0, 6));
    }

    public static int solution(int N, int[] board) {
        int res = 0;

        for (int i = 0; i < N; i++) {
            int a = recursive(board, board[i], i, -1);
            res = Math.max(board[i] * a, res);
            int b = recursive(board, board[i], i, +1);
            res = Math.max(board[i] * b, res);
        }

        return res;
    }

    public static int recursive(int[] board, int num, int index, int operator) {
        if (index >= board.length || index < 0) return 0;

        if (num > board[index]) return 0;

        return recursive(board, num, index + operator, operator) + 1;
    }

    int bruteForce(List<Integer> h) {
        int ret = 0;
        int N = h.size();

        for (int left = 0; left < N; left++) {
            int minHeight = h.get(left);

            for (int right = left; right < N; right++) {
                minHeight = Math.min(minHeight, h.get(right));
                ret = Math.max(ret, (right - left + 1) * minHeight);
            }
        }

        return ret;
    }

    public static int solve(int left, int right) {
        // 기저 사례: 판자가 하나밖에 없는 경우
        if (left == right) return fenceHeight[left];
        // [left, mid], [mid + 1, right]의 두 구간으로 문제를 분할한다.
        int mid = (left + right) / 2;
        // 분할한 문제를 각개격파
        int result = Math.max(solve(left, mid), solve(mid + 1, right));
        // 부분 문제 3: 두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾는다.
        int lo = mid, hi = mid + 1;
        int height = Math.min(fenceHeight[lo], fenceHeight[hi]);
        // [mid, mid + 1]만 포함하는 너비 2인 사각형을 고려한다.
        result = Math.max(result, height * 2);
        // 사각형이 입력 전체를 덮을 때까지 확장해 나간다.
        while (left < lo || hi < right) {
            // 항상 높이가 더 높은 쪽으로 확장한다.
            if (hi < right && (lo == left || fenceHeight[lo - 1] < fenceHeight[hi + 1])) {
                hi++;
                height = Math.min(height, fenceHeight[hi]);
            } else {
                lo--;
                height = Math.min(height, fenceHeight[lo]);
            }
            // 확장한 후 사각형의 넓이
            result = Math.max(result, height * (hi - lo + 1));
        }
        return result;
    }
}

// 입력
// 테스트 케이스 C
// 판자의 수 N
// N개의 정수로 왼쪽부터 각 판자의 높이 배열