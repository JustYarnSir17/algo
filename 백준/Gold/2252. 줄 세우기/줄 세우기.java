import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] arr= new int [n+1];
		LinkedList<Integer>[]list=new LinkedList[n+1];
		for(int i=0;i<=n;i++) {
			list[i]=new LinkedList<>();
		}
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			int g= Integer.parseInt(st.nextToken());
			list[s].add(g);
			arr[g]++;
		}
		for(int i=1;i<=n;i++) {
			if(arr[i]==0)
				q.add(i);
		}
		while(!q.isEmpty()) {
			int tmp = q.poll();
			bw.write(tmp+" ");
			arr[tmp]--;
			for(int num:list[tmp]) {
				arr[num]--;
				if(arr[num]==0)
					q.add(num);
			}
		}
		bw.close();
		br.close();
		
		
		
		
	}
	

}