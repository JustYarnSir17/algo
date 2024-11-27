import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        boolean isHead =false;
        int[]head=new int [2];
        int[]heart = new int[2];
        int[] waistEnd = new int[2];
        char[][] arr = new char[n][n];
        int leftHand=0,rightHand=0,waist=0,leftFoot=0,rightFoot=0;
        
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	for(int j=0;j<n;j++) {
        		arr[i][j]=str.charAt(j);
        		if(arr[i][j]=='*') {
        			if(!isHead) {
        				isHead=true;
        				head[0]=i;
        				head[1]=j;
        				heart[0]=i+1;
        				heart[1]=j;
        			}
        		}
        	}
        }
        int cnt=0;
        for(int i=0;i<n;i++) {
        	if(i==heart[1]) {
        		leftHand=cnt;
        		cnt=0;
        		continue;
        	}
        	if(arr[heart[0]][i]=='*') {
        		cnt++;
        	}
        	
        }
        rightHand=cnt;
        cnt=0;
        for(int i=heart[0]+1;i<n;i++) {
        	if(arr[i][heart[1]]=='*') {
        		cnt++;
        	}
        	else {
        		waist=cnt;
        		waistEnd[0]=i-1;
        		waistEnd[1]=heart[1];
        		cnt=0;
        		break;
        	}
        }
        for(int i=waistEnd[0]+1;i<n;i++) {
        	if(arr[i][waistEnd[1]-1]=='*') {
        		cnt++;
        	}
        	else {
        		break;
        	}
        }
        leftFoot=cnt;
        cnt=0;
        for(int i=waistEnd[0]+1;i<n;i++) {
        	if(arr[i][waistEnd[1]+1]=='*') {
        		cnt++;
        	}
        	else {
        		break;
        	}
        }
        rightFoot=cnt;
        cnt=0;
        bw.write((heart[0]+1)+" "+(heart[1]+1)+"\n");
        bw.write(leftHand+" "+rightHand+" "+waist+" "+leftFoot+" "+rightFoot);
        bw.close();
        br.close();
        
        
    }
    
    
}