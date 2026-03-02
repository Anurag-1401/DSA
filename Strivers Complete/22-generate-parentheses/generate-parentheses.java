class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n,n,new StringBuilder(),res);
        return res;
    }

    private void dfs(int l,int r,StringBuilder sb,List<String> res){
        if(l==0 && r==0){
            res.add(sb.toString());
            return;
        }

        if(l>0){
            sb.append('(');
            dfs(l-1,r,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(l<r){
            sb.append(')');
            dfs(l,r-1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}