class Solution {
    public boolean wordBreak(String s, List<String> wd) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s,wd,0,dp);
    }

    public boolean solve(String s, List<String> wd, int idx,Boolean[] dp){
        if(idx == s.length()){
            return true;
        }
        if(dp[idx] != null) return dp[idx];

        for(String word : wd){
            if(s.startsWith(word,idx)){
                if(solve(s,wd,idx+word.length(),dp)) return dp[idx] = true;
            }
        }
        return dp[idx] =false;
    }
}