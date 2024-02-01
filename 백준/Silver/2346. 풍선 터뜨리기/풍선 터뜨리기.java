import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        Deque<Node> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx=1;
        while(st.hasMoreTokens()){
            dq.offer(new Node(idx++,Integer.parseInt(st.nextToken())));
        }

        while(!dq.isEmpty()){
            Node m = dq.poll();
            list.add(m.num);
            if(dq.isEmpty()){
                break;
            }
            if(m.val>0){
                for(int i=0;i<m.val-1;i++){
                    Node tmp =dq.pollFirst();
                    dq.addLast(tmp);
                }
            }
            else{
                for(int i=0;i<Math.abs(m.val);i++){
                    Node tmp = dq.pollLast();
                    dq.addFirst(tmp);
                }
            }
        }
        for(int i=0;i<list.size();i++){
            bw.write(list.get(i)+" ");
        }
        br.close();
        bw.close();

    }
}
class Node{
    int num;
    int val;
    Node(int num, int val){
        this.num=num;
        this.val=val;
    }
}