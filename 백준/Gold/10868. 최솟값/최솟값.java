import java.io.*;
import java.util.*;

public class Main {
	static int [] tree;
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st =new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        
        int [] arr = new int [n+1];
        for(int i=1;i<=n;i++) {
        	int tmp =Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        
        segment(arr);
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b= Integer.parseInt(st.nextToken());
        	bw.write(find(a,b)+"\n");
        }
        bw.close();
        br.close();
    }
    
    public static void segment(int [] arr) {
    	tree = new int[4*n];
    	build(arr,1,1,n);
    	//1 based indexing // 0 based indexing 보다 직관적이고 
    	//0 based indexing와 달리 비어있는 인덱스가 없다.
    	//(0 based indexing은 2*node 인덱스는 비어있다.
    }
     
    public static void build(int [] arr, int node, int start, int end) {
    	if(start==end) { // 단일 요소, 즉 리프 노드
    		tree[node]=arr[start];
    	}
    	else {// 단일 요소가 아닐 경우, 즉 start부터 end 구간
    		int mid = (start+end)/2;
    		int leftChild= 2*node;
    		int rightChild= 2*node+1;
    		build(arr,leftChild,start,mid);//좌측 리프노드 까지의 재귀
    		build(arr,rightChild,mid+1,end);//우측 리프노드 까지의 재귀
    		//리프노트부터 start부터 end까지의 구간합을 저장하는 코드
    		tree[node]=Math.min(tree[leftChild],tree[rightChild]);
    	}
    }
    
    public static int find(int l,int r) {//조회
    	return find(1,1,n,l,r);
    	//1based indexing
    }
    
    public static int find(int node, int start, int end, int l, int r) {
    	if(r<start||end<l) {//만약 구간이 넘어선다면
    		return Integer.MAX_VALUE;//셀 수 없이 큰 수 반환
    	}
    	if(l<=start&&end<=r) {//만약 주어진 구간 l부터 r이 start와 end구간을 포함한다면
    		return tree[node];
    		//해당 노드를 반환
    	}
    	
    	int mid = (start+end)/2;
    	int leftChild = node*2;
    	int rightChild = node*2+1;
    	
    	int left = find(leftChild,start,mid,l,r);
    	//좌측 서브트리 재귀를 통해 할당받은 값 할당
    	int right = find(rightChild,mid+1,end,l,r);
    	//우측 서브트리 재귀를 통해 할당받은 값 할당
    	
    	return Math.min(left,right);
    	//해당 노드, 즉 l부터 r까지의 구간 최솟값을 나타내는 
    	//node 위치는 left와 right 사이의 최솟값
    	
    }
}