class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;i++){
            int l = i+1,r = nums.length-1;

            while(l<r){
                int t = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-t) < Math.abs(target-ans)) ans=t;
                if(t<target) l++;
                else if(t>target) r--;
                else return t;
            }
        }
        return ans;
    }
}