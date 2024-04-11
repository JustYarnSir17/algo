class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        int l=0;
        int cnt=0;
        while(true){
            ++cnt;
            String str= "";
            for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                ++answer[1];
                continue;
                }
                else
                    str+='1';
            }
            l=str.length();
            s=Integer.toBinaryString(l);
            if(s.equals("1")){
                answer[0]=cnt;
                break;
            }
        }
        
        return answer;
    }
}