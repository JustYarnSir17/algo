import java.util.*;
class Solution {
    static List<Integer> list = new ArrayList<>();
    static int[][] arr;
    static boolean [][] v;
    static int R,C;
    static int [] dr = {0,1,0,-1};
    static int [] dc = {1,0,-1,0};
    static Stack<Node> stack = new Stack<>();
    
    public void dfs(int num,Node node){
        stack.push(node);
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            num+=arr[tmp.r][tmp.c];
            v[tmp.r][tmp.c] = true;
            for(int i=0;i<4;i++){
                int nr= tmp.r+dr[i];
                int nc= tmp.c+dc[i];
                if(nr>=0&&nr<R&&nc>=0&&nc<C){
                    if(arr[nr][nc]!=-1&&v[nr][nc]==false){
                        v[nr][nc]=true;
                        stack.push(new Node(nr,nc));
                        
                        
                    }
                }
                
            }
        }
        list.add(num);
    }
    public int[] solution(String[] maps) {
        //bfs 또는 dfs로 풀기
        R=maps.length;
        C=maps[0].length();
        v= new boolean[R][C];
        arr = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(maps[i].charAt(j)=='X'){
                    arr[i][j]=-1;
                }
                else{
                    arr[i][j]=maps[i].charAt(j)-'0';
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]!=-1&&v[i][j]==false){
                    dfs(0,new Node(i,j));
                }
            }
        }
        int[] answer;
        Collections.sort(list);
        if(list.size()==0){
            answer = new int[1];
            answer[0]=-1;
        }else{
            answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        }
        
        return answer;
    }
}
class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r=r;
        this.c=c;
    }
}