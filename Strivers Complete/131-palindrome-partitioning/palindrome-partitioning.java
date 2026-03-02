class Solution {
    int n;
    boolean[][] isPalindrone;
    String[][] sub;
    List<List<String>> res;

    // public List<List<String>> partition(String s) {
    //     List<List<String>> res = new ArrayList<>();
    //     check(0,s,new ArrayList<>(),res);
    //     return res;
    // }

    // private void check(int start,String s,List<String> curr,List<List<String>> res){
    //     if(start == s.length()){
    //         res.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     for(int i=start;i<s.length();i++){
    //         if(isPalin(s,start,i)){
    //             curr.add(s.substring(start,i+1));
    //             check(i+1,s,curr,res);
    //             curr.removeLast();
    //         }
    //     }
    // }

    // private boolean isPalin(String s,int l,int r){
    //     while(l<r){
    //         if(s.charAt(l)!=s.charAt(r)) return false;
    //         l++;
    //         r--;
    //     }
    //     return true;
    // }


    public List<List<String>> partition(String s) {
        n = s.length();
        isPalindrone = new boolean[n+1][n+1];
        sub = new String[n+1][n+1];

        for(int i=0;i<n;i++) for(int j=i+1;j<=n;j++){
            sub[i][j] = s.substring(i,j);
            isPalindrone[i][j] = isPalin(sub[i][j]); 
        }

        res = new ArrayList<>();
        check(0,new ArrayList<>());
        return res;
    }

    private void check(int start,List<String> curr){
        if(start == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start+1;i<=n;i++){
            if(!isPalindrone[start][i]) continue;
                curr.add(sub[start][i]);
                check(i,curr);
                curr.removeLast();
        }
    }

    private boolean isPalin(String s){
        int l=0,r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}