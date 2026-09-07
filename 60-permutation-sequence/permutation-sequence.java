class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();

        int fact = 1;
        for(int i=1;i<n;i++){
            fact*=i;
            num.add(i);
        }
        num.add(n);
        k -=1;

        StringBuilder sb = new StringBuilder();

        while(true){
            int i = k/fact;
            sb.append(num.get(i));
            num.remove(i);

            if(num.isEmpty()) break;

            k%=fact;
            fact/=num.size();
        }
        return sb.toString();
    }
}