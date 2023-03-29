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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int [][]edges = new int [e][3];
		for(int i=0;i<e;i++) {
		st= new StringTokenizer(br.readLine());
		edges[i][0]=Integer.parseInt(st.nextToken());
		edges[i][1]=Integer.parseInt(st.nextToken());
		edges[i][2]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		int result=0;
		int cnt=0;
		p=new int [v+1];
		
		for(int i=1;i<=v;i++) {
			p[i]=i;
		}
		for(int i=0;i<e;i++) {
			if(findset(edges[i][0])!=findset(edges[i][1])){
				union(edges[i][0],edges[i][1]);
				result+=edges[i][2];
				cnt++;
			}
		}
		bw.write(String.valueOf(result));
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