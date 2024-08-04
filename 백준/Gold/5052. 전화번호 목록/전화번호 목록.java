import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int Time = 0; Time < T; Time++) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }
            
            // 전화번호를 사전순으로 정렬
            Arrays.sort(numbers);
            
            boolean isConsistent = true;
            for (int i = 0; i < n - 1; i++) {
                // 인접한 두 전화번호가 접두사 관계인지 확인
                if (numbers[i + 1].startsWith(numbers[i])) {//startWith는 특정 문자로 시작하는지 체크하는 매서드
                    isConsistent = false;
                    break;
                }
            }
            
            if (isConsistent) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.close();
        br.close();
    }
}