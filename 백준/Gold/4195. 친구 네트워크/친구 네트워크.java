import java.io.*;
import java.util.*;

public class Main {
    static int [] friends;
    static int [] size;
    static HashMap<String,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int time=0; time<T; time++) {
            int f = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            friends = new int[f*2];
            size = new int[f*2];
            
            for(int i=0; i<friends.length; i++) {
                friends[i] = i;
                size[i] = 1; // 초기 사이즈는 1
            }

            int idx = 0;

            for(int i=0; i<f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                int idx1 = map.get(a);
                int idx2 = map.get(b);

                int root1 = find(idx1);
                int root2 = find(idx2);

                if(root1 != root2) {
                    union(root1, root2);
                }

                bw.write(size[find(root1)] + "\n");
            }
        }
        bw.close();
        br.close();
    }

    public static int find(int a) {
        if(friends[a] != a) {
            friends[a] = find(friends[a]); // 경로 압축
        }
        return friends[a];
    }

    public static void union(int a, int b) {
        if(a != b) {
            friends[b] = a;
            size[a] += size[b]; // 집합의 크기를 합산
        }
    }
}