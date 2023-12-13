class Solution {
    
     
    public int solution(String word) {
        int answer = 0;
        String [] arr = {"A","E","I","O","U"};
     int cnt =0;
     String str = "";
        loop:
        for(int i=0;i<5;i++){
            str=arr[i];
            ++cnt;
            if(str.equals(word)){
                return cnt;
            }
            for(int j=0;j<5;j++){
                str=arr[i]+arr[j];
                ++cnt;
                if(str.equals(word)){
                return cnt;
            }
                for(int k=0;k<5;k++){
                    str=arr[i]+arr[j]+arr[k];
                    ++cnt;
                    if(str.equals(word)){
                 return cnt;
            }
                    for(int l=0;l<5;l++){
                        str=arr[i]+arr[j]+arr[k]+arr[l];
                        ++cnt;
                        if(str.equals(word)){
                 return cnt;
            }
                        for(int m=0;m<5;m++){
                            str=arr[i]+arr[j]+arr[k]+arr[l]+arr[m];
                            ++cnt;
                            if(str.equals(word)){
                return cnt;
            }
                        }
                    }
                }
            }
        }
        answer=cnt;
        return answer;
    }
    
}
