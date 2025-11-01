class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] count = new int[128];
        for(char c:t.toCharArray()){
            count[c]++;
        }

        int left=0,right=0,minL=Integer.MAX_VALUE,length=t.length(),start=0;

        while(right<s.length()){
            if(count[s.charAt(right)]>0){
                length--;
            }
            count[s.charAt(right)]--;
            right++;

            while(length==0){
                if(right-left < minL){
                    minL=right-left;
                    start=left;
                }

                count[s.charAt(left)]++;
                if(count[s.charAt(left)]>0){
                    length++;
                }
                left++;
            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(start,minL+start);
    }
}