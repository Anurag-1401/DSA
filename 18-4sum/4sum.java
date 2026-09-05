class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n  = nums.length;

        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;

            long s1 = (long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            if(s1>target) break;
            s1 = (long) nums[i] + nums[n-3] + nums[n-2] + nums[n-1];
            if(s1<target) continue;

            int t1 = target - nums[i];

            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j-1] == nums[j]) continue;

                long s2 = (long) nums[j] + nums[j+1] + nums[j+2];
                if(s2>t1) break;
                s2 = (long) nums[j] + nums[n-2] + nums[n-1];
                if(s2<t1) continue;

                int t2 = t1 - nums[j];

                for(int k=j+1,l=n-1;k<l;){
                    long sum = (long) nums[k] + nums[l];
                    if (sum == t2) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < t2) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}