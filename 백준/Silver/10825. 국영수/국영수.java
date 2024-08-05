import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n =Integer.parseInt(br.readLine());
        int [][] arr = new int [n][4];//인덱스, 국어, 영어, 수학 순
        HashMap<Integer,String> map = new HashMap<>();
        int idx=0;
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String name=st.nextToken();
        	map.put(idx,name);
        	arr[i][0]=idx++;
        	for(int j=1;j<=3;j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        	
        }
        Arrays.sort(arr,new Comparator<int[]>(){
        	@Override
        	public int compare(int [] o1,int [] o2) {
        		if(o1[1]==o2[1]) {//국어 점수가 같을 때
        			if(o1[2]==o2[2]) {//영어 점수가 같을 때
        				if(o1[3]==o2[3]) {//수학 점수가 같을 때
        					return map.get(o1[0]).compareTo(map.get(o2[0]));//문자 비교
        				}
        				else {//수학 점수가 다를 대
        					return Integer.compare(o2[3],o1[3]);//내림차순
        				}
        			}
        			else {//영어 점수가 다를 때
        				return Integer.compare(o1[2],o2[2]);//오름차순
        			}
        		}
        		else {//국어 점수가 다를 때
        			return Integer.compare(o2[1],o1[1]);//내림차순
        		}
        	}
        });
        
        for(int i=0;i<n;i++) {
        	bw.write(map.get(arr[i][0])+"\n");
        }
        bw.close();
        br.close();
    }
}