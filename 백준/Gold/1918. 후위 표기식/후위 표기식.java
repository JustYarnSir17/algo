import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
	static int icp(char a) {
		char tmp = a;
		int icp = 0;
		switch (tmp) {
		case '-':
		case '+':
			icp = 1;
			break;
		case '*':
		case '/':
			icp = 2;
			break;
		case '(':
			icp = 3;
			break;
		}
		return icp;

	}

	static int isp(char a) {
		char tmp = a;
		int isp = 0;
		switch (tmp) {
		case '-':
		case '+':
			isp = 1;
			break;
		case '*':
		case '/':
			isp = 2;
			break;
		case '(':
			isp = 0;
			break;
		}
		return isp;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		stack.add('(');
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if('A'<=tmp&&tmp<='Z') {
				sb.append(tmp);
			}
			else if (tmp != ')') {
				int icp = icp(tmp);
				if (icp > isp(stack.peek())) {
					stack.push(tmp);
				} else {
					while (icp <= isp(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.push(tmp);
				}
			}
			else {
				while(stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}

			

		}
		while(stack.peek()!='(') {
			sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}