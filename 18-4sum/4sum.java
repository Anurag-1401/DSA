class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        long total = 0;
        int k=0,l=0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                k = j+1;l=nums.length-1;

                while(k<l){
                    total =(long) nums[i] + nums[j] +nums[k] +nums[l];
                    if(total == target){ 
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l])); 
                        k++;l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    } else if(total<target) k++;
                    else l--;
                }
            }
        }
        return res;
    }
}