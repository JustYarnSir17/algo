import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
        	int n=Integer.parseInt(br.readLine());
        	int [] last = new int [n];// 작년 순위
        	int [] in = new int[n+1];//진입 배열
        	boolean [][] arr = new boolean [n+1][n+1]; // 상대 순위 비교 
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0;i<n;i++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		last[i]=tmp;
        	}
        	for(int i=0;i<n;i++) {
        		for(int j=i+1;j<n;j++) {
        			arr[last[i]][last[j]]=true;//last[i]가 last[j]보다 우선한다.
        			in[last[j]]++; //따라서 last[j]의 진입 순번 증가 
        		}
        	}
        	int m=Integer.parseInt(br.readLine());
        	for(int i=0;i<m;i++) {
        		st= new StringTokenizer(br.readLine());
        		int a=Integer.parseInt(st.nextToken());
        		int b=Integer.parseInt(st.nextToken());
        		if(arr[a][b]) {//순서 변화
        			arr[a][b]=false;
        			arr[b][a]=true;
            		in[a]++;
            		in[b]--;
        		}
        		else {//순서 변화
        			arr[a][b]=true;
        			arr[b][a]=false;
        			in[a]--;
        			in[b]++;
        		}
        	}
        	boolean tr =true;
        	int[] result = new int [n];
        	int  idx=0;
        	Queue<Integer> q = new LinkedList<>();
        	for(int i=1;i<=n;i++) {
        		if(in[i]==0) {
        			q.offer(i);
        		}
        	}
        	for(int i=0;i<n;i++) {
        		if(q.isEmpty()) {
        			tr=false;
        			break;
        		}
        		if(q.size()>1) {
        			tr=false;
        			break;
        		}
        		int curr= q.poll();
        		result[idx++]=curr;
        		for(int j=1;j<=n;j++) {
        			if(arr[curr][j]) {
        				if(--in[j]==0) {
        					q.offer(j);
        				}
        				
        			}
        		}
        	}
        	if(!tr) {
        		bw.write("IMPOSSIBLE\n");
        	}
        	else {
        		for(int i=0;i<n;i++) {
        			bw.write(result[i]+" ");
        		}
        		bw.newLine();
        	}
        }
        bw.close();
        br.close();
    }
}