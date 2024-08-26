import java.io.*;
import java.util.*;

public class Main {
    static boolean [] truth;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        truth = new boolean[n + 1];
        arr = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int tmp = Integer.parseInt(st.nextToken());
        if (tmp != 0) {
            for (int i = 0; i < tmp; i++) {
                int num = Integer.parseInt(st.nextToken());
                truth[num] = true;
            }
        }

        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);

            int people = Integer.parseInt(st.nextToken());
            int[] party = new int[people];
            for (int j = 0; j < people; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            for (int j = 1; j < people; j++) {
                union(party[0], party[j]);
            }
        }

        int cnt = 0;
        for (int[] party : parties) {
            boolean tr = false;
            for (int person : party) {
                if (truth[find(person)]) {
                    tr = true;
                    break;
                }
            }
            if (!tr) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.close();
        br.close();
    }

    public static int find(int a) {
        if (a != arr[a]) {
            arr[a] = find(arr[a]);
        }
        return arr[a];
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            arr[rootB] = rootA;
            truth[rootA] = truth[rootA] || truth[rootB];
        }
    }
}