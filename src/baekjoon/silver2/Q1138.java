package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] lineArray = new int[n];

        for (int i = 0; i < n; i++) {
            lineArray[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(solution(lineArray));
        List<Integer> result = solution(lineArray);
        for (int i: result)
            System.out.print(i + " ");
    }

    private static List<Integer> solution(int[] array) {
        List<Integer> result = new ArrayList<>();

        while (result.size() < array.length) {
            int size = result.size();

            for (int i = 0; i < array.length; i++) {
                int big = 0;
                int temp = array[i];

                if (result.isEmpty() && array[i] == 0) {
                    array[i] = -1;
                    result.add(i + 1);
                }
                else if (temp > -1) {
                    for (int j = 0; j < result.size(); j++) {
                        if (result.get(j) > i + 1)
                            big += 1;

                        if (temp == big) {
                            array[i] = -1;
                            result.add(i + 1);
                            break;
                        }
                    }
                }

                if(size != result.size())
                    break;
            }
        }

        return result;
    }
}
