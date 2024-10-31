import java.io.*;
import java.util.*;


public class Main {
	static int [][] board;
	static int N,M,maxScore=0;
	static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        board= new int[N][M];
        
        for(int i=0;i<N;i++) {
        	st= new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		board[i][j]=Integer.parseInt(st.nextToken());
        		
        	}
        }
        backtrack(0,0);
        
        bw.write(maxScore+"");
        bw.close();
        br.close();
    }

    private static void backtrack(int count, int currentScore) {
        if (count == 3) {  // 3번 눌렀을 때 최대 점수 갱신
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        int[][] originalBoard = copyBoard();  // 원본 보드 저장
        
        boolean hasMoves = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    hasMoves = true; // 남은 조각이 있어야 선택 가능
                    List<int[]> group = new ArrayList<>();
                    int piece = board[i][j];
                    findGroup(i, j, piece, group, new boolean[N][M]);
                    
                    int score = group.size() * group.size();
                    for (int[] cell : group) {
                        board[cell[0]][cell[1]] = 0;
                    }
                    applyGravity();
                    
                    backtrack(count + 1, currentScore + score);
                    
                    restoreBoard(originalBoard);
                }
            }
        }
        
        // 만약 남은 선택 기회가 있지만, 모든 조각이 이미 제거된 경우
        if (!hasMoves) {
            maxScore = Math.max(maxScore, currentScore);
        }
    }

    private static void findGroup(int x, int y, int piece, List<int[]> group, boolean[][] visited) {
        visited[x][y] = true;
        group.add(new int[]{x, y});
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] == piece) {
                findGroup(nx, ny, piece, group, visited);
            }
        }
    }

    private static void applyGravity() {
        if (N == 1) return;
        
        for (int col = 0; col < M; col++) {
            int emptyRow = N - 1;
            for (int row = N - 1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    board[emptyRow][col] = board[row][col];
                    if (emptyRow != row) {
                        board[row][col] = 0;
                    }
                    emptyRow--;
                }
            }
        }
    }

    private static int[][] copyBoard() {
        int[][] newBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, M);
        }
        return newBoard;
    }

    private static void restoreBoard(int[][] originalBoard) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(originalBoard[i], 0, board[i], 0, M);
        }
    }
}