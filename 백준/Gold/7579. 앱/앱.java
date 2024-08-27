import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int MAX = 1000000001;
        st=new StringTokenizer(br.readLine());
        int [][] app= new int [n+1][2]; 
        for(int i=1;i<=n;i++) {//사용 메모리
        	int tmp =Integer.parseInt(st.nextToken());
        	app[i][0]=tmp;
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {//비활성화 비용
        	int tmp =Integer.parseInt(st.nextToken());
        	app[i][1]=tmp;
        }
        int [][] memory= new int [n+1][10001];
        for(int i=1;i<=n;i++) {
        	for(int j=0;j<=10000;j++) {
        		if(j-app[i][1]>=0) {
        			memory[i][j]=Math.max(memory[i-1][j],memory[i-1][j-app[i][1]]+app[i][0]);
        		}
        		else {
        			memory[i][j]=memory[i-1][j];
        		}
        	}
        }
        int cost=Integer.MAX_VALUE;
        
        for(int j=0;j<=10000;j++) {
        	for(int i=1;i<=n;i++) {
        		if(memory[i][j]>=m) {
        			if(cost>j) {
        				cost=j;
        			}
        			
        		}
        	}
        	
        }
        bw.write(cost+"");
        bw.close();
        br.close();
        
	}
}