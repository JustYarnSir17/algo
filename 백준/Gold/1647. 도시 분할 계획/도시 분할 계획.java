import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int [][] arr = new int [m][3];
		p=new int [n+1];
		for(int i=0;i<=n;i++) {
			p[i]=i;
		}

		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i][0]=a;
			arr[i][1]=b;
			arr[i][2]=w;
			
		}
		Arrays.sort(arr,new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		
		
		int result=0;
		int tmp=0;
		for(int i=0;i<m;i++) {
			if(find(arr[i][0])!=find(arr[i][1])) {
				union(arr[i][0],arr[i][1]);
				tmp=Math.max(tmp, arr[i][2]);
				result+=arr[i][2];
			}
		}
		result-=tmp;
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
		
		
	}
	static void union(int n,int m) {
		p[find(n)]=find(m);
	}
	static int find(int n) {
		if(n!=p[n])
			p[n]=find(p[n]);
		return p[n];
	}
}