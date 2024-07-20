import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int [][] arr =  new int [n][n];
        for(int i=0;i<n;i++) {
        	Arrays.fill(arr[i],Integer.MAX_VALUE/2);
        	arr[i][i]=0;
        }
        List<Node> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int s=Integer.parseInt(st.nextToken());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	list.add(new Node(x,y,s));
        	
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int distance = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
                    if (list.get(i).s == 1 && list.get(j).s == 1) {
                        arr[i][j] = Math.min(distance, t);
                    } else {
                        arr[i][j] = distance;
                    }
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	bw.write(arr[a][b]+"\n");
        	
        }
        bw.close();
        br.close();
    }
}

class Node{
	int x;
	int y;
	int s;
	Node(int x,int y,int s){
		this.x=x;
		this.y=y;
		this.s=s;
	}

}