import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getTime));
        int servers = 0;

        for (int time = 0; time < 24; time++) {
            int playerCount = players[time];

            if (servers * m <= playerCount && (servers + 1) * m <= playerCount) {
                int serverCount = (playerCount / m) - servers;
                pq.add(new Node(time + k - 1, serverCount));
                answer += serverCount;
                servers += serverCount;
            }

            while (!pq.isEmpty() && pq.peek().getTime() <= time) {
                servers -= pq.poll().getSize();
            }
        }

        return answer;
    }

    public class Node {
        int time;
        int size;

        public Node(int time, int size) {
            this.time = time;
            this.size = size;
        }

        public int getTime() {
            return time;
        }

        public int getSize() {
            return size;
        }
    }
}

// (n*m) <= x < (n+1)*m == x < n
// 증설 == k시간만 운영
// 게임 이용자 수 players, 서버 1대 최대 이용자 수 m, 증설한 서버가 운영 가능한 시간 k
// 2 => (n * 3) <= 3 < (n+1) * 3 || n == 0
// 3 => (1 * 3) <= 3 < (1+1) * 3 || n == 1
// 13 => (n * 3) <= 13 < (n+1) * 3 || n == 4
// 시간마다 (n*m) < x < (n+1)*m 를 만족하는 서버의 개수가 필요 + 시간마다 n은 늘어난만큼 차감되야 함
// k == 5 => 1개 증설 = 5 | 5개 증설 = 25