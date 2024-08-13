import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n]; // 플로이드 워셜 저장 배열
        int[] cnt = new int[n * n]; // 지나온 경로 갯수 저장 배열
        StringBuilder[] sb = new StringBuilder[n * n]; // 지나온 경로 저장 StringBuilder 배열
        
        for (int i = 0; i < n * n; i++) {
            sb[i] = new StringBuilder();
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], 10000001);
            arr[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (arr[a][b] > c) { // 주어진 경로가 저장된 경로 보다 빠를 경우
                arr[a][b] = c;
                sb[a * n + b] = new StringBuilder(); // 초기화
                sb[a * n + b].append(String.valueOf(a + 1) + " " + String.valueOf(b + 1)); // 해당 경로 재 저장
                cnt[a * n + b] = 2; // 기본 2개 도시 저장
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) { // 최단 경로 발견하면
                        arr[i][j] = arr[i][k] + arr[k][j]; // 최단 경로 코스트 저장
                        cnt[i * n + j] = cnt[i * n + k] + cnt[k * n + j] - 1; // 최단 경로 갯수 저장
                        String str1 = sb[i * n + k].toString(); // 중간 지점까지의 경로 저장 배열 문자열화
                        String str2 = sb[k * n + j].toString(); // 중간 지점으로부터의 경로 저장 배열 문자열화
                        sb[i * n + j] = new StringBuilder(str1 + " " + str2.substring(str2.indexOf(" ") + 1)); // 중간 지점 연결
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 10000001) {
                    arr[i][j] = 0;
                }
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 || i == j) { // 경로가 없거나 자기 자신으로 가는 경우
                    bw.write("0\n");
                } else {
                    bw.write(cnt[i * n + j] + " " + sb[i * n + j].toString() + "\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}