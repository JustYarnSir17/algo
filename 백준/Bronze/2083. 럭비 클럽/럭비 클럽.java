import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		String str="";
		int age=0;
		int weight=0;
		str=st.nextToken();
		age=Integer.parseInt(st.nextToken());
		weight= Integer.parseInt(st.nextToken());
		while(!str.equals("#")) {
			if(age>17||weight>=80) {
				bw.write(str+" Senior");
				bw.newLine();
			}
			else {
				bw.write(str+" Junior");
				bw.newLine();
				
			}
			st=new StringTokenizer(br.readLine());
			str=st.nextToken();
			age=Integer.parseInt(st.nextToken());
			weight= Integer.parseInt(st.nextToken());
		}
		bw.close();
		br.close();
	}
}