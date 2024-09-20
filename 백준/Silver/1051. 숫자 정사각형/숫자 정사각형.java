import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int [][] arr;
	static int size=1;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr= new int[n][m];
        for(int i=0;i<n;i++) {
        	String str= br.readLine();
        	for(int j=0;j<m;j++) {
        		arr[i][j]=str.charAt(j)-'0';
        	}
        }
        find();
        bw.write(size+"");
        bw.close();
        br.close();
	}
	
	public static void find() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cal(i,j);
			}
		}
	}
	
	public static void cal(int r,int c) {
		int s = (int)Math.sqrt(size);
		int val = arr[r][c];
		while(s<50) {
			if(r+s>=n||c+s>=m)
				break;
			if(arr[r+s][c]==val&&arr[r][c+s]==val&&arr[r+s][c+s]==val) {
				size = (s+1)*(s+1);	
			}
			s++;
			
		}
	}
}