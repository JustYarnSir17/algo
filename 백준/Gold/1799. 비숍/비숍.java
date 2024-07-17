import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int count = 0;
    static boolean [] digit1;//우상향
    static boolean [] digit2;//좌상향
    static int maxB=0;
    static int maxW=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

       n =Integer.parseInt(br.readLine());
       arr=new int  [n][n];
       digit1=new boolean[n*2];
       digit2=new boolean[n*2];
       for(int i=0;i<n;i++) {
    	   StringTokenizer st= new StringTokenizer(br.readLine());
    	   
    	   for(int j=0;j<n;j++) {
    		   int tmp = Integer.parseInt(st.nextToken());
    		   arr[i][j]=tmp;
    	   }
       }
       findB(0,0,0);
       findW(0,1,0);
       bw.write(maxB+maxW+"");
       bw.close();
       br.close();
    }

    public static void findB(int r,int c, int cnt) {
    	if(c>=n) {
    		r++;
    		if(r>=n) {
    			maxB=Math.max(cnt,maxB);
    			return;
    		}
    		c=(r%2)==1?1:0;
    	}
    	if(arr[r][c]==1&&!digit1[r+c]&&!digit2[r-c+n]) {
    		digit1[r+c]=true;
    		digit2[r-c+n]=true;
    		findB(r,c+2,cnt+1);
    		digit1[r+c]=false;
    		digit2[r-c+n]=false;
    	}
    	findB(r,c+2,cnt);
    }
    public static void findW(int r,int c, int cnt) {
    	if(c>=n) {
    		r++;
    		if(r>=n) {
    			maxW=Math.max(cnt,maxW);
    			return;
    		}
    		c=(r%2)==1?0:1;
    	}
    	if(arr[r][c]==1&&!digit1[r+c]&&!digit2[r-c+n]) {
    		digit1[r+c]=true;
    		digit2[r-c+n]=true;
    		findW(r,c+2,cnt+1);
    		digit1[r+c]=false;
    		digit2[r-c+n]=false;
    	}
    	findW(r,c+2,cnt);
    }

}