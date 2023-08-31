import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        int [] point = new int [photo.length];
        for(int i=0;i<photo.length;i++){
            int tmp=0;
            for(int j=0;j<photo[i].length;j++){
                if(map.containsKey(photo[i][j])){
                    tmp+=map.get(photo[i][j]);
                }
            }
            point[i] = tmp;
        }
        
        int[] answer = point;
        return answer;
    }
}