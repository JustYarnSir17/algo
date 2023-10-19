import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char [] arr = new char [s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        int [] arr2 = new int [arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i]=(int)arr[i];
        }
        Arrays.sort(arr2);
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=(char)arr2[i];
            answer+=arr[i];
        }
        return answer;
    }
}