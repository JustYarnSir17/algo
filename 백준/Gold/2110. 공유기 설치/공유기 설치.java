import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int [] arr = new int [n];
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        Arrays.sort(arr);

        
        int left=1;
        int right = arr[n-1]-arr[0];
        int answer=0;
        while(left<=right) {
        	int mid = (left+right)/2;
        	if(find(arr,c,mid)) {
        		left=mid+1;
        		answer=mid;
        	}
        	else {
        		right=mid-1;
        	}
        	
        }
        bw.write(answer+"");
        bw.close();
        br.close();
        
    }
    
    public static boolean find(int [] arr,int c,int dist) {
    	int pre= arr[0];
    	int cnt=1;
    	for(int i=1;i<arr.length;i++) {
    		if(arr[i]-pre>=dist) {
    			cnt++;
    			pre=arr[i];
    		}
    		
    	}

    	
    	return cnt>=c;
    }
}