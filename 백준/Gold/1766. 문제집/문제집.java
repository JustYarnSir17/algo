import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m; //정점과 간선
	static List<Integer>[] list;//간선 방향 저장 리스트
	static int[] diff;//난이도 저장 배열
	static int[] indegree;//진입 차수 저장 배열
	static Queue<Integer> q = new LinkedList<>();//정렬하기 위한 큐 였지만 안씀
	static List<Integer> slist = new ArrayList<>();//정렬하기 위한 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());//정점
			m = Integer.parseInt(st.nextToken());//간선
			list = new ArrayList[n + 1];//간선 방향 저장 리스트
			diff = new int[n + 1];//난이도
			indegree = new int[n + 1];//진입 차수

			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 1; i <= n; i++) {
				diff[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b); //간선 방향 저장
				indegree[b]++;//진입 차수 할당
			}
			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0) {
					slist.add(i);//진입차수가 0이면 그냥 바로 sort list 에 저장
					
				}
			}
			//선수 과목들 정렬
			Collections.sort(slist, new Comparator<Integer>() {//난이도 낮은 순으로 정렬
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return diff[o1] - diff[o2];
				}
			});
			StringBuilder sb = new StringBuilder(); //출력값저장 sb
			while(slist.size()!=0) {//만약 저장 리스트가 비어있지 않다면
				int tmp = slist.get(0); //난이도 가장 낮은 애를 불러오고
				slist.remove(0);//그건 지워준다.
				sb.append(tmp+" ");//출력값에 더해주고
				for(int i=0;i<list[tmp].size();i++) {//해당 난이도 낮은 애가 선수과목일 경우
					indegree[list[tmp].get(i)]--;//진입차수 제거해주고
					if(indegree[list[tmp].get(i)]==0) {//만약 진입차수가 0이 되면
						slist.add(list[tmp].get(i));//저장 리스트에 저장
					}
				}
				// 저장 리스트에 저장하고 다시 난이도 순으로 정렬
				// 이 리스트에 저장된 경우에는 그 상황에서 언제든지 들을 수 있다는 것이기 때문에 
				// 정렬해서 가장 낮은 난이도 순서대로 수강 가능
				Collections.sort(slist, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return diff[o1] - diff[o2];
					}
				});
			}
			bw.write(String.valueOf(sb.toString()));
		
		bw.close();
		br.close();
	}
}