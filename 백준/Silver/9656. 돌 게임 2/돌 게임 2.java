import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] arr = new int [1001];//1은 상근, 2는 창영
        arr[1]=1;
        arr[3]=1;
        arr[2]=2;
        
        int n =Integer.parseInt(br.readLine());
        for(int i=4;i<=1000;i++) {
        	if(arr[i-1]==arr[i-3]&&arr[i-1]==1) {
        		arr[i]=2;
        	}
        	else {
        		arr[i]=1;
        	}
        }
        if(arr[n]==1) {
        	bw.write("CY");
        }
        else {
        	bw.write("SK");
        }
        bw.close();
        br.close();
    }
}