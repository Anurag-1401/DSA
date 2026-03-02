class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int[] freq = new int[nums.length+1];
        int[] ans = new int[2];
        for(int x:nums) freq[x]++;

        for(int i=0;i<freq.length;i++){
            if(freq[i] == 2) ans[0] = i;
            if(freq[i] == 0) ans[1] = i;
        }
        return ans;
    }
}
