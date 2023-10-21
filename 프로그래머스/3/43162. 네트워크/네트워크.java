import java.util.*;

class Solution {
    static boolean [] v;
    static List<Integer>[] list;
    
    public void dfs(int n){
        for(int i=0;i<list[n].size();i++){
            if(!v[list[n].get(i)]){
                v[list[n].get(i)]=true;
                dfs(list[n].get(i));
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new List[n];
        v=new boolean[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1&&i!=j){
                    list[i].add(j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(!v[i]){
            answer++;
            for(int j=0;j<list[i].size();j++){
                
                    
                    dfs(list[i].get(j));
                }
            }
        }
        
        
        return answer;
    }
}