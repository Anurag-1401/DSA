class Solution {
    public boolean findSuccessor(int i, int[] hand, int groupSize)  {
        int start = hand[i] + 1;
        i += 1;
        int size = 1;
        while(i < hand.length && size < groupSize){
            if(hand[i] == start) {
                start += 1;
                hand[i] = -1;
                size++;
            } 
            i++;
        }
        return size == groupSize;
    } 
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        for(int i = 0; i < hand.length; i++) {
            if(hand[i] != -1) {
                if(!findSuccessor(i, hand, groupSize)) return false;
            }
        }
        return true;
    }
}