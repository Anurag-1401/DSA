class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] memo = new Boolean[s.length()];

        return canBreak(0,memo,set,s);
    }

    private boolean canBreak(int i,Boolean[] memo,Set<String> set,String s){
        if(i==s.length()) return true;

        if(memo[i] != null) return memo[i];

        for(int j = i+1;j<=s.length();j++){
            if(set.contains(s.substring(i,j)) && canBreak(j,memo,set,s)){
                return memo[i] = true;
            }
        }
        return memo[i] = false;
    }
}