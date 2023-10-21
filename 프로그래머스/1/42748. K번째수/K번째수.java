import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int n = commands.length;
        int[] answer = new int [n];
        int num=0;
        for(int i=0;i<n;i++){
            int j = commands[i][0]-1;
            int k = commands[i][1]-1;
            int [] arr = new int [k-j+1];
            int idx=0;
            for(;j<=k;j++){
                arr[idx++]=array[j];
            }
            Arrays.sort(arr);
            answer[num++]= arr[commands[i][2]-1];
        }
        return answer;
    }
}