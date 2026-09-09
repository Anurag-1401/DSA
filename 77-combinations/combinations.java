class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        solve(new ArrayList<>(),1,n,k,res);
        return res;
    }

    private void solve(List<Integer> curr,int i,int n,int k,List<List<Integer>> res){
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int idx = i;idx<=n;idx++){
            curr.add(idx);
            solve(curr,idx+1,n,k,res);
            curr.remove(curr.size()-1);
        }
    }
}