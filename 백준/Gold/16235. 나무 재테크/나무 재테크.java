import java.io.*;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

public class Main {
	static int n;
	static int m;
	static int k;
	static int [][]A;
	static int [][] arr;
	static int [] dr = {-1,-1,-1,0,0,1,1,1};
	static int [] dc = {-1,0,1,-1,1,-1,0,1};
	static List<Integer>[][] list;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //봄에는 나이만큼의 양분을 먹고 나이가 1 증가, 나무가 있는 칸에 있는 양분만 먹을 수 있다. 여러 개 있을 경우 어린 나무부터 양분을 먹고, 양분이 부족하면 즉시 죽는다.
        //여름에는 봄에 죽은 나무가 양분으로 변한다. 죽은 나무마다 나이를 2로 나눈 값이 양분에 추가. 소수점 아래는 버림
        //가을에는 번식한다. 나무의 나이가 5의 배수일 경우 번식하며 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
        //겨울에는 s2d2가 땅을 돌아단니면서 양분을 추가. 추가되는 양분은 입력으로 주어진다. 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n][n];
        A=new int[n][n];
        list=new ArrayList[n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int tmp=Integer.parseInt(st.nextToken());
        		arr[i][j]=5;//가장 처음 양분은 5만큼 들어감
        		A[i][j]=tmp;// 이후 추가적으로 줄 양분 저장 배열
        		list[i][j]=new ArrayList<>();
        	}
        }   
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int r=Integer.parseInt(st.nextToken())-1;
        	int c=Integer.parseInt(st.nextToken())-1;
        	int age=Integer.parseInt(st.nextToken());
        	list[r][c].add(age);
        }
        
        for(int i=0;i<k;i++) {
        	season();
        	
        }
        int cnt=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(!list[i][j].isEmpty()) {
        			cnt+=list[i][j].size();
        		}
        	}
        }
        bw.write(cnt+"");
        br.close();
        bw.close();
    }
	
	public static void season() {
		List<int[]> tree = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!list[i][j].isEmpty()) {
					List<Integer> survivedTrees = new ArrayList<>();
					int Nutrients=0;
					Collections.sort(list[i][j]);
					
					for(int age:list[i][j]) {
						if(arr[i][j]>=age) {
							arr[i][j]-=age;
							survivedTrees.add(age+1);
							if((age+1)%5==0) {
								for(int d=0;d<8;d++) {
									int nr = i+dr[d];
									int nc= j+dc[d];
									if(nr<0||nr>=n||nc<0||nc>=n)
										continue;
									tree.add(new int[] {nr,nc});
								}
							}
						}
						else {
							Nutrients+=age/2;
						}
					}
					list[i][j]=survivedTrees;
					arr[i][j]+=Nutrients;
					}
				
				}
			}
		
		for(int[] t:tree) {
			list[t[0]][t[1]].add(1);
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]+=A[i][j];
			}
		}
		
		
	}
	
}