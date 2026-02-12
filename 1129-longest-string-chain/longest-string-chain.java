class Solution {
    public int longestStrChain(String[] a) {
        Arrays.sort(a,(x,y)->x.length()-y.length());
        int n=a.length, dp[]=new int[n], max=1;
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[j].length()+1<a[i].length()) continue;
                if(a[j].length()+1>a[i].length()) break;

                if(isPredecessor(a[j],a[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    boolean isPredecessor(String a, String b){
        int n1=a.length(), n2=b.length(), i=0, j=0;
        boolean skipped=false;
        
        while(i<n1 && j<n2){
            if(a.charAt(i)==b.charAt(j)){
                ++i;
                ++j;
            }
            else{
                if(skipped) return false;
                skipped=true;
                j++;
            }
        }
        return true;
    }
}