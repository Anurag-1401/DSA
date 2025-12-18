class Solution {
    public int beautySum(String s) {
        int result = 0;

        for(int j=0;j<s.length();j++){
            int[] score = new int[26];

            for(int i=j;i<s.length();i++){
                score[s.charAt(i)-'a']++;

                int max=0,min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(score[k]>0){
                        max = Math.max(max,score[k]);
                        min = Math.min(min,score[k]);
                    }
                }
                result+=(max-min);
            }
        }
        return result;
    }
}