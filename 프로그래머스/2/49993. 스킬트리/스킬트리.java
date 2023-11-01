import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<skill.length();i++){
            map.put(skill.charAt(i),i);
        }
        boolean tr= true;
        for(int i=0;i<skill_trees.length;i++){
            int idx=0;
            tr=true;
            for(int j=0;j<skill_trees[i].length();j++){
                if(map.containsKey(skill_trees[i].charAt(j))){
                    if(idx==map.get(skill_trees[i].charAt(j))){
                        idx++;
                    }
                    else{
                        tr=false;
                        break;
                    }
                }
            }
            if(tr)
                answer++;
        }
        
        return answer;
    }
}