import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        int [][] arr = new int [n][n];
	        for(int i=0;i<n;i++) {
	        	Arrays.fill(arr[i],Integer.MAX_VALUE);
	        	arr[i][i]=0;
	        }
	        for(int i=0;i<m;i++) {
	        	st= new StringTokenizer(br.readLine());
	        	int a=Integer.parseInt(st.nextToken())-1;
	        	int b=Integer.parseInt(st.nextToken())-1;
	        	int t=Integer.parseInt(st.nextToken());
	        	arr[a][b]=t;
	        }
	        for(int k=0;k<n;k++) {
	        	for(int i=0;i<n;i++) {
	        		for(int j=0;j<n;j++) {
	        			if(arr[i][k]!=Integer.MAX_VALUE&&arr[k][j]!=Integer.MAX_VALUE) {
	        				arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
	        			}
	        		}
	        	}
	        }
	        int k =Integer.parseInt(br.readLine());
	        int [] fr= new int[k];
	        st= new StringTokenizer(br.readLine());
	        for(int i=0;i<k;i++) {
	        	int tmp = Integer.parseInt(st.nextToken())-1;
	        	fr[i]=tmp;
	        }

	        //모든 도시 중 각 친구들 사이의 왕복거리가 최대가 되는 거리를 저장하는 배열
	        int [] time= new int [n];
	        for(int i=0;i<n;i++) {
	        	int t=0;
	        	for(int j=0;j<k;j++) {//각 친구들의 위치에서 해당 도시로의 왕복 거리 계산
	        		int tmp= arr[i][fr[j]];
	        		tmp+=arr[fr[j]][i];
	        		if(t<tmp) {
	        			t=tmp;
	        			time[i]=t;
	        		}
	        	}
	        }
	        StringBuilder sb= new StringBuilder();
	        int t=Integer.MAX_VALUE;
	        for(int i=0;i<n;i++) {
	        	if(time[i]<t) {
	        		t=time[i];
	        		sb=new StringBuilder(String.valueOf(i+1));
	        	}
	        	else if(time[i]==t) {
	        		sb.append(" "+(i+1));
	        	}
	        }
	        
	        bw.write(sb.toString());
	        bw.close();
	        br.close();
	        
	 }
}