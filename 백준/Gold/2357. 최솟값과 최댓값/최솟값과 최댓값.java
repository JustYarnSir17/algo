import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
	static int[][] tree;//최댓값과 최솟값 저장
	static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int [] arr= new int [n+1];
        for(int i=1;i<=n;i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        
        segmentTree(arr);
        for(int i=0;i<m;i++) {
        	st= new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b= Integer.parseInt(st.nextToken());
        	int [] tmp =new int[2];
        	tmp = find(a,b);
        	bw.write(tmp[0]+" "+tmp[1]+"\n");
        }
        bw.close();
        br.close();
    }
    
    public static void segmentTree(int [] arr) {
    	tree= new int[4*n][2];
    	build(arr,1,1,n);// 1 based indexing
    }
    
    public static void build(int [] arr, int node, int start,int end) {
    	if(start==end) {//단일 요소일 경우
    		tree[node][0]=arr[start];//리프 노드는 모두 주어진 값 할당
    		tree[node][1]=arr[start];
    	}
    	else {
    		int mid= (start+end)/2;
    		int leftChild = node*2;
    		int rightChild = node*2+1;
    		build(arr, leftChild,start,mid);
    		build(arr, rightChild,mid+1,end);
    		tree[node][0]=Math.min(tree[leftChild][0],tree[rightChild][0]);// 0번 인덱스에는 최솟값
    		tree[node][1]=Math.max(tree[leftChild][1],tree[rightChild][1]);// 1번 인덱스에는 최댓값
    	}
    }
    
    public static int[] find(int l,int r) {
    	int [] tmp =new int[2];
    	tmp=find(1,1,n,l,r);
    	return tmp;
    }
    
    public static int [] find(int node, int start, int end, int l, int r) {
    	if(r<start||end<l) {//주어진 구간을 벗어나는 경우
    		int []tmp = {Integer.MAX_VALUE,0};
    		return tmp;
    	}
    	
    	if(l<=start&&end<=r) {
    		return tree[node];
    	}
    	int mid =(start+end)/2;
    	int leftChild = node*2;
    	int rightChild = node*2+1;
    	
    	int [] left = find(leftChild, start, mid ,l,r);
    	int [] right = find(rightChild,mid+1,end,l,r);
    	int [] tmp=new int[2];
    	tmp[0]=Math.min(left[0],right[0]);
    	tmp[1]=Math.max(left[1],right[1]);
    	return tmp;
    }
}