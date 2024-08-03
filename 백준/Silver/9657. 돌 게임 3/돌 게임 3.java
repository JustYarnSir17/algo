import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] arr = new int [1001];//1은 상근, 2는 창영
        arr[1]=1;
        arr[3]=1;
        arr[4]=1;
        arr[2]=2;
        
        int n =Integer.parseInt(br.readLine());
        for(int i=5;i<=1000;i++) {
        	if(arr[i-1]==2||arr[i-3]==2||arr[i-4]==2) {
        		arr[i]=1;
        	}
        	else {
        		arr[i]=2;
        	}
        }
        if(arr[n]==1) {
        	bw.write("SK");
        }
        else {
        	bw.write("CY");
        }
        bw.close();
        br.close();
    }
}