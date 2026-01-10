class Twitter {

    private int time = 0;
    private Map<Integer,Set<Integer>> follower;
    private Map<Integer,List<Tweet>> tweet;

    private class Tweet{
        int id;
        int time;

        Tweet(int id,int time){
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        follower = new HashMap<>();
        tweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.putIfAbsent(userId,new ArrayList<>());
        tweet.get(userId).add(new Tweet(tweetId,time++));

        follow(userId,userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!follower.containsKey(userId)) return res;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);

        for(int followeeId:follower.get(userId)){
            List<Tweet> tList = tweet.getOrDefault(followeeId,new ArrayList<>());
            for(Tweet t:tList) pq.offer(t);
        }

        int count = 0;
        while(!pq.isEmpty() && count<10){
            res.add(pq.poll().id);
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follower.putIfAbsent(followerId,new HashSet<>());
        follower.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follower.containsKey(followerId) && followerId!=followeeId){
            follower.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */