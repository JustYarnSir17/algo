import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [][]arr = new int [n][3];
        for(int i =0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<3;j++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr[i][j]=tmp;
        	}
        }
        int [][] d1=new int [n][3];
        int [][] d2=new int [n][3];
        int [][] d3= new int [n][3];
        d1[0][0]=arr[0][0];
        d1[0][1]=1000001;
        d1[0][2]=1000001;
        d2[0][0]=1000001;
        d2[0][1]=arr[0][1];
        d2[0][2]=1000001;
        d3[0][0]=1000001;
        d3[0][1]=1000001;
        d3[0][2]=arr[0][2];
        for(int i=1;i<n;i++) {
        	for(int j=0;j<3;j++) {
        		if(j==0) {
        			d1[i][j]=Math.min(d1[i-1][j+1]+arr[i][j],d1[i-1][j+2]+arr[i][j]);
        			d2[i][j]=Math.min(d2[i-1][j+1]+arr[i][j],d2[i-1][j+2]+arr[i][j]);
        			d3[i][j]=Math.min(d3[i-1][j+1]+arr[i][j],d3[i-1][j+2]+arr[i][j]);
        		}
        		else if(j==1) {
        			d1[i][j]=Math.min(d1[i-1][j-1]+arr[i][j],d1[i-1][j+1]+arr[i][j]);
        			d2[i][j]=Math.min(d2[i-1][j-1]+arr[i][j],d2[i-1][j+1]+arr[i][j]);
        			d3[i][j]=Math.min(d3[i-1][j-1]+arr[i][j],d3[i-1][j+1]+arr[i][j]);
        		}
        		else {
        			d1[i][j]=Math.min(d1[i-1][j-1]+arr[i][j],d1[i-1][j-2]+arr[i][j]);
        			d2[i][j]=Math.min(d2[i-1][j-1]+arr[i][j],d2[i-1][j-2]+arr[i][j]);
        			d3[i][j]=Math.min(d3[i-1][j-1]+arr[i][j],d3[i-1][j-2]+arr[i][j]);
        		}
        	}
        }
        int min = 1000001;
        for(int i=0;i<3;i++) {
        	if(i==0) {
        		min =Math.min(d2[n-1][i],min);
        		min =Math.min(d3[n-1][i],min);
        		
        	}
        	else if(i==1) {
        		min =Math.min(d1[n-1][i],min);
        		min =Math.min(d3[n-1][i],min);
        	}
        	else {
        		min =Math.min(d2[n-1][i],min);
        		min =Math.min(d1[n-1][i],min);
        	}
        }
        bw.write(String.valueOf(min));
        bw.close();
        br.close();
    }
}