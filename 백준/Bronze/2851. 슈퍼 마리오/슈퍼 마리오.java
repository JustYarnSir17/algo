import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] arr = new int [10];
		for(int i=0;i<10;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int sum=0;
		int idx=0;
		int pre=0;
		
		while(sum<=100) {
			sum+=arr[idx];
			idx++;
			if(idx>=10)
				break;

		}
		if(sum>100) {
			int com1,com2;
			pre=sum-arr[--idx];
			com1= 100-pre;
			com2= sum-100;
			if(com2>com1) {
				sum=pre;
			}
			
		}
		bw.write(String.valueOf(sum));
		br.close();
		bw.close();
	}

}