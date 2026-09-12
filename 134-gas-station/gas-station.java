class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0,curr = 0,start = 0;

        for(int i = 0;i<gas.length;i++){
            int gain = gas[i] - cost[i];
            total+=gain;
            curr+=gain;

            if(curr<0){
                start = i+1;
                curr = 0;
            }
        }
        return total>=0 ? start : -1;
    }
}