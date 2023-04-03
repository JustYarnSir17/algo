import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V,E;
	static LinkedList<Integer>list[];
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t=1;t<=10;t++) {
			bw.write("#"+t+" ");
			StringTokenizer st= new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			list=new LinkedList[V+1];
			for(int i=0;i<=V;i++) {
				list[i]=new LinkedList<>();
			}
			arr=new int [V+1];
			for(int i=0;i<E;i++) {
				int a=Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				list[a].add(b);
				arr[b]++;
			}
			Queue<Integer> q= new LinkedList<>();
			for(int i=1;i<=V;i++) {
				if(arr[i]==0)
					q.add(i);
			}
			while(!q.isEmpty()) {
				int tmp =q.poll();
				bw.write(tmp+" ");
				arr[tmp]--;
				for(int i=0;i<list[tmp].size();i++) {
					if(--arr[list[tmp].get(i)]==0) {
						q.add(list[tmp].get(i));
					}
				}
			}
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}