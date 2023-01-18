import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		sc.nextLine();
		for(int i =0;i<t;i++) {
			int n=sc.nextInt();
			int count=0;
			int div = n/10;
			double []score= {0.35,0.45,0.2};
			double []arr=new double [n];
			int k =sc.nextInt();
			for(int j =0;j<n;j++) {
				for(int l=0;l<3;l++) {
					double s= sc.nextInt();
					arr[j]+=s*score[l];
				}
			}
			for(int j=0;j<n;j++) {

				if(arr[k-1]<arr[j]) {
					count++;
				}
			}
			switch(count/div) {
			case 0:
				System.out.printf("#%d A+\n",i+1);
				break;
			case 1:
				System.out.printf("#%d A0\n",i+1);
				break;
			case 2:
				System.out.printf("#%d A-\n",i+1);
				break;
			case 3:
				System.out.printf("#%d B+\n",i+1);
				break;
			case 4:
				System.out.printf("#%d B0\n",i+1);
				break;
			case 5:
				System.out.printf("#%d B-\n",i+1);
				break;
			case 6:
				System.out.printf("#%d C+\n",i+1);
				break;
			case 7:
				System.out.printf("#%d C0\n",i+1);
				break;
			case 8:
				System.out.printf("#%d C-\n",i+1);
				break;
			default:
				System.out.printf("#%d D0",i+1);
				break;
				
			}
			
			
			
		}
	}
}