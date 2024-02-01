import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());
        int m =Math.max(a,b);
        int answer=0;
        m=Math.max(m,c);

        if(m<(a+b+c-m)){
            answer= a+b+c;
        }
        else{
            answer= a+b+c-(m-(a+b+c-m)+1);
        }
        bw.write(answer+"");
        br.close();
        bw.close();

    }
}