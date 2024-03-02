package programmers.level2;

import java.util.Stack;

public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        int index = 0;

        for(int i=1; i<order.length+1; i++) {
            belt.add(i);
            while(!belt.isEmpty() && belt.peek() == order[index]) {
                belt.pop();
                index ++;
                answer ++;
            }
        }

        return answer;
    }
}
