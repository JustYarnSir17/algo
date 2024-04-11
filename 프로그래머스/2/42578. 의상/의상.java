import java.util.*;
class Solution {
    // static int cnt=0;
    // static boolean[] v;
    // static List<Integer> list = new ArrayList<>();
    public int solution(String[][] clothes) {
        int answer=0;
           HashMap<String,Integer> map = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.replace(clothes[i][1],map.get(clothes[i][1])+1);
            }
            else{
                map.put(clothes[i][1],1);
            }
        }
        map.forEach((key,value)->{
            list.add(value);
        });
        int sum=1;
        for(int i=0;i<list.size();i++){
            sum*=list.get(i)+1;
            
        }
        sum-=1;
        return sum;
    }
}
    //조합방법으로 하려고 했던 것
//         int answer = 0;
        // HashMap<String,Integer> map = new HashMap<>();
        // for(int i=0;i<clothes.length;i++){
        //     if(map.containsKey(clothes[i][1])){
        //         map.replace(clothes[i][1],map.get(clothes[i][1])+1);
        //     }
        //     else{
        //         map.put(clothes[i][1],1);
        //     }
        // }
        // map.forEach((key,value)->{
        //     list.add(value);
        // });
       
//         for(int i=1;i<=list.size();i++){
//             v=new boolean[list.size()];
//             comb(i,1,0);
            
//         }
            
//         answer=cnt;
//         return answer;
//     }
//     public void comb(int n,int sum,int start){
//         if(n==0){
//             cnt+=sum;
//             return;
//         }
//         for(int i=start;i<list.size();i++){
//             if(v[i])
//                 continue;
//             sum*=list.get(i);
//             v[i]=true;
//             comb(n-1,sum,i+1);
            
//             v[i]=false;
//             sum/=list.get(i);
            
//         }
//     }
// }