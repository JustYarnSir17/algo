import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static LinkedList<Integer>[] list;
	static int [] arr;
	static int [] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		list= new LinkedList[n+1];
		arr= new int[n+1];
		order = new int [n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int tmp1=Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int tmp2= Integer.parseInt(st.nextToken());
				list[tmp1].add(tmp2);
				arr[tmp2]++;
				tmp1=tmp2;
			}
		}
		Queue<Integer>q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			if(arr[i]==0) {
				q.add(i);
			}
		}
		int idx=1;
		while(!q.isEmpty()) {
			int tmp=q.poll();
			order[idx++]=tmp;
			arr[tmp]--;
			for(int i=0;i<list[tmp].size();i++) {
				arr[list[tmp].get(i)]--;
				if(arr[list[tmp].get(i)]==0) {
					q.add(list[tmp].get(i));
				}
			}
		}
		int cnt=0;
		for(int i=1;i<=n;i++) {
			if(order[i]==0)
				cnt++;
		}
		if(cnt!=0) {
			System.out.println("0");
		}
		else {
			for(int i=1;i<=n;i++) {
				System.out.println(order[i]);
			}
		}
		
		
	}
}