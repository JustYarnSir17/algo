import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[][] arr = new char[15][15];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (arr[i][j] != '\0')
					bw.write(arr[i][j]);
				else
					continue;
			}
		}

		bw.close();
		br.close();
	}
}