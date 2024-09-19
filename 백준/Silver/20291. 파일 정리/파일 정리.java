import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        PriorityQueue<File> pq = new PriorityQueue<>();
        int n =Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(),".");
        	st.nextToken();
        	String file = st.nextToken();
        	if(!set.contains(file)) {
        		set.add(file);
        		map.put(file,1);
        	}
        	else {
        		map.replace(file,map.get(file)+1);
        	}
        	
        }
        for(String tmp: set) {
        	pq.offer(new File(tmp,map.get(tmp)));
        }
        while(!pq.isEmpty()) {
        	File tmp = pq.poll();
        	bw.write(tmp.file+" "+tmp.cnt+"\n");
        }
        bw.close();
        br.close();
	}
}

class File implements Comparable<File>{
	String file;
	int cnt;
	File(String file, int cnt){
		this.file=file;
		this.cnt=cnt;
	}
	
	@Override
	public int compareTo(File o) {
		return this.file.compareTo(o.file);
	}
}