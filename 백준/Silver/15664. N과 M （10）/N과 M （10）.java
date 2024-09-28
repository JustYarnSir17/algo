import java.io.*;
import java.util.*;


public class Main {
	static int n,m;
	static int arr[];
	static HashSet<String>set = new LinkedHashSet<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int [n];
        for(int i=0;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	arr[i]=tmp;
        }
        Arrays.sort(arr);
        find(0,"",0);
        for(String str:set) {
        	bw.write(str+"\n");
        }
        bw.close();
        br.close();
        
	}
	
	public static void find(int idx, String str, int size) {
		if(size==m) {
			if(!set.contains(str)) {
				set.add(str);
				return;
			}
		}
		
		for(int i=idx;i<n;i++) {
			StringBuilder sb= new StringBuilder(str);
			find(i+1,sb.append(arr[i]+" ").toString(),size+1);
			
		}
	}
}