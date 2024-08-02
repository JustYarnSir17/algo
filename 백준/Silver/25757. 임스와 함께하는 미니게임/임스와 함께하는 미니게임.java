import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int n =Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int cnt=0;
        int answer=0;
        switch(game) {
        case "Y":
        	for(int i=0;i<n;i++) {
        		String tmp = br.readLine();
        		if(!set.contains(tmp)) {
        			set.add(tmp);
        			cnt++;
        			if(cnt==1) {
        				cnt=0;
        				answer++;
        			}
        		}
        		
        	}
        	break;
        case "F":
        	
        	for(int i=0;i<n;i++) {
        		String tmp = br.readLine();
        		if(!set.contains(tmp)) {
        			set.add(tmp);
        			cnt++;
        			if(cnt==2) {
        				cnt=0;
        				answer++;
        			}
        		}
        		
        	}
        	break;
        case "O":
        	for(int i=0;i<n;i++) {
        		String tmp = br.readLine();
        		if(!set.contains(tmp)) {
        			set.add(tmp);
        			cnt++;
        			if(cnt==3) {
        				cnt=0;
        				answer++;
        			}
        		}
        		
        	}
        	break;
        }
        bw.write(answer+"");
        bw.close();
        br.close();
        
    }
}