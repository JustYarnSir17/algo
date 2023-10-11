import java.util.*;

class Solution {
    static String[] discount;
    static String[] want;
    static int[] number;
    static int count;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        this.discount = discount;
        this.want = want;
        this.number = number;
        count = 0;
        for(int i = 0; i <= discount.length-10; i ++) {
            int temp = cnt(i);
            if(temp == 10) {
                
                count ++;
            }
            
        
        }
        answer = count;
        return answer;
    }
    public static int check (String str) {
        int result = -1;
        for(int i = 0; i < want.length; i++) {
            if(want[i].equals(str)) {
                result = i;
                return result;
            }
        }
        return result;
    }
    public static int cnt(int index) {
        String[] newWant = new String[want.length];
        int[] newNumber = new int[number.length];
        for(int i = 0; i < newWant.length; i++) {
            newWant[i] = want[i];
        }
        for(int i = 0; i < newNumber.length; i++) {
            newNumber[i] = number[i];
        }
        int num = 0;
        for(int i = index; i < index+10; i++) {
            int c = check(discount[i]);
            if(c>-1) {
                // num ++;
                newNumber[c]--;
                if(newNumber[c]<0) {
                    return num;
                }
                num++;
            } else {
                return num;
            }
        }
        return num;
    }
}