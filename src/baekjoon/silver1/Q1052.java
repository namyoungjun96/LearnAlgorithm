package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1052 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());

        System.out.println(1015808 / 5);
    }
}

/*
    1. N개의 물병의 물을 적절히 재분배해, 이동시 K개 만큼만 가져가고 싶다.
    2. 모든 N개의 물은 1리터
    3. 다른 장소로는 한번만 이동 가능
    4. 같은 양의 물이 들어있는 물병 두개 중 하나에 모두 붓는다. 필요한 만큼 가능
    5. 안되면 새로운 물병도 살 수 있음 상점에서 사는 물은 1리터

    1 1 1
    2, 1
    2, 1 + 1
    2 2
    4

    1 1 1 1 1 1 1 1 1 1 1 1 1 1
    2 2 2 2 2 2, 1
    4 4 4, 1
    8 4, 1 + 1
    8 4, 2 + 1 + 1
    8 4 4
    8 8
 */