class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1=0,cand2=0,c1=0,c2=0;

        for(int num:nums){
            if(cand1 == num)c1++;
            else if (cand2==num)c2++;
            else if(c1==0){
                cand1=num;
                c1=1;
            } else if(c2==0) {
                cand2=num;
                c2=1;
            } else{
                c1--;c2--;
            }
        }

        c1=0;c2=0;

        for(int num:nums){
            if(num==cand1) c1++;
            else if(num==cand2)c2++;
        }

        List<Integer> res = new ArrayList<>();
        if(c1>nums.length/3) res.add(cand1);
        if(c2>nums.length/3) res.add(cand2); 

        return res;
    }
}