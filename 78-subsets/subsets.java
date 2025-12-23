class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int i,int[] nums,List<Integer> curr,List<List<Integer>> res){
        if(i == nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        dfs(i+1,nums,curr,res);

        curr.add(nums[i]);
        dfs(i+1,nums,curr,res);
        curr.remove(curr.size()-1);
    }
}