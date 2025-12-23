class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int k) {
        List<List<Integer>> res = new ArrayList<>();
        sum(0,new ArrayList<Integer>(),res,candidates,k);
        return res;
    }

    private void sum(int i,List<Integer> curr,List<List<Integer>> res,int[] c,int k){
        if(k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i == c.length || k<0) return;

        curr.add(c[i]);
        sum(i,curr,res,c,k-c[i]);
        curr.remove(curr.size()-1);
        sum(i+1,curr,res,c,k);
    }
}