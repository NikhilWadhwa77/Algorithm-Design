class Solution {
    public String longestPalindrome(String s) {

        if(s.length() < 2){
            // System.out.println(0);
            return s;
        }

        if(s.length() == 2 && s.charAt(0) != s.charAt(1)){
            return s.substring(0,1);
        }

        String str = "";

        str += "@";

        for(int i = 0; i < s.length(); i++){
            str += "#" + s.charAt(i);
        }
        str += "#$";

        // System.out.println(str);

        int[] arr = new int[str.length()];
        int left, right, count;
        int maxCount = 0;
        int start = 0;
        int end = 0;

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
            if(arr[i] > maxCount){
                maxCount = arr[i];
                start = left;
                end = right;
            }
//            maxCount = Math.max(maxCount,arr[i]);
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(maxCount);
        
        String ans = "";

        if(maxCount == 1){
            return str.substring(end,end+1);
        }else{
            for(int i = start+2; i < end; i += 2){
                // System.out.print(str.charAt(i));
                ans += str.charAt(i);
            }
            return ans;
        }
    }
}
