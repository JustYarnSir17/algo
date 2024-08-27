import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        double m = Double.parseDouble(st.nextToken());
        while(n!=0&&m!=0.00) {
        	int [][] candy = new int [n][2];
        	for(int i=0;i<n;i++) {
        		st=new StringTokenizer(br.readLine());
        		int c=Integer.parseInt(st.nextToken());
        		double p =Double.parseDouble(st.nextToken());
        		int price= (int)(p*100+0.5);
        		candy[i][0]=c;
        		candy[i][1]=price;
        	}
        	int []money = new int [10001];
        	for(int i=0;i<n;i++) {
        		for(int j=1;j<=10000;j++) {
        			if(j-candy[i][1]>=0) {
        				money[j]=Math.max(money[j],money[j-candy[i][1]]+candy[i][0]);
        			}
        		}
        	}
        	System.out.println(money[(int)(m*100+0.5)]);
        	st=new StringTokenizer(br.readLine());
        	n=Integer.parseInt(st.nextToken());
        	m=Double.parseDouble(st.nextToken());
        }
        
	}
}