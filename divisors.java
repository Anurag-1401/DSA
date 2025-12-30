class Solution {
    public int[] divisors(int n) {
        List<Integer> res = new ArrayList<>();

        for(int i=1;i*i<=n;i++){
            if(n%i==0) {
                res.add(i);
                if(i!=n/i){
                    res.add(n/i);
                }
            }
        }
        Collections.sort(res);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
