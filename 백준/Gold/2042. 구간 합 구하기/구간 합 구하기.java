import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Long.parseLong(br.readLine());
        }
        SegmentTree(arr);// 세그먼트 트리를 통해 구간합을 도출
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {//1일 경우 해당 인덱스 값 수정
                update(b - 1, c);  
            } else {//2일 경우 해당 구간 합
                bw.write(query(b - 1, (int)c - 1) + "\n");  
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void SegmentTree(long[] arr) {//세그먼트 트리 구현
        tree = new long[4 * n];//리프 노드의 경우 최대 2n-1개, 전체 세그먼트 트리의 경우 최악의 경우 4n까지 고려
        build(arr, 0, 0, n - 1);//세그먼트 트리 구현 매서드
    }

    public static void build(long[] arr, int node, int start, int end) {//세그먼트 트리 구현 매서드 (구간합)
        if (start == end) {//구간이 단일 요소일 경우, 즉 리프 노드일 경우
            tree[node] = arr[start];//해당 노드에 주어진 배열의 값을 저장
        } else {//단일 요소가 아닐 경우, 즉, 리프 노드가 아니라 부모 노드의 경우
            int mid = (start + end) / 2;// 중간 값을 할당
            int leftChild = node * 2 + 1;// 좌측 자식 인덱스
            int rightChild = node * 2 + 2;// 우측 자식 인덱스
            build(arr, leftChild, start, mid);// 좌측 자식 인덱스 재귀
            build(arr, rightChild, mid + 1, end);// 우측 자식 인덱스 재귀
            tree[node] = tree[leftChild] + tree[rightChild];// 양측 자식 인덱스를 매서드를 통해 저장 후 양 구간 합 저장
        }
        
        //재귀를 통해 리프 노드에 주어진 배열을 저장하고, 거슬러 올라가면서 양측 자식 값을 합하여 해당 구간 합을 저장
    }

    public static long query(int l, int r) {//구간 합 조회 매서드, 좌측 인덱스와 우측 인덱스
        return query(0, 0, n - 1, l, r);//주어진 인덱스를 포함하여 노드, 시작, 끝 인덱스를 활용할 조회 매서드
    }

    public static long query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {//만약 우측 인덱스가 시작 인덱스보다 작거나 좌측 인덱스가 끝 인덱스보다 크다면, 즉, 예외일 경우
            return 0;// 측정 x 값
        }
        if (l <= start && end <= r) {// 좌측 인덱스가 시작 인덱스보다 작거나 같고, 우측 인덱스가 끝 인덱스보다 크거나 같을 때, (재귀를 통해 값을 반환)    
            return tree[node];//해당 노드 값 반환
        }
        //그 외의 경우 ( 좌측 인덱스가 시작 인덱스보다 크거나 우측 인덱스가 끝 인덱스보다 작거나 둘 다 거나 )
        int mid = (start + end) / 2;//중간값 할당
        long left = query(2 * node + 1, start, mid, l, r); // 좌측 값은 좌측 자식 노드와 start,end 범위를 query 재귀를 통해 얻은 값
        long right = query(2 * node + 2, mid + 1, end, l, r);// 우측 값은 우측 자식 노드와 start, end 범위를 query 재귀를 통해 얻은 값
        return left + right; // 최종적으로 l과 r 범위의 구간 합을 반환
    }

    public static void update(int idx, long value) {// 주어진 인덱스에 해당 값으로 수정
        update(0, 0, n - 1, idx, value);//수정을 위한 재귀 매서드
    }

    public static void update(int node, int start, int end, int idx, long value) {// query와 같이 재귀를 위한 매서드
        if (start == end) {//만약 단일 요소 노드일경우, 즉 리프 노드일 경우
            tree[node] = value;//해당 값을 수정
        } else {//그렇지 않을 경우
            int mid = (start + end) / 2;// 중간 값 할당
            int leftChild = 2 * node + 1;//좌측 자식 노드 인덱스
            int rightChild = 2 * node + 2;//우측 자식 노드 인덱스
            if (idx <= mid) {//만약 수정하려는 인덱스가 mid보다 작을 경우
                update(leftChild, start, mid, idx, value);// 좌측 자식 노드를 재귀를 통해 수정
            } else {//mid 보다 클 경우
                update(rightChild, mid + 1, end, idx, value);//우측 자식 노드를 재귀를 통해 수정
            }
            tree[node] = tree[leftChild] + tree[rightChild];//수정한 후 부모 노드를 양측 자식 노드의 합으로 수정
        }
    }
}