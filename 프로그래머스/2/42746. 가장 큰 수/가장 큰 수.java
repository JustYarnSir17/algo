import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                String tmp1=o1+o2;
                String tmp2=o2+o1;
                return tmp2.compareTo(tmp1);
            }
        });
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : arr) {
            answer.append(num);
        }

        return answer.toString();
    }
}