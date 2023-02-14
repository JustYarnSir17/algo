import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		minHeap h= new minHeap();
		for(int i=0;i<n;i++) {
			int result=0;
		
			int x= Integer.parseInt(br.readLine());
			if(x==0) {
				result= h.delete();
				bw.write(String.valueOf(result));
				bw.newLine();
			}
			else {
				h.insert(x);
			}
			
		}
		

		bw.close();
		br.close();
	}
}
class minHeap{
	private ArrayList<Integer> heap;
	
	public minHeap() {
		heap = new ArrayList<Integer>();
		heap.add(0);
	}
	
	public void insert(int val) {
		heap.add(val);
		int p =heap.size()-1;
		while(p>1&&heap.get(p/2)>heap.get(p)) {
			int tmp = heap.get(p/2);
			heap.set(p/2,val);
			heap.set(p, tmp);
			
			p=p/2;
		}
	}

	public int delete() {
		if(heap.size()-1<1) {
			return 0;
		}
		int deleteitem = heap.get(1);
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int pos =1;
		
		while((pos*2)<heap.size()) {
			int min = heap.get(pos*2);
			int minpos = pos*2;
			
			if(((pos*2+1)<heap.size())&& min>heap.get(pos*2+1)) {
				min=heap.get(pos*2+1);
				minpos = pos*2+1;
			}
			
			if(min>heap.get(pos))
				break;
			
			int tmp = heap.get(pos);
			heap.set(pos, heap.get(minpos));
			heap.set(minpos, tmp);
			pos=minpos;
			
			
		}
		return deleteitem;
	}
	public int getSize() {
		return heap.size();
	}
}