import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        boolean []structure = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp==1){
                structure[i]=true;
            }
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(structure[i]==true){
                continue;
            }
            stack.push(tmp);
        }
        int m =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m>0){
            if(!stack.isEmpty()){
                bw.write(stack.pop()+" ");
            }
            else{
                bw.write(st.nextToken()+" ");
            }
            --m;
        }

        br.close();
        bw.close();

    }
}