import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new LinkedHashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(!set.contains(tmp)) {
        		set.add(tmp);
        		map.put(tmp,1);
        	}
        	else {
        		map.replace(tmp,map.get(tmp)+1);
        	}
        }
        int idx=0;
        for(int num:set) {
        	pq.offer(new Node(num,map.get(num),idx++));
        }
        while(!pq.isEmpty()) {
        	Node tmp = pq.poll();
        	for(int i=0;i<tmp.cnt;i++) {
        		bw.write(tmp.num+" ");
        	}
        }
        bw.close();
        br.close();
        
	}
	
}
class Node implements Comparable<Node>{
	int num;
	int cnt;
	int index;  // 추가: 삽입된 순서를 기록할 필드
	Node(int num, int cnt, int index){
		this.num = num;
		this.cnt = cnt;
		this.index = index;
	}
	@Override
	public int compareTo(Node o) {
		if(this.cnt == o.cnt) {
			return this.index - o.index;  // cnt가 동일할 경우 삽입 순서로 비교
		}
		return o.cnt - this.cnt;  // cnt 기준으로 내림차순 정렬
	}
}