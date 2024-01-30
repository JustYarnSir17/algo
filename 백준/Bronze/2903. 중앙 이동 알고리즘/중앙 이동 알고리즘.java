import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] arr = new int [26];
        arr[0]=2;
        int idx=1;
        for(int i=1;i<=25;i++){
            arr[i]=arr[i-1]+idx;
            idx*=2;

        }

        int n = Integer.parseInt(br.readLine());


        bw.write(arr[n]*arr[n]+"");
        br.close();
        bw.close();

    }
}