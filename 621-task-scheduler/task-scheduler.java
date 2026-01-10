class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> mh = new PriorityQueue<>((a,b)->b-a);

        int[]freq = new int[26];
        for(char c:tasks) freq[c-'A']++;

        for(int f :freq){
            if(f>0) mh.offer(f);
        }

        int time=0;

        while(!mh.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;

            while(cycle>0 && !mh.isEmpty()){
                int curr = mh.poll();
                if(curr - 1 > 0) temp.add(curr-1);
                time++;
                cycle--;
            }

            for(int t:temp) mh.offer(t);

            if(!mh.isEmpty()) time+=cycle;
        }
        return time;
    }
}