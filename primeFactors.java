class Solution {
        public List<List<Integer>> primeFactors(int[] queries) {
            List<List<Integer>> res = new ArrayList<>();

            for(int n:queries){
                res.add(find(n));
            }

            return res;
        }

        private List<Integer> find(int n){
            List<Integer> ans = new ArrayList<>();

            while((n&1)==0) {
                ans.add(2);
                n>>=1;
            }

            for(int i=3;i*i<=n;i+=2){
                while(n%i==0){
                    ans.add(i);
                    n/=i;
                }
            }

            if(n>1) ans.add(n);

            return ans;
        }
}
