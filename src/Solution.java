import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int p = 20;
        int fullPizza = (1 << p) - 1;
        System.out.println(fullPizza);
        System.out.printf(Integer.toBinaryString(fullPizza) + "\n");

        int toppings = (1 << p) -1;
        toppings |= (1 << p);
        System.out.println(toppings);
        System.out.printf(Integer.toBinaryString(toppings) + "\n");

        if((toppings & (1 << p)) > 0)
            System.out.println("pepperoni is in");

        toppings -= (1 << p);
        System.out.println(toppings);
        System.out.printf(Integer.toBinaryString(toppings) + "\n");

        toppings &= ~(1 << p);
        System.out.println(toppings);
        System.out.printf(Integer.toBinaryString(toppings) + "\n");

        toppings ^= (1 << p);
        System.out.println(toppings);
        System.out.printf(Integer.toBinaryString(toppings) + "\n");

        int a = (1 << 4) -1;
        int b = (1 << 3);
        int added = (a | b) ;       // 합집합
        int intersection = (a & b); // 교집합
        int removed = (a &~ b);      // 차집합
        int toolged = (a ^ b);      // a와 b중 하나에만 포함된 원소들의 집합

        System.out.println("================================================");
        System.out.printf(Integer.toBinaryString(a) + "\n");
        System.out.printf(Integer.toBinaryString(b) + "\n");
        System.out.println("합집합: "+ added);
        System.out.println("교집합: "+ intersection);
        System.out.println("차집합: "+ removed);
        System.out.println("a와 b중 하나에만 포함된 원소들의 집합: "+ toolged);
        System.out.println(Integer.bitCount(a));
    }
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