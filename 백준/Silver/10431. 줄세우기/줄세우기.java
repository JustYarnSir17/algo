import java.util.*;
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int p =Integer.parseInt(br.readLine());
		for(int time=0;time<p;time++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int t=Integer.parseInt(st.nextToken());
			int [] heights = new int[21];
			for(int i=0;i<20;i++) {
				int tmp =Integer.parseInt(st.nextToken());
				heights[i]=tmp;
			}
			int movements = 0;
            for (int i = 1; i < 20; i++) {
                int key = heights[i];
                int j = i - 1;

                // 삽입 정렬을 이용해 현재 위치에서 앞의 정렬된 부분과 비교해가며 자리를 찾음
                while (j >= 0 && heights[j] > key) {
                    heights[j + 1] = heights[j];
                    j--;
                    movements++; // 움직임 카운트
                }
                heights[j + 1] = key;
            }
			bw.write(t+" "+movements+"\n");
		}
		bw.close();
		br.close();
	}
}