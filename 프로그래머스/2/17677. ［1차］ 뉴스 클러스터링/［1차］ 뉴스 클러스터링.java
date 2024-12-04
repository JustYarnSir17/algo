import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();
        for(int i=0;i<str1.length()-1;i++){
            boolean tr =false;
            for(int j=0;j<2;j++){
                if(str1.charAt(i+j)<'A'||str1.charAt(i+j)>'Z'){
                    tr=true;
                    break;
                }
            }
            if(tr){
                continue;
            }
            String tmp = str1.substring(i,i+2);
            if(!set1.contains(tmp)){
                set1.add(tmp);
                map1.put(tmp,1);
            }
            else{
                map1.replace(tmp,map1.get(tmp)+1);
            }
            
        }
        
        for(int i=0;i<str2.length()-1;i++){
            boolean tr=false;
            for(int j=0;j<2;j++){
                if(str2.charAt(i+j)<'A'||str2.charAt(i+j)>'Z'){
                    tr=true;
                    break;
                }
            }
            if(tr){
                continue;
            }
            String tmp = str2.substring(i,i+2);
            if(!set2.contains(tmp)){
                set2.add(tmp);
                map2.put(tmp,1);
            }
            else{
                map2.replace(tmp,map2.get(tmp)+1);
            }
            
            
        }
        
        int cnt=0;
        int ref=0;
        
        for(String str:set1){
            ref+=map1.get(str);
        }
        for(String str:set2){
            if(map1.containsKey(str)){
                if(map1.get(str)<map2.get(str)){
                    ref-=map1.get(str);
                    ref+=map2.get(str);
                    cnt+=map1.get(str);
                }
                else{
                    cnt+=map2.get(str);
                }
            }
            else{
                ref+=map2.get(str);
            }
        }
        System.out.println(cnt+" "+ref);
        if(ref==0){
           answer= 65536;
        }
        else{
            answer= (int)Math.floor((double)cnt/(double)ref*65536);
        }
        return answer;
    }
}