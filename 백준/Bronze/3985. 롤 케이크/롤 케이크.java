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
		int l = Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		boolean [] arr = new boolean[l+1];
		int max=0;
		int idx=0;
		int idx1=0;
		int pre=0;
		for(int i=1;i<=n;i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			if(pre<(y-x)){
				pre=y-x;
				idx1=i;
			}
			int count=0;
			for(int j=x;j<=y;j++) {
				if(arr[j]!=true) {
					arr[j]=true;
					count++;
				}
			}
			if(max<count) {
				max=count;
				idx=i;
			}
			
			
		}
		System.out.println(idx1+" "+idx);
		
		br.close();
		bw.close();
	}

}