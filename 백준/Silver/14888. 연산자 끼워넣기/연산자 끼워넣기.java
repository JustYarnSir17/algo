import java.io.*;
import java.util.*;


public class Main {
	static int [] cal = new int [4];//덧셈, 뺄셈, 곱셈, 나눗셈
	static int n;
	static int minValue=Integer.MAX_VALUE;
	static int maxValue=Integer.MIN_VALUE;
	static Stack<Integer> stack =new Stack<>();
	static int [] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	cal[i]=tmp;
        }
        
        find(0);
        
        bw.write(maxValue+"\n"+minValue);
        
        
        bw.close();
        br.close();
        
	}	

	public static void find(int cnt) {
		if(cnt==n-1) {
			int result=arr[0];
			int idx=1;
			for(int num:stack) {
				if(num==0) {
					result+=arr[idx++];
				}
				else if(num==1) {
					result-=arr[idx++];
				}
				else if(num==2) {
					result*=arr[idx++];
				}
				else {
					if(result<0) {
						result*=-1;
						result/=arr[idx++];
						result*=-1;
					}
					else {
						result/=arr[idx++];
					}
					
					
				}
			}
			maxValue=Math.max(result,maxValue);
			minValue=Math.min(result,minValue);
			return;
		}
		for(int i=0;i<4;i++) {
			if(cal[i]>0) {
				cal[i]--;
				stack.push(i);
				find(cnt+1);
				stack.pop();
				cal[i]++;
			}
		}
	}
	
	
}