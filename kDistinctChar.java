class Solution {
    public int kDistinctChar(String s, int k) {
        int[] freq = new int[256];
        int l=0,dist=0,maxL=0;

        for(int r=0;r<s.length();r++){
            if(freq[s.charAt(r)] == 0) dist++;
            freq[s.charAt(r)]++;

            while(dist>k){
                freq[s.charAt(l)]--;
                if(freq[s.charAt(l)] == 0) dist--;
                l++;
            }

            maxL = Math.max(maxL,(r-l+1));
        }
        return maxL;
    }
}
