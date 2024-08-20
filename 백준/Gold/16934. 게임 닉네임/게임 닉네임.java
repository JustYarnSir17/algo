import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Trie trie=new Trie();
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	bw.write(trie.search(str)+"\n");
        	trie.insert(str);
        	
        }
       
        bw.close();
        br.close();
    }
}
class TrieNode{
	TrieNode[] children = new TrieNode[26];// 알파벳 소문자 26개
	boolean isEnd=false; //단어의 끝인지 확인하는 플래그
	int count=0;//닉네임 유니크 숫자 
}

class Trie{
	private TrieNode root;
//	private HashMap<String,Integer> map = new HashMap<>(); 원래 해시맵을 사용해 닉네임 유니크를 이루려고 했으나 시간 초과 떄문에 count 변수를 사용
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {// 문자열 삽입
		TrieNode node = root;//루트 노드
		for(int i=0;i<word.length();i++) {//문자열 자리 순회
			int idx= word.charAt(i)-'a';//문자열 위치를 인덱스화
			if(node.children[idx]==null) {//만약 해당 문자 하위 node가 없다면, 즉, 해당 문자가 등장한 적이 없다면
				node.children[idx]=new TrieNode();//해당 문자를 추가
			}
			node =node.children[idx];//다음 노드로 이동
		}
		node.isEnd=true;//문자열에 따른 노드를 모두 추가후 마지막 노드에 문자열의 끝을 확인하는 플래그 세움
		
		
		node.count++; // 시간초과를 해결하기 위해 count를 닉네임 유니크 변수로
		
//		
//		if(!map.containsKey(word)) {//만약 기존에 주어지지 않았던 문장이라면 닉네임 유니크를 위한 숫자 필요
//			map.put(word,2);//주어진 문장을 닉네임 유니크 판단 해시맵에 넣고, 동일한 문장이 다시 주어진다면 유니크화를 위해 2부터 차례대로 입력
//		}
//		//만약 기존에 주어졌던 문장이라면 search 매서드를 통해 해시맵에 저장된 숫자가 갱신되었을테니 else는 작성 x
	}
	
	public String search(String word) {//검색
		TrieNode node = root;
		StringBuilder sb = new StringBuilder();//닉네임 반환용 StringBuilder
		boolean isUnique = false;//닉네임 유니크 판단
		
		
		for(int i=0;i<word.length();i++) {//문자열 순회
			int idx = word.charAt(i)-'a';//문자열 위치 인덱스
			sb.append(word.charAt(i));//닉네임에 추가
			if(node.children[idx]==null) {//만약 해당 문자가 기존에 등록된 문자가 아니라면
				isUnique =true;
				break;
			}
			node=node.children[idx];// 자식노드로 이동
		}
		
		String result= sb.toString();//닉네임 할당
		if(isUnique||!node.isEnd) {//만약 닉네임이 유니크하거나 한 문장의 끝에 도달하지 않았다면, 즉 기존에 존재하는 문장이 아니라면
			return result;
		}
		
		//여기까지 온다면 기존에 입력된 문장과 동일한 문장을 입력한 것이기에 닉네임의 유니크화를 위해 추가적인 숫자 부여 필요
		
		
		// 해시맵을 사용했을 때
//		int count = map.get(result);//문장을 입력할 때 
//		while(map.containsKey(result)) {
//			result=sb.toString()+count;
//			count++;
//		}
//		map.put(result,count);
		
		int count = node.count+1;
		
		return result+count;
	}
	
}