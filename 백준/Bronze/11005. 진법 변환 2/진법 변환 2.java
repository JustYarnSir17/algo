import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int rest=0;
        String str = "";
        while(n>=b){
            rest = n%b;
            n/=b;

            if(rest>=10){
                char tmp ='A';
                tmp +=rest-10;
                str +=tmp;
            }
            else{
                str+=rest;
            }

        }
        if(n>0){

            if(n>=10){
                char tmp = 'A';
                tmp +=n-10;
                str +=tmp;
            }
            else{
                str+=n;
            }
        }
        StringBuffer sb = new StringBuffer(str);
        bw.write(sb.reverse().toString());
        br.close();
        bw.close();

    }
}