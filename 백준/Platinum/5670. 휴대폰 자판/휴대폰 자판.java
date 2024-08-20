import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input ="";
        while((input=br.readLine())!=null) {
        	int n=Integer.parseInt(input);
        	Trie trie=new Trie();
        	List<String> words=new ArrayList<>();
        	for(int i=0;i<n;i++) {
        		String str= br.readLine();
        		words.add(str);
        		trie.insert(str);
        	}
        	for(int i=0;i<words.size();i++) {
        		trie.find(words.get(i));
        	}
        	List<Integer>list = trie.words();
        	double avg=0;
        	for(int i=0;i<list.size();i++) {
        		avg+=list.get(i);
        	}
        	avg/=list.size();
        	bw.write(String.format("%.2f",avg)+"\n");
        	bw.flush();
        	
        }
        
        bw.close();
        br.close();
	}
    
}

class TrieNode{
	TrieNode[] children = new TrieNode[26];//영어 소문자 26개
	boolean isEnd= false;
}

class Trie{
	private TrieNode root; // 문자열 저장 배열
	List<Integer> list;// 핸드폰 자판 입력 횟수 저장 리스트
	public Trie() {//테스트케이스마다 초기화
		root = new TrieNode();
		list=new ArrayList<>();
	}
	
	public void insert(String word) {//문자열 저장 매서드
		TrieNode node = root;
		for(int i=0;i<word.length();i++) {
			int idx = word.charAt(i)-'a';
			if(node.children[idx]==null) {
				node.children[idx]=new TrieNode();
				
			}
			node = node.children[idx];
		}
		
		node.isEnd =true;
	}
	
	public void find(String word) {//해당 문자열을 입력하기 위해 자판을 몇 번 입력해야할 지 찾는 매서드
		TrieNode node = root;
		find(root.children[word.charAt(0)-'a'],word);//최초츼 입력은 무조건 이뤄지므로 다음 입력을 파라미터로 입력
		
	}
	
	public void find(TrieNode node,String word) {
		int cnt=1;//최초의 입력 1로 초기화
		
		for(int i=1;i<word.length();i++) {//2번째문자부터 차례대로 탐색
			int count=0;//해당 노드에서 다음 문자로 이어지는 게 얼마나 많은지 체크
			for(int j=0;j<26;j++) {
				if(node.children[j]!=null) {//만약 다음 문자가 존재한다면
					count++;//count 횟수 추가
				}
			}
			if(count>=2) {//만약 다음으로 이어지는 문자가 2개 이상이라면
				cnt++;//입력해야할 횟수 추가
			}
			else if(node.isEnd&&count==1) {//만약 지금 노드로 끝나는 문자가 있고, 다음 문자로 이어지는 것이 하나 존재한다면
				//해당 문자로 끝나는 문자열과 다음 문자가 존재하는 문자열 분기 hell과 hello 처럼
				//이럴 때는 o를 한 번 더 입력해야 한다. 즉 cnt추가
				cnt++;
			}

			int idx= word.charAt(i)-'a';
			node=node.children[idx];//다음 노드로 이동
		}
		if(node.isEnd) {//만약 해당 노드가 끝이라면, 즉 찾는 문자열을 다 찾은 경우
			list.add(cnt);//리스트에 추가 
			return;
		}
	}
	
	public List<Integer> words(){
		return list;
	}
}