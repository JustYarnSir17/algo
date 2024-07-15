import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int n=Integer.parseInt(br.readLine());
        double [][]ver=new double[n][2];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int tmp1=Integer.parseInt(st.nextToken());
        	int tmp2=Integer.parseInt(st.nextToken());
        	ver[i][0]=tmp1;
        	ver[i][1]=tmp2;
        }
        double sum=0;
        for(int i=0;i<n;i++) {
        	double x1=ver[i][0];
        	double y1=ver[i][1];
        	double x2=ver[(i+1)%n][0];
        	double y2=ver[(i+1)%n][1];
        	sum+=x1*y2 -y1*x2;
        }
        sum=Math.abs(sum)/2;
        
        
        bw.write(String.format("%.1f",sum));
        bw.close();
        br.close();
        
    }
}