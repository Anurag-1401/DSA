class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int s:stones) pq.add(s);

        while(pq.size() > 1) {
            int first = pq.poll();
            int sec = pq.poll();
        
            if(first != sec){
                pq.add(first - sec);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek(); 
    }
}
