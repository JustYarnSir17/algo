class Solution {
    public int solution(int n) {
        long [] arr = new long [100001];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<100001;i++){
            arr[i]=(arr[i-2]+arr[i-1])%1234567;
        }
        return (int)arr[n];
    }
}