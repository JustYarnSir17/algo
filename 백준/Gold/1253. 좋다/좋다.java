import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        
        int []arr= new int [n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++) {
        	int tmp=Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        Arrays.sort(arr);
        int cnt=0;
        for(int i=0;i<n;i++) {
        	int left= 0;
        	int right = n-1;
        	if(left==i) {
        		left++;
        	}
        	if(right==i) {
        		right--;
        	}
        	while(left<right) {
        		if(arr[left]+arr[right]==arr[i]) {
        			cnt++;
        			break;
        		}
        		else {
        			if(arr[left]+arr[right]<arr[i]) {
        				left++;
        			}
        			else {
        				right--;
        			}
        		}
        		if(left==i) {
        			left++;
        		}
        		if(right==i) {
        			right--;
        		}
        	}
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
        
    }
}