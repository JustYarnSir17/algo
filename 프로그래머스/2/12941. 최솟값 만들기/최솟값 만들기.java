import java.util.*;
import java.math.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int minA=0;
        int minB=0;
        int idx=B.length-1;
        for(int i=0;i<A.length;i++){
            minA+=A[i]*B[idx];
            minB+=B[i]*A[idx];
            --idx;
        }
        answer=Math.min(minB,minA);


        return answer;
    }
}