import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new ArrayDeque<>();
        int n =Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++) {
        	dq.offerLast(i);
        }
        List<Integer> list = new ArrayList<>();
        while(dq.size()>=2) {
        	list.add(dq.pollFirst());
        	int tmp =dq.pollFirst();
        	dq.offerLast(tmp);
        }
        for(int num:list) {
        	bw.write(num+" ");
        }
        bw.write(dq.poll()+"");
        bw.close();
        br.close();
    }
    
    
}