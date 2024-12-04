import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Node> minPq = new PriorityQueue<>(); // 기본적으로 오름차순
        PriorityQueue<Node> maxPq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val; // 내림차순
            }
        });

        int idx = 0;
        HashSet<Integer> set = new HashSet<>();

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            if (command.equals("I")) {
                int val = Integer.parseInt(st.nextToken());
                Node node = new Node(idx, val);
                minPq.offer(node);
                maxPq.offer(node);
                set.add(idx++);
            } else {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    Node tmp = maxPq.poll();
                    while (tmp != null && !set.contains(tmp.idx)) {
                        tmp = maxPq.poll();
                    }
                    if (tmp != null) {
                        set.remove(tmp.idx);
                    }
                } else {
                    Node tmp = minPq.poll();
                    while (tmp != null && !set.contains(tmp.idx)) {
                        tmp = minPq.poll();
                    }
                    if (tmp != null) {
                        set.remove(tmp.idx);
                    }
                }
            }
        }

        if (set.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            Node low = null;
            Node high = null;

            while (!minPq.isEmpty()) {
                Node tmp = minPq.poll();
                if (set.contains(tmp.idx)) {
                    low = tmp;
                    break;
                }
            }

            while (!maxPq.isEmpty()) {
                Node tmp = maxPq.poll();
                if (set.contains(tmp.idx)) {
                    high = tmp;
                    break;
                }
            }

            if (low != null && high != null) {
                answer[0] = high.val;
                answer[1] = low.val;
            }
        }

        return answer;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int val;

    Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.val, other.val);
    }
}
