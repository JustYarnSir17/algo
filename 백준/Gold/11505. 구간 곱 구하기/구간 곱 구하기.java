import java.io.*;
import java.util.*;

public class Main {
	static int [] tree;
	static int n;
	static int m;
	static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        int [] arr = new int [n];
        for(int i=0;i<n;i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[i]=tmp;
        }
        segment(arr);
        //node가 0부터 시작하는 건 0 based indexing
        for(int i=0;i<m+k;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a =Integer.parseInt(st.nextToken());
        	int b =Integer.parseInt(st.nextToken());
        	int c =Integer.parseInt(st.nextToken());
        	if(a==1) {
        		update(b-1,c);
        	}
        	else {
        		bw.write(find(b-1,c-1)+"\n");
        	}
        }
        
        bw.close();
        br.close();
        
        
    }
    
    public static void segment(int []arr) {
    	tree= new int[4*n];//최악의 경우 4*n
    	build(arr,0,0,n-1);// 세그먼트 트리 구성 매서드
    }
    
    public static void build(int [] arr, int node, int start, int end) {
    	if(start==end) {//만약 start와 end가 같으면, 즉 단일 요소인 경우
    		tree[node]=arr[start];//리프 노드 할당
    	}
    	else {//단일 요소가 아닌 경우, 재귀 매서드 사용
    		int mid = (start+end)/2;//좌 우 서브트리 기준
    		int leftChild = 2*node+1;//좌측 자식 인덱스
    		int rightChild = 2*node+2;//우측 자식 인덱스
    		build(arr,leftChild,start,mid);// 좌측 자식 노드 재귀
    		build(arr,rightChild,mid+1,end);//우측 자식 노드 재귀
    		long tmp = ((long)tree[leftChild]*(long)tree[rightChild])%1000000007;
    		tree[node]=(int)tmp;
    	}
    }
    
    public static void update(int idx, int value) {//수정
    	update(0,0,n-1,idx,value);
    }
    
    public static void update(int node, int start, int end, int idx, int value) {
    	if(start==end) {//만약 재귀를 통해서 start와 end가 같아진다면
    		tree[node]=value;//해당 노드 수정
    		return;//반환
    	}
    	int mid = (start+end)/2;
    	int leftChild = node*2+1;
    	int rightChild=node*2+2;
    	if(idx<=mid) {//수정할 곳이 중간값보다 작거나 같다면
    		update(leftChild,start,mid,idx,value);//좌측 서브트리 재귀
    	}
    	else {//반대면 
    		update(rightChild,mid+1,end,idx,value);//우측 서브트리 재귀
    	}
    	long tmp = ((long)tree[leftChild]*(long)tree[rightChild])%1000000007;
    	//갱신한 뒤 부모노드 구간 곱 갱신
    	tree[node]=(int)tmp;
    }
    
    public static int find(int l,int r) {//조회
    	return find(0,0,n-1,l,r); //l부터 r 구간 곱 조회
    }
    
    public static int find(int node, int start, int end, int l, int r) {
    	if(r<start||end<l) {//만약 r이 시작 인덱스보다 작거나 l이 끝 인덱스보다 크면 
    		//범위를 벗어나기 때문에 구간 곱 확인 x
    		return 1;
    	}
    	if(l<=start&&end<=r) {//만약 l이 start보다 작거나 같고, r이 end 보다 크거나 같다면
    		return tree[node];
    	}
    	
    	int mid = (start+end)/2;
    	int leftChild = 2*node+1;
    	int rightChild= 2*node+2;
    	
    	int left = find(leftChild,start,mid,l,r);//재귀를 통해서 좌측 서브트리 구간 곱 할당
    	int right = find(rightChild,mid+1,end,l,r);//재귀를 통해서 우측 서브트리 구간 곱 할당
    	
    	return(int)(((long)left*(long)right)%1000000007);
    	
    	
    }
    
    
    
    
}