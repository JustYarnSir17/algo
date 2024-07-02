import  java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new  OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int [][]study  = new int [n][2];
		int [] score = new int[T+1];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			study[i][0]=k;
			study[i][1]=s;
			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=T;j>=study[i][0];j--) {
				score[j]=Math.max(score[j],score[j-study[i][0]]+study[i][1]);
			}
		}
		
		bw.write(score[T]+"");
		bw.close();
		br.close();
	}

}