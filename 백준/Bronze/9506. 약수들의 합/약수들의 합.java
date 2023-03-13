import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
			int n=0;
			while(n!=-1) {
				n=Integer.parseInt(br.readLine());
				if(n==-1)
					break;
				int sum=0;
				StringBuilder sb = new StringBuilder();
				sb.append(n+" = ");
				for(int i=1;i<n;i++) {
					if(n%i==0) {
						sb.append(i+" + ");
						sum+=i;
					}
				}
				sb.delete(sb.length()-3, sb.length());
				if(sum==n) {
					bw.write(sb.toString());
					bw.newLine();
				}
				else {
					bw.write(n+" is NOT perfect.");
					bw.newLine();
				}
				
			}
			bw.close();
			br.close();
		}
	}