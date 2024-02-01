import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            int m = Math.max(a,b);
            m=Math.max(m,c);

            if(a==0||b==0||c==0){
                break;
            }
            if(m>=(a+b+c-m)){
                bw.write("Invalid\n");
                continue;
            }
            if(a==b&&b==c){
                bw.write("Equilateral\n");
            }
            else if(a!=b&&a!=c&&b!=c){
                bw.write("Scalene\n");
            }
            else{
                bw.write("Isosceles\n");
            }
        }

        br.close();
        bw.close();

    }
}