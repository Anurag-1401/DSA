class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1,boat=0;

        while(l<=r){
            if(people[l]+people[r] <= limit){
                l++;
                r--;
            } else r--;
            boat++;
        }
        return boat;
    }
}
