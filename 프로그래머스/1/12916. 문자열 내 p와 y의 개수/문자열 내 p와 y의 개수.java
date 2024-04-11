import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) throws IOException{
        boolean answer = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int p=0;
        int y=0;
        s= s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp=='p'){
                ++p;
            }
            else if(tmp=='y'){
                ++y;
            }
        }
        if(p==y){
            return true;
        }
        else{
            return false;
        }
        

    }
}