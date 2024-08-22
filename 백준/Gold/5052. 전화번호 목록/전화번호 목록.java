import java.io.*;
import java.util.*;



public class Main {
	static HashSet<Integer> set =new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int Time= Integer.parseInt(br.readLine());
        for(int t=0;t<Time;t++) {
        	Trie trie=new Trie();
        	int n =Integer.parseInt(br.readLine());
        	boolean answer=false;
        	for(int i=0;i<n;i++) {
        		String str = br.readLine();
        		
        		if(!answer) {
        			answer= trie.insert(str);
        		}
        	}
        	if(answer) {
        		bw.write("NO\n");
        		
        	}
        	else {
        		bw.write("YES\n");
        	}
        	
        	
        }
        bw.close();
        br.close();
        
    }
}

class TrieNode{
	TrieNode[] children = new TrieNode[10];
	boolean isEnd= false;
}

class Trie{
	private TrieNode root;
	
	public Trie() {
		root= new TrieNode();
		
	}
	
	public boolean insert(String word) {
		boolean answer= false;
		TrieNode node = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'0';
			if(node.children[idx]==null) {
				node.children[idx]=new TrieNode();
			}
			node = node.children[idx];
			if(node.isEnd) {//기존 번호의 접두어인 경우
				answer=true;
			}
		}
		for(TrieNode child:node.children) {//기존 번호가 이 번호의 접두어인 경우
			if(child!=null) {
				return true;
			}
		}
		
		node.isEnd=true;
		return answer;
	}
	
}