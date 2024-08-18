import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static String[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        int MAX = (int)Math.pow(2, n); // 트리의 최대 크기 설정
        arr = new String[MAX];
        arr[1] = "A";
        map.put("A", 1);
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            int idx = map.get(a);
            if (!b.equals(".")) {
                arr[idx * 2] = b;
                map.put(b, idx * 2);
            }
            if (!c.equals(".")) {
                arr[idx * 2 + 1] = c;
                map.put(c, idx * 2 + 1);
            }
        }
        
        // 전위 순회: 루트 - 좌측 - 우측
        sb = new StringBuilder();
        preorder(1);
        bw.write(sb.toString() + "\n");
        
        // 중위 순회: 좌측 - 루트 - 우측
        sb = new StringBuilder();
        inorder(1);
        bw.write(sb.toString() + "\n");
        
        // 후위 순회: 좌측 - 우측 - 루트
        sb = new StringBuilder();
        postorder(1);
        bw.write(sb.toString());
        
        bw.close();
        br.close();
    }
    
    public static void preorder(int idx) {
        if (idx >= arr.length || arr[idx] == null) return;
        sb.append(arr[idx]);
        preorder(idx * 2);
        preorder(idx * 2 + 1);
    }
    
    public static void inorder(int idx) {
        if (idx >= arr.length || arr[idx] == null) return;
        inorder(idx * 2);
        sb.append(arr[idx]);
        inorder(idx * 2 + 1);
    }
    
    public static void postorder(int idx) {
        if (idx >= arr.length || arr[idx] == null) return;
        postorder(idx * 2);
        postorder(idx * 2 + 1);
        sb.append(arr[idx]);
    }
}