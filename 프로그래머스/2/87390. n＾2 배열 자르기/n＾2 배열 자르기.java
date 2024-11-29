import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int diff = (int)(right - left + 1);  // diff는 배열 크기
        int[] answer = new int[diff];
        
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n);  // i의 행 번호 (0-based index)
            int col = (int)(i % n);  // i의 열 번호 (0-based index)
            answer[(int)(i - left)] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}