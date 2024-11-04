import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n =Integer.parseInt(br.readLine());
    	int [] arr = new int [n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	int left= 0;
    	int right = n-1;
    	int score= 0;
    	while(left<right) {
    		int dist = right-left-1;
    		int m = Math.min(arr[left],arr[right]);
    		score=Math.max(score,dist*m);
    		if(arr[left]<arr[right]) {
    			left++;
    		}
    		else {
    			right--;
    		}
    		
    	}
    	bw.write(String.valueOf(score));
    	bw.close();
    	br.close();
    }
    
}