import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node header = new Node(null,null,'H');
        Node end = new Node(null,null,'E');
        header.next= end;
        end.prev=header;
        Node curr = end;
        String str= br.readLine();
        for(int i=0;i<str.length();i++) {
        	curr.add(str.charAt(i));
        }
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String tmp = st.nextToken();
        	if(tmp.equals("L")) {
        		if(curr.prev!=header) {
        			curr=curr.prev;
        		}
        	}
        	else if(tmp.equals("D")) {
        		if(curr.next!=null) {
        			curr=curr.next;
        		}
        	}
        	else if(tmp.equals("B")) {
        		if(curr.prev!=header) {
        			curr.del();
        		}
        	}
        	else {
        		String word= st.nextToken();
        		curr.add(word.charAt(0));
        	}
        }
        curr=header.next;
        while(curr!=end) {
        	bw.write(curr.word);
        	curr=curr.next;
        }
        bw.close();
        br.close();
	}
}

class Node {
	Node prev;
	Node next;
	char word;
	
	Node(Node prev, Node next, char word){
		this.prev=prev;
		this.next=next;
		this.word=word;
	}
	
	public void del() {
		Node prev= this.prev.prev;
		prev.next=this;
		this.prev=prev;;
	}
	
	public void add(char word) {
		Node tmp = new Node(this.prev,this,word);
		this.prev.next=tmp;
		this.prev=tmp;
		
	}
	
	
	
	
	
}