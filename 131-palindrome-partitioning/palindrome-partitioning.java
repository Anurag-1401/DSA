class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        check(0,s,new ArrayList<>(),res);
        return res;
    }

    private void check(int start,String s,List<String> curr,List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(isPalin(s,start,i)){
                curr.add(s.substring(start,i+1));
                check(i+1,s,curr,res);
                curr.removeLast();
            }
        }
    }

    private boolean isPalin(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}