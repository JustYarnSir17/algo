import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        
        int sum=0;
        int mul =1;
        int div=1;
        boolean tr =false;
        //plus가 0이 아닐 때 괄호가 닫히면 해당하는 괄호 값과 plus에 곱한다. 
        //plus가 0일 때 괄호가 닫히면 해당하는 괄호 값을 plus에 더한다.
        //괄호가 닫히고 stack이 비어있으면 plus값을 sum에 더한다. plus 는 0으로 초기화
        String str = br.readLine();
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)=='(') {//괄호가 시작될 떄
        		if(tr) {
        			sum+=mul;
        			tr=false;
        		}
        		mul/=div;
        		div=1;
        		mul*=2;
        		stack.push('(');
        	}
        	else if(str.charAt(i)=='[') {// 괄호가 시작될 때
        		if(tr) {
        			sum+=mul;
        			tr=false;
        		}
        		mul/=div;
        		div=1;
        		mul*=3;
        		
        		stack.push('[');
        	}
        	else if(str.charAt(i)==')') {//괄호가 닫힐 때
        		if(stack.isEmpty()) {
        			bw.write("0");
        			bw.close();
        			br.close();
        			return;
        		}
        		else {
        			if(stack.peek()!='(') {//괄호 짝이 맞지 않을 떄는 0 출력
            			bw.write("0");
            			bw.close();
            			br.close();
            			return;
            		}
            		else {//괄호 짝이 맞을 때
            			div*=2;
            			stack.pop();
            			tr=true;
            			if(stack.isEmpty()) {
            				sum+=mul;
            				mul=1;
            				div=1;
            				tr=false;
            			}
            		}
        		}
        	}
        	else {
        		if(stack.isEmpty()) {
        			bw.write("0");
        			bw.close();
        			br.close();
        			return;
        		}
        		else {
        			if(stack.peek()!='[') {
            			bw.write("0");
            			bw.close();
            			br.close();
            			return;
            		}
            		else {
            			div*=3;
            			stack.pop();
            			tr=true;
            			if(stack.isEmpty()) {
            				sum+=mul;
            				mul=1;
            				div=1;
            				tr=false;
            			}
            		}
        		}
        	}
        	
        }
        if(!stack.isEmpty()) {
        	bw.write("0");
        }
        else {
        	bw.write(sum+"");
        	
        }
        bw.close();
        br.close();
        
        
	}
}