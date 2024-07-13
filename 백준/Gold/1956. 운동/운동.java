import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int [][] arr = new int[v][v];
        int INF = 1000000000;  // 적당히 큰 값으로 초기화

        // 배열 초기화
        for (int i = 0; i < v; i++) {
            Arrays.fill(arr[i], INF);
        }

        // 간선 입력 및 최소 비용으로 업데이트
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }

        // 플로이드-와샬 알고리즘
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        // 최소 사이클 찾기
        int answer = INF;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i != j && arr[i][j] != INF && arr[j][i] != INF) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        if (answer == INF) {
            bw.write("-1\n");
        } else {
            bw.write(answer + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}