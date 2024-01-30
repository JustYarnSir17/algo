import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx=1;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack =new Stack<>();
        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2= new Stack<>();

        StringTokenizer st= new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            stack.push(tmp);
        }
        while(!stack.isEmpty()){
            s1.push(stack.pop());
        }

        while(idx<=n){
            if(!s1.isEmpty()){
                if(s1.peek()==idx){
                    s1.pop();
                    ++idx;
                }
                else{
                    if(s2.isEmpty()){
                        int tmp = s1.pop();
                        s2.push(tmp);
                    }
                    else{
                        if(s2.peek()==idx){
                            s2.pop();
                            ++idx;
                        }
                        else{
                            if(s1.peek()>s2.peek()){
                                bw.write("Sad");
                                bw.close();
                                return;
                            }
                            else{
                                int tmp=s1.pop();
                                s2.push(tmp);
                            }

                        }
                    }

                }
            }
            else{
                if(s2.peek()==idx){
                    s2.pop();
                    ++idx;
                }
                else{
                    bw.write("Sad");
                    bw.close();
                    return;
                }

            }
        }
        bw.write("Nice");
        br.close();
        bw.close();

    }
}