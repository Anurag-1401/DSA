class Solution {
    public int maxDepth(String s) {
        int depth=0,maxD=0;

        for(char c:s.toCharArray()){
            if(c=='(') depth++;
            if(depth!=0) maxD = Math.max(maxD,depth);
            if(c==')') depth--;
        }
        return maxD;
    }
}