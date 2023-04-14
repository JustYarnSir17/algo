class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int size= common.length;
        int [] d= new int [size-1];
        for(int i=0;i<size-1;i++){
            d[i]=common[i+1]-common[i];
        }
        int dif=0;
        if(d[0]==d[1])
            answer= common[size-1]+d[0];
        else{
            dif=d[1]/d[0];    
            answer = common[size-1]*dif;
            
        }
        
        return answer;
    }
}