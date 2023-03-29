import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int num=n*(n-1)/2;
		int [][] v= new int [n+1][2];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			v[i][0]=Integer.parseInt(st.nextToken());
			v[i][1]=Integer.parseInt(st.nextToken());
		}
		p=new int [n];
		for(int i=0;i<n;i++)
			p[i]=i;
		double [][]edges = new double [num][3];
		int idx=0;

		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			union(x-1,y-1);
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				edges[idx][0]=i;
				edges[idx][1]=j;
				edges[idx++][2]=Math.sqrt(Math.pow(v[i][0]-v[j][0], 2)+Math.pow(v[i][1]-v[j][1], 2));
			}
		}
		for(int i=0;i<n;i++) {
			findset(i);
		}
		int cnt=0;
		for(int i=1;i<n;i++) {
			if(p[i]!=i) {
				cnt++;
			}	
		}
		Arrays.sort(edges,new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				// TODO Auto-generated method stub
				if(o1[2]-o2[2]<0)
					return -1;
				else if (o1[2]-o2[2]==0)
					return 0;
				else 
					return 1;
			}
		});
		double result =0;
		
		for(int i=0;i<num;i++) {
			if(findset((int)edges[i][0])!=findset((int)edges[i][1])) {
				union((int)edges[i][0],(int)edges[i][1]);
				result+=edges[i][2];
				cnt++;
			}
			if(cnt==n-1)
				break;
		}
		result= Math.round(result*100)/100.0;
		bw.write(String.format("%.2f", result));
		bw.close();
		br.close();
	}
	private static void union(int i, int j) {
		// TODO Auto-generated method stub
		p[findset(i)]=findset(j);
	}
	private static int findset(int i) {
		// TODO Auto-generated method stub
		if(p[i]==i)return i;
		p[i]=findset(p[i]);
		return p[i];
	}
}