import java.util.*;
class Solution {
    static String[] Words;
    static String Begin, Target;
    static int Cnt=0;
    static Queue<Pair> q= new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Words=words.clone();
        Begin=begin;
        Target=target;
        boolean tr= false;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i]))
                tr=true;
        }
        if(!tr){
            return 0;
        }
        find();
        answer=Cnt;
        
        return answer;
    }
    public void find(){
        q.add(new Pair(Begin,0));
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            
            for(int i=0;i<Words.length;i++){
                int cnt=0;
                for(int j =0;j<Words[i].length();j++){
                    if(tmp.word.charAt(j)!=Words[i].charAt(j)){
                        ++cnt;
                    }
                }
                if(cnt==1){
                    if(Words[i].equals(Target)){
                        Cnt=tmp.time+1;
                        return;
                    }
                    q.add(new Pair(Words[i],tmp.time+1));
                }
            }
        }
    }
}
class Pair{
    String word;
    int time;
    Pair(String word,int time){
        this.word=word;
        this.time=time;
    }
}