import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        int [] arr= new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i]=tmp;
        }
        Arrays.sort(arr);
        int x= Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum= arr[i]+arr[j];
                if(sum==x){
                    ++cnt;
                }
                if(sum>x){
                    break;
                }
            }
            if(arr[i]>=x){
                break;
            }
        }

        bw.write(cnt+"");
        br.close();
        bw.close();

    }
}