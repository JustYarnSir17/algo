import  java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new  OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int [][] arr = new int [n][2];
		int [] happy = new int [101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i][0]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1,int []o2) {
				return o1[0]-o2[0];
			}
		});


		for(int i=0;i<n;i++) {
			for(int j=100;j>arr[i][0];j--) {
				happy[j]=Math.max(happy[j],happy[j-arr[i][0]]+arr[i][1]);
			}
		}
		System.out.println(happy[100]);
		
	}

}