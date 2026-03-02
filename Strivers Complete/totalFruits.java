class Solution {
    public int totalFruits(int[] fruits) {
        int[] freq = new int[100001];
        int l=0,maxL=0,dist=0;

        for(int r=0;r<fruits.length;r++){
            if(freq[fruits[r]] == 0) dist++;
            freq[fruits[r]]++;

            while(dist>2){
                freq[fruits[l]]--;
                if(freq[fruits[l]] == 0) dist--;
                l++;
            }

            int curr = r-l+1;
            if(curr > maxL) maxL = curr;
        }
        return maxL;
    }
}
