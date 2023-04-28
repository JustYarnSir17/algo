import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		bw.write(":fan::fan::fan:\n" + 
				":fan::"+str+"::fan:\n" + 
				":fan::fan::fan:");
		
		bw.close();
		br.close();
	}
}