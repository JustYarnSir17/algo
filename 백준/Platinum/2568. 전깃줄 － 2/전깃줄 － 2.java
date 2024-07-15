import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n=Integer.parseInt(br.readLine());
        List<Integer>list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b= Integer.parseInt(st.nextToken());
        	list.add(a);
        	map.put(a,b);
        }
        Collections.sort(list);
        int [] lis = new int[list.size()];
        int [] indices = new int[list.size()];
        int [] pre=new int [list.size()];
        int size=0;
        Arrays.fill(pre,-1);
        for(int i=0;i<list.size();i++) {
        	int x = map.get(list.get(i));
        	int left= 0,right=size;
        	while(left!=right) {
        		int mid= (left+right)/2;
        		if(lis[mid]<x) {
        			left=mid+1;
        		}
        		else {
        			right=mid;
        		}
        	}
        	
        	lis[left]=x;
        	indices[left]=i;
        	if(left>0) {
        		pre[i]=indices[left-1];
        	}
        	
        	if(left==size) {
        		size++;
        	}
        	
        }
        int k= indices[size-1];
        int[] result= new int[size];
        for(int i=size-1;i>=0;i--) {
        	result[i]=list.get(k);
        	k=pre[k];
        }
        int answer= n-size;
        bw.write(answer+"\n");
        for(int i=0;i<list.size();i++) {
        	boolean tr =true;
        	for(int j=0;j<size;j++) {
        		if(list.get(i)==result[j]) {
        			tr=false;
        			break;
        		}
        	}
        	if(tr) {
        		bw.write(list.get(i)+"\n");
        	}
        }
        
        bw.close();
        br.close();
    }
}