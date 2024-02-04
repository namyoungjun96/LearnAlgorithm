package chap21;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Traversal {
    public static int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    // 트리의 전위탐색 결과와 중위탐색 결과가 주어질 때 후위탐색 결과를 출력하낟.
    public static void printPostOrder(int[] preOrder, int[] inOrder) {
        // 트리에 포함된 노드위 수
        final int N = preOrder.length;
        // 기저 사례: 텅 빈 트리면 곧장 종료
        if (preOrder.length == 0) return;
        // 이 트리의 루트는 전위 탐색 결과로부터 곧장 알 수 있다.
        final int root = preOrder[0];
        // 이 트리의 왼쪽 서브트리의 크기는 중위 탐색 결과에서 루트의 위치를 찾아서 알 수 있다.
        final int L =find(inOrder, root);
        // 오른쪽 서브트리의 크기는 N에서 왼쪽 서브트리와 루트를 빼면 알 수 있다.
        final int R = N - 1 - L;
        // 왼쪽과 오른쪽 서브트리의 순회 결과를 출력
        printPostOrder(Arrays.copyOfRange(preOrder, 1, L + 1), Arrays.copyOfRange(inOrder, 0, L));
        printPostOrder(Arrays.copyOfRange(preOrder, L + 1, N), Arrays.copyOfRange(inOrder, L + 1, N));
        // 후위 순회이므로 루트를 가장 마지막에 출력한다.
        System.out.print(root + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] preOrder, inOrder;
        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            String preOrderStr = br.readLine();
            String midOrderStr = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(preOrderStr);
            preOrder = new int[tokenizer.countTokens()];
            for (int j = 0; j < preOrder.length; j++) {
                preOrder[j] = Integer.parseInt(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(midOrderStr);
            inOrder = new int[tokenizer.countTokens()];
            for (int j = 0; j < inOrder.length; j++) {
                inOrder[j] = Integer.parseInt(tokenizer.nextToken());
            }
            printPostOrder(preOrder, inOrder);
            System.out.println();
        }
    }
}
