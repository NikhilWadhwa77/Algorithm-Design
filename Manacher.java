 package ADI.Algorithms;

import java.util.Arrays;

public class Manacher {
    public static void main(String[] args) {
        String s = "abba";

        if(s.isEmpty()){
            System.out.println(0);
            return;
        }

        String str = "";

        str += "@";

        for(int i = 0; i < s.length(); i++){
            str += "#" + s.charAt(i);
        }
        str += "#$";

        System.out.println(str);

        int[] arr = new int[str.length()];
        int left, right, count;
        int maxCount = 0;

        for(int i = 1; i < str.length()-1; i++){
            left = i-1;
            right = i+1;
            count = 1;
            while(left > 0 && right < str.length() - 1 && str.charAt(left) == str.charAt(right)){
                left--;
                right++;
                count += 2;
            }
            if(count == 1){
                arr[i] = count;
            }else{
                arr[i] = count - (count/2 + 1);
            }
            maxCount = Math.max(maxCount,arr[i]);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(maxCount);

    }
}
