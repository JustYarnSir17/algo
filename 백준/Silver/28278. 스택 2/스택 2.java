import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack stack = new Stack();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "1":
                    int tmp = Integer.parseInt(st.nextToken());
                    stack.push(tmp);
                    break;
                case "2":
                    if(stack.empty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(stack.pop()+"\n");
                    }
                    break;
                case "3":
                    bw.write(stack.size()+"\n");
                    break;
                case "4":
                    if(stack.empty()){
                        bw.write("1\n");
                    }
                    else{
                        bw.write("0\n");
                    }
                    break;
                case "5":
                    if(stack.empty()){
                        bw.write("-1\n");
                    }
                    else{
                        bw.write(stack.peek()+"\n");
                    }
                    break;
            }
        }


        br.close();
        bw.close();

    }
}