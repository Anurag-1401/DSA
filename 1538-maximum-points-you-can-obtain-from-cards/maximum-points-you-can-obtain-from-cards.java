class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total=0;
        for(int x:cardPoints) total+=x;

        if(k==cardPoints.length) return total;

        int window=cardPoints.length-k,sum=0,min=Integer.MAX_VALUE;

        for(int i=0;i<window;i++) sum+=cardPoints[i];
        
        min=Math.min(min,sum);
        for(int i=window;i<cardPoints.length;i++){
            sum=sum+cardPoints[i]-cardPoints[i-window];
            min=Math.min(min,sum);
        }
        
        return total-min;
    }
}