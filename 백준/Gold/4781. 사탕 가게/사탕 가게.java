import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        double m = Double.parseDouble(st.nextToken());
        while(n!=0&&m!=0.00) {
        	int [][] candy = new int [n][2];
        	for(int i=0;i<n;i++) {
        		st=new StringTokenizer(br.readLine());
        		int c=Integer.parseInt(st.nextToken());
        		double p =Double.parseDouble(st.nextToken());
        		int price= (int)(p*100+0.5);//0.5를 더해주고 int로 형변환을 해주는 이유는 Double의 경우 부동소수점 자료형이기 때문에
        		//표시되는 값과 실제로 인식되는 값의 차이가 있을 수 있다. 이는 컴퓨터가 2진수 체계로 이뤄져있기에 10진수의 소수점을 정확하게 표현하기 힘든 것에서 기인한다.
        		//따라서 0.5를 더해서 실제로는 0.XXX 부족하게 처리되는 수를 확실하게 Int로 만들고 소수점 아래는 버리기 위함이다.
        	
        		candy[i][0]=c;
        		candy[i][1]=price;
        	}
        	int []money = new int [10001];
        	for(int i=0;i<n;i++) {
        		for(int j=1;j<=10000;j++) {
        			if(j-candy[i][1]>=0) {
        				money[j]=Math.max(money[j],money[j-candy[i][1]]+candy[i][0]);
        			}
        		}
        	}
        	System.out.println(money[(int)(m*100+0.5)]);
        	st=new StringTokenizer(br.readLine());
        	n=Integer.parseInt(st.nextToken());
        	m=Double.parseDouble(st.nextToken());
        }
        
	}
}