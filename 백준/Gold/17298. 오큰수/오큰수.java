import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static Stack<Integer> stack = new Stack<>();
	static int[] sig;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		sig = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <n ; i++) {
			if (stack.isEmpty()) {
				stack.add(i);
			} else {
				while (arr[i] > arr[stack.peek()]) {
					sig[stack.pop()] = arr[i];
					if(stack.isEmpty())
						break;
				}
				stack.add(i);
			}
		}
		while (!stack.isEmpty()) {
			sig[stack.pop()] = -1;
		}
		for (int i = 0; i < n; i++) {
			bw.write(sig[i] + " ");
		}
		bw.close();
		br.close();
	}
}