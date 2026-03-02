class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> res = new ArrayList<>();
        sum(0,0,nums,res);
        return res;
    }

    private void sum(int i,int s,int[] nums,List<Integer> res){
        if(i == nums.length){
            res.add(s);
            return;
        }

        sum(i+1,s+nums[i],nums,res);

        sum(i+1,s,nums,res);
    }
}
