import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(st.nextToken())-1;
        int t =Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());
        int p =Integer.parseInt(st.nextToken());
        
        int answer= (n/t)*c*p;
        bw.write(answer+"");
        bw.close();
        br.close();
	}
	
}