package ADI.Algorithms;

import java.util.*;

public class zValue {
    public static void main(String[] args) {
        String pattern = "aa";
        String text = "aaaa";

        String str = pattern + "$" + text;
        int[] arr = new int[str.length()];

        int count = 0;
//        i = pattern.length() + 1 because it makes less iterations
        for(int i = pattern.length()+1; i < str.length(); i++){
            while(i+count < str.length() && str.charAt(i+count) == str.charAt(count)){
                count++;
                arr[i] = count;
            }
            count = 0;

        }

        System.out.println(Arrays.toString(arr));

        int index;
        for(int i = pattern.length() + 1; i < str.length(); i++){
            if(arr[i] == pattern.length()){
                index = i - pattern.length() - 1;
                System.out.print(index + " ");
            }
        }

    }
}
