import  java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(m==0&&n==0) {
				break;
			}
			int count=0;
			int sum=0;
			int [] arr= new int[m];
			for(int i=0;i<m;i++) {
				arr[i]=i;
			}
			List<Edge> list = new ArrayList<>();
			for(int i =0 ;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int z=Integer.parseInt(st.nextToken());
				sum+=z;
				list.add(new Edge(x,y,z));
			}
			Collections.sort(list,new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					
					return o1.z-o2.z;
				}
			});
			
			for(int i=0;i<list.size();i++) {
				int x=list.get(i).x;
				int y=list.get(i).y;
				int z=list.get(i).z;
				if(find(arr,x,y)) {
					continue;
				}
				else {
					union(arr,x,y);
					count+=z;
				}
			}
			bw.write(sum-count+"");
			bw.newLine();
		}
		bw.close();
		br.close();
	}
	
	public static int getP(int [] arr, int a) {
		if(arr[a]==a) {
			return a;
		}
		return arr[a]=getP(arr,arr[a]);
	}
	
	public static void union(int [] arr ,int a,int b) {
		a=getP(arr,a);
		b=getP(arr,b);
		
		if(a<b) arr[b]=a;
		else arr[a]=b;
	}
	
	public static boolean find(int [] arr, int a, int b) {
		a=getP(arr,a);
		b=getP(arr,b);
		if(a==b) return true;
		else return false;
	}
	
}

class Edge{
	int x;
	int y;
	int z;
	Edge(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}