import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'P') {//p일 경우 그냥 push
                stack.push(ch);
            } else if (ch == 'A') {//a일 경우
                if (stack.size() >= 2 && i < str.length() - 1 && str.charAt(i + 1) == 'P') {
                	//스택의 크기가 2 이상이고, i가 마지막 인덱스를 가리키고 있지 않고, i뒤의 문자가 P일 경우
                	//PPAP 문자열 성립
                    stack.pop(); 
                    stack.pop(); 
                    stack.push('P');
                    i++;
                } else {//위의 조건이 아닐 경우 NP
                    bw.write("NP");
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
        
        //위의 과정을 거친 후 Stack에 P하나가 있을 경우
        if (stack.size() == 1 && stack.peek() == 'P') {
            bw.write("PPAP");
        } else {
            bw.write("NP");
        }
        
        bw.close();
        br.close();
    }
}