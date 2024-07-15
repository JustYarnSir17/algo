import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 두 번째 배열의 값들을 인덱스로 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr2[i], i);
        }

        // 첫 번째 배열의 값을 두 번째 배열의 인덱스로 변환
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr1[i])) {
                list.add(map.get(arr1[i]));
            }
        }

        // LIS 알고리즘 적용
        List<Integer> lis = new ArrayList<>();
        for (int value : list) {
            int pos = Collections.binarySearch(lis, value);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos < lis.size()) {
                lis.set(pos, value);
            } else {
                lis.add(value);
            }
        }

        // 결과 출력
        System.out.println(lis.size());
    }
}