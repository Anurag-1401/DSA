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




// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         int n = nums.length;
//         int total  = 1<<n;

//         List<List<Integer>> res = new ArrayList<>();
//         for(int i=0;i<total;i++){
//             List<Integer> subset = new ArrayList<>();
//             for(int j=0;j<n;j++){
//                 if((i&(1<<j))!=0) subset.add(nums[j]);
//             }
//             res.add(subset);
//         }
//         return res;
//     }
// }
