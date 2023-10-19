class Solution {
    static int dr[] = {-1,-1,-1,0,0,0,1,1,1};
    static int dc[] = {-1,0,1,-1,0,1,-1,0,1};
    static int N;
    static boolean v[][];
    static int answer;
    public int solution(int[][] board) {
        int n =board.length;
        N=n;
        answer = n*n;
        v=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    find(i,j);
                }
            }
            
        }
        
        
        return answer;
    }
    public void find(int r,int c){
        for(int i=0;i<9;i++){
            int nr = r+dr[i];
            int nc= c+dc[i];
            if(nr>=0&&nr<N&&nc>=0&&nc<N){
                if(v[nr][nc]==false){
                    --answer;
                    v[nr][nc]=true;
                    
                }
            }
        }
    }
}