import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<String> q= new LinkedList<>();
		boolean fl=false;
		String str = br.readLine();
		StringTokenizer st1= new StringTokenizer(str, "+-");
		StringTokenizer st2= new StringTokenizer(str,"1234567890");
		while(st1.hasMoreTokens()&&st2.hasMoreTokens()) {
			q.add(st1.nextToken());
			q.add(st2.nextToken());
		}
		if(st1.hasMoreTokens()) {
			q.add(st1.nextToken());
		}
		int sum=0;
		int tmp1=0;
		sum+=Integer.parseInt(q.poll());
		while(!q.isEmpty()) {
			String tmp2=q.poll();
			if(tmp2.equals("-")) {
				if(fl==false) {
					fl=true;
				}
				else {
					sum-=tmp1;
					tmp1=0;
				}
				
			}
			else if(tmp2.equals("+")) {
				continue;
			}
			else {
				if(fl) {
				tmp1+=Integer.parseInt(tmp2);
				}
				else {
					sum+=Integer.parseInt(tmp2);
				}
			}
			
		}
		if(fl==true&&tmp1!=0) {
			sum-=tmp1;
			tmp1=0;
		}
		System.out.println(sum);
		
	}
}