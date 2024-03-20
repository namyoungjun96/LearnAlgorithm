package programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> worksQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: works)
            worksQueue.add(i);

        for(int i=0; i<n; i++) {
            if(!worksQueue.isEmpty()) {
                int work = worksQueue.poll();
                work -= 1;

                if(work > 0)
                    worksQueue.add(work);
            }
            else
                break;
        }

        if(!worksQueue.isEmpty()) {
            for(int i: worksQueue) {
                answer += (long) i * i;
            }
        }

        return answer;
    }
}
