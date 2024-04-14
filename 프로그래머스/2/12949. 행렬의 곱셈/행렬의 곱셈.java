class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr2[0].length];
        
        for(int i=0;i<arr1.length;i++){
            
            for(int idx=0;idx<arr2[0].length;idx++){
                int tmp =0;
                for(int j=0;j<arr1[i].length;j++){
                tmp+=arr1[i][j]*arr2[j][idx];
            }
                
            answer[i][idx]=tmp;
            }
            
        }
        
        return answer;
    }
}