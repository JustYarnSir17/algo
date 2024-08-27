import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int [] arr= new int[1101];
        int MAX= 100001;
        int [][] util = new int [n+1][2];
        
        Arrays.fill(arr,MAX);
        arr[0]=0;
        for(int i=1;i<=n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int cost= Integer.parseInt(st.nextToken());	
        	int customer= Integer.parseInt(st.nextToken());
        	util[i][0]=cost;
        	util[i][1]=customer;
        	
        }
        for(int i=1;i<=n;i++) {
        	for(int j=util[i][1];j<=1100;j++) {
        		arr[j]=Math.min(arr[j],arr[j-util[i][1]]+util[i][0]);
        	}
        }
        int answer=Integer.MAX_VALUE;
        for(int i=c;i<=1100;i++) {
        	if(arr[i]<answer) {
        		answer=arr[i];
        	}
        }
        
        bw.write(answer+"");
        bw.close();
        br.close();
	}
}