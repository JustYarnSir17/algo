import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int INF= 10000001;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n]; // 플로이드 워셜 저
        int [][] next = new int[n][n];//경로 저장 배열
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		next[i][j]=j;//경로 초기화 (j까지의 경로를 j로 초기화)
        	}
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (arr[a][b] > c) { // 주어진 경로가 저장된 경로 보다 빠를 경우(주어지는 경로가 중복되어 들어올 경우 최단 경로로 갱신)
                arr[a][b] = c;
                
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) { // 최단 경로 발견하면
                        arr[i][j] = arr[i][k] + arr[k][j]; // 최단 경로 코스트 
                        next[i][j]=next[i][k];//i에서 j까지 가는 경로에 k가 존재한다는 걸 저장
                        
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(arr[i][j]==0||i==j) {//갈 수 있는 경로가 없거나 자기 자신일 경우 
        			bw.write("0\n");
        		}
        		else {//갈 수 있는 경로가 존재할 경우
        			List<Integer>list = new ArrayList<>();//경로 저장 리스트
        			int u=i;//u는 출발점 i로 초기화
        			list.add(u+1);
        			while(u!=j) {//u가 목적지 j가 아닐 경우
        				
        				u=next[u][j];//u를 u에서 j로 가는 경로로 변환. [x][j]는 모두 j로 초기화했기에 결국 j로 향하는 next[x][j]이기에 
        				//j로의 최단 경로를 모두 찾을 수 있다.
        				list.add(u+1);//u를 경로에 추가
        			}
        			bw.write(list.size()+" ");
        			for(int num:list) {
        				bw.write(num+" ");
        			}
        			bw.newLine();
        		}
        		
        	}
        }

        bw.close();
        br.close();
    }
}