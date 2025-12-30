class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0;

        boolean[] arr = new boolean[n];
        int count = n/2;

        for(int i=3;i*i<n;i+=2){
            if(!arr[i]){
                for(int j=i*i;j<n;j+=2*i){
                    if(!arr[j]){
                        arr[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}