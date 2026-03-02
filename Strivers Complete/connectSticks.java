class Solution {
    public int connectSticks(List<Integer> sticks) {
        if(sticks == null || sticks.size() == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(sticks);
        int cost = 0;

        while(pq.size() > 1){
            int first = pq.poll();
            int sec = pq.poll();

            cost +=first+sec;
            pq.offer(first+sec);
        }
        return cost;
    }
}
