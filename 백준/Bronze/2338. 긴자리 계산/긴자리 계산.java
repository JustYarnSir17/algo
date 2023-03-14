import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
	
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
			BigInteger a,b,c;
			BigInteger n,m;
			String str= br.readLine();
			n=new BigInteger(str);
			str=br.readLine();
			m=new BigInteger(str);
			a=n.add(m);
			b=n.subtract(m);
			c=n.multiply(m);
			bw.write(String.valueOf(a));
			bw.newLine();
			bw.write(String.valueOf(b));
			bw.newLine();
			bw.write(String.valueOf(c));
			bw.close();
			br.close();
		}	
	}