class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        sum(0,new ArrayList<>(),res,candidates,k);
        return res;
    }

    private void sum(int start,List<Integer> curr,List<List<Integer>> res,int[] c,int k){
        if(k==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<c.length;i++){
            if(i>start && c[i] == c[i-1]) continue;

            if(c[i]>k) break;

            curr.add(c[i]);
            sum(i+1,curr,res,c,k-c[i]);
            curr.removeLast();
        }
    }
}