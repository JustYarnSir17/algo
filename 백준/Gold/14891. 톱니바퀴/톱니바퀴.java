import java.io.*;
import java.util.*;


public class Main {
	static int[][]arr = new int[4][8];//12시부터 순서대로 저장 0은 N극, 1은 S극
	static int [] idx=new int [4];//12시 방향 표시 인덱스 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i=0;i<4;i++) {
        	String str = br.readLine();
        	for(int j=0;j<8;j++) {
        		int tmp =str.charAt(j)-'0';
        		arr[i][j]=tmp;
        	}
        }
        int k=Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int num=Integer.parseInt(st.nextToken())-1;
        	int dir = Integer.parseInt(st.nextToken());
        	int tmp =idx[num];
        	right(num,dir);
        	idx[num]=tmp;
        	left(num,dir);

        }
        int sum=0;
        for(int i=0;i<4;i++) {
        	sum+=arr[i][idx[i]]*Math.pow(2,i);
        }
        bw.write(sum+"");
        bw.close();
        br.close();
    }
    
    public static void right(int num, int dir) {
    	//맞닿은 부분은 2번, 6번 인덱스 
    	
    	if(num<3) {
    		int myIdx = (idx[num]+2)%8;
        	int rightIdx= (idx[num+1]+6)%8;
        	if(dir==1) {//시계방향
        		if(arr[num][myIdx]!=arr[num+1][rightIdx]) {
        			right(num+1,-1);
        		}
        	}
        	else {//반시계방향
        		if(arr[num][myIdx]!=arr[num+1][rightIdx]) {
        			right(num+1,1);
        		}
        	}
    	}
    	if(dir==1) {
			idx[num]=idx[num]-1<0?7:idx[num]-1;//시계방향으로 돌아가니 -1
		}
		else {
			idx[num]=idx[num]+1>=8?0:idx[num]+1;//반시계방향으로 돌아가니
		}
    	
    }
    
    public static void left(int num,int dir) {
    	//맞닿은 부분은 2번, 6번 인덱스 
    	
    	if(num>0) {
    		int myIdx = (idx[num]+6)%8;
        	int leftIdx= (idx[num-1]+2)%8;
        	if(dir==1) {//시계방향
        		if(arr[num][myIdx]!=arr[num-1][leftIdx]) {
        			left(num-1,-1);
        		}
        	}
        	else {//반시계방향
        		if(arr[num][myIdx]!=arr[num-1][leftIdx]) {
        			left(num-1,1);
        		}
        	}
    	}
    	if(dir==1) {
			idx[num]=idx[num]-1<0?7:idx[num]-1;//시계방향으로 돌아가니 
		}
		else {
			idx[num]=idx[num]+1>=8?0:idx[num]+1;//반시계방향으로 돌아가니
		}
    }
}