import java.io.*;
import java.util.*;


public class Main {
	static int n;
    static int[][] arr;
    static boolean[] v; // 방문 배열로 팀 구분
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        v = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        find(0, 0);
        System.out.println(diff);
    }

    public static void find(int idx, int cnt) {
        // 팀을 모두 나눴을 때
        if (cnt == n / 2) {
            calculate();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!v[i]) {
                v[i] = true; // 첫 번째 팀에 포함
                find(i + 1, cnt + 1); // 다음 멤버 탐색
                v[i] = false; // 백트래킹
            }
        }
    }

    public static void calculate() {
        int teamStart = 0; // 첫 번째 팀 점수
        int teamLink = 0;  // 두 번째 팀 점수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i] && v[j]) { // 첫 번째 팀
                    teamStart += arr[i][j];
                } else if (!v[i] && !v[j]) { // 두 번째 팀
                    teamLink += arr[i][j];
                }
            }
        }

        diff = Math.min(diff, Math.abs(teamStart - teamLink));
    }
}