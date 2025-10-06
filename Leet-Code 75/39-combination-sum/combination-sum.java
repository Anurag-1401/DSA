class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>> result,List<Integer> current,int[] cand,int t,int start){
        if (t == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start;i<cand.length;i++){
            if(cand[i]>t) break;
            current.add(cand[i]);
            backtrack(result,current,cand,t - cand[i],i);
            current.remove(current.size()-1);
        }
        
    }
}