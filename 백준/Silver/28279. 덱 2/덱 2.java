import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "1":
                    int first = Integer.parseInt(st.nextToken());
                    deq.addFirst(first);
                    break;
                case "2":
                    int second = Integer.parseInt(st.nextToken());
                    deq.addLast(second);
                    break;
                case "3":
                    if(deq.isEmpty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(deq.pollFirst()+"\n");

                    }
                    break;
                case "4":
                    if(deq.isEmpty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(deq.pollLast()+"\n");
                    }
                    break;
                case "5":
                    bw.write(deq.size()+"\n");
                    break;
                case "6":
                    if(deq.isEmpty()){
                        bw.write("1\n");
                    }
                    else{
                        bw.write("0\n");
                    }
                    break;
                case "7":
                    if(deq.isEmpty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(deq.getFirst()+"\n");
                    }
                    break;
                case "8":
                    if(deq.isEmpty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(deq.getLast()+"\n");
                    }
                    break;
            }

        }

        
        br.close();
        bw.close();

    }
}