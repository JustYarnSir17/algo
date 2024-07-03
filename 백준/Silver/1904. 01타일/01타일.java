import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] arr = new int [1000001];
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=1000000;i++) {
			arr[i]=(arr[i-1]+arr[i-2])%15746;
		}
		
		int n = Integer.parseInt(br.readLine());
		
		
		bw.write(arr[n]+"");
		bw.close();
		br.close();
	}

}