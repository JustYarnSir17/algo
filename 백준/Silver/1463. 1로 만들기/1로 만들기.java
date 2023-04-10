import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int []arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		arr=new int [n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[1]=0;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+1;
			if(i%2==0) {
				arr[i]=Math.min(arr[i], arr[i/2]+1);
			}
			if(i%3==0) {
				arr[i]=Math.min(arr[i], arr[i/3]+1);
			}
			
		}
		bw.write(String.valueOf(arr[n]));
		bw.close();
		br.close();
	}
	
}