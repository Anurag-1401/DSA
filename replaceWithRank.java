class Solution {
    public List<Integer> replaceWithRank(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n:arr) pq.offer(n);

        Map<Integer,Integer> map = new HashMap<>();
        int rank = 1;

        while(!pq.isEmpty()){
            int num = pq.poll();
            if(!map.containsKey(num)) map.put(num,rank++);
        }

        List<Integer> res = new ArrayList<>();
        for(int  n : arr){
            res.add(map.get(n));
        }

        return res;
    }
}
