class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }

    private int atMost(int[] s,int k){
        int[] freq = new int[100001];
        int l=0,dist=0,count=0;

        for(int r=0;r<s.length;r++){
            if(freq[s[r]] == 0) dist++;
            freq[s[r]]++;

            while(dist>k){
                freq[s[l]]--;
                if(freq[s[l]] == 0) dist--;
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
}