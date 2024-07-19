import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[] item = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 거리 배열 설정 (무한대 값으로 초기화)
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], 1000000); // 큰 값으로 초기화
            arr[i][i] = 0; // 자기 자신으로의 경로는 0으로 초기화
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            arr[a][b] = cost;
            arr[b][a] = cost;
        }

        // 플로이드-워셜 알고리즘 적용
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int tmpSum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= m) {
                    tmpSum += item[j];
                }
            }
            maxSum = Math.max(maxSum, tmpSum);
        }

        bw.write(maxSum + "\n");
        bw.close();
        br.close();
    }
}