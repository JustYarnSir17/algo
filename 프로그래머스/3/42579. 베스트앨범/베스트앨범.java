import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genreIndex = new HashMap<>();//장르로 인덱스 불러오기
        HashMap<Integer,String> indexGenre = new HashMap<>();//인덱스로 장르 불러오기
        HashMap<String,List<Node>> count= new HashMap<>();//장르 각각 재생수 해시맵
        List<Total> list = new ArrayList<>();
        int idx=0; //장르 인덱스
        for(int i=0;i<genres.length;i++){
            if(!genreIndex.containsKey(genres[i])){
                genreIndex.put(genres[i],idx);
                indexGenre.put(idx,genres[i]);
                count.put(genres[i],new ArrayList<>());
                count.get(genres[i]).add(new Node(i,plays[i]));
                list.add(new Total(idx,plays[i]));
                idx++;
            }
            else{
                int tmp =genreIndex.get(genres[i]);//해당 장르 인덱스
                list.get(tmp).total+=plays[i];
                count.get(genres[i]).add(new Node(i,plays[i]));
            }   
        }
        Collections.sort(list);
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String g = indexGenre.get(list.get(i).idx);
            Collections.sort(count.get(g));
            for(int j=0;j<count.get(g).size();j++){
                if(j<2){
                    result.add(count.get(g).get(j).num);    
                }
                else{
                    break;
                }
                
            }
        }
        
        
        int[] answer = new int [result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=result.get(i);
        }
        return answer;
    }
}
class Total implements Comparable<Total>{
    int idx;
    int total;
    Total(int idx, int total){
        this.idx=idx;
        this.total=total;
    }
    @Override
    public int compareTo(Total o){
        return o.total-this.total;
    }
}


class Node implements Comparable<Node>{
    int num;
    int play;
    Node(int num, int play){
        this.num=num;
        this.play=play;
    }
    @Override
    public int compareTo(Node o){
        if(this.play==o.play){
            return this.num-o.num;
        }
        else{
            return o.play-this.play;    
        }
        
    }
    
}