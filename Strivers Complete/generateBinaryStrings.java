class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> res = new ArrayList<>();
        solve(n,"",res);
        return res;
    }

    private void solve(int n,String curr,List<String> res){
        if(curr.length() == n){
            res.add(curr);
            return;
        }

        solve(n,curr+"0",res);

        if(curr.isEmpty() || curr.charAt(curr.length() -1) != '1'){
            solve(n,curr+'1',res);
        }
    }
}
