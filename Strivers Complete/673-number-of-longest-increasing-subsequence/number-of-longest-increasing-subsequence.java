class Solution {

    private void collect(List<List<int[]>> seqs, int num, int idx){
        if(seqs.size() == idx) seqs.add(new ArrayList<>());
        int[] cur = new int[]{num, 0};
        if(idx == 0) cur[1] = 1;
        else{
            for(int[] seq: seqs.get(idx-1)){
                if(seq[0] < cur[0]) cur[1] += seq[1];
            }
        }
        seqs.get(idx).add(cur);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int length = 0;
        List<List<int[]>> seqs = new ArrayList<>();
        for(int num:nums){
            int idx = Arrays.binarySearch(dp, 0, length, num);
            if(idx<0) idx = -(idx + 1);
            dp[idx] = num;
            if(length == idx) length++;

            //question specific
            collect(seqs, num, idx);
        }
        int res = 0;
        for(int[] seq: seqs.get(seqs.size()-1)){
            res += seq[1];
        }
        return res;
    }
}