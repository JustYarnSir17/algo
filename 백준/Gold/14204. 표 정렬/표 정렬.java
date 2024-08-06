import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int [][] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken()); 
        arr = new int[n][m];
        for(int i=0;i<n;i++) {
        	st= new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		int tmp = Integer.parseInt(st.nextToken())-1;
        		arr[i][j]=tmp;
        	}
        }
        
        if(find()) {
        	bw.write("1");
        }
        else {
        	bw.write("0");
        	
        }
        bw.close();
        br.close();
        
    }
    // 조건 1. 그 행에는 x부터 x+m의 수가 존재해야 한다.
    // 조건 2. 그 열에는 각 수의 차이가 m의 배수여야 한다.
    public static boolean find() {//정렬 가능한 지 찾는 매서드
    	for(int i=0;i<n;i++) {//그 행에 존재하는 수 비교
    		int tmp = arr[i][0]/m;//그 행의 수들이 해당 범위 내에 있는지 판단하기 위한 몫
    		
    		for(int j=1;j<m;j++) {
    			if(arr[i][j]<tmp*m||arr[i][j]>=(tmp+1)*m) {//만약 해당하는 수가 범위를 벗어나면 
    				return false;//false 리턴
    			}
    		}
    	}
    	
    	for(int i=0;i<m;i++) {//그 열에 존재하는 수 비교
    		for(int j=1;j<n;j++) {
    			if(Math.abs(arr[j][i]-arr[j-1][i])%m!=0) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
}