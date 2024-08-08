import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String bomb = br.readLine();
        if(str.length()<bomb.length()) {
        	bw.write(str);
        	br.close();
        	bw.close();
        	return;
        }
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<str.length();i++) {
        	stack.push(str.charAt(i));
        	if(str.charAt(i)==bomb.charAt(bomb.length()-1)) {
        		boolean tr=true;
        		for(int j=0;j<bomb.length();j++) {
        			if(stack.size()>=bomb.length()) {
        				if(stack.get(stack.size()-j-1)!=bomb.charAt(bomb.length()-1-j)) {
            				tr=false;
            				break;
            			}
        			}
        			else {
        				tr=false;
        				break;
        			}
        		}
        		if(tr) {
        			for(int j=0;j<bomb.length();j++) {
        				stack.pop();
        			}
        		}
        	}
        }
        
        
        if(stack.isEmpty()) {
        	bw.write("FRULA");
        	bw.close();
        	br.close();
        	return;
        }
        else {
        	StringBuilder sb= new StringBuilder();
        	while(!stack.isEmpty()) {
            	sb.append(stack.pop());
            }
        	bw.write(sb.reverse().toString());
            bw.close();
            br.close();
            return;
        }
        
        
        
        
        
    }
}