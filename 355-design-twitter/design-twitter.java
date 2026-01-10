class Twitter {

    class ListNode{
        int tweetId;
        int userId;
        ListNode next;

        ListNode(int t, int u){
            this.tweetId = t;
            this.userId = u;
            next = null;
        }
    }

    Map<Integer, int[]> map;
    ListNode head;

    private void addFirst(ListNode n){
        if(head==null)head=n;
        else {
            n.next = head;
            head = n;
        }
    }

    public Twitter() {
        map = new HashMap<>();
        head = null;
    }

    private void addUser(int userId){
        map.put(userId, new int[500]);
        int[] list = map.get(userId);
        list[userId] = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)) addUser(userId);
        addFirst(new ListNode(tweetId, userId));
    }
    
    public List<Integer> getNewsFeed(int user) {
        List<Integer> out = new ArrayList<>();
        int[] list = map.get(user);
        if(list==null)return out;
        ListNode temp = head;
        while(temp!=null && out.size()<10){
            int userId = temp.userId;
            if(list[userId]==1)out.add(temp.tweetId);
            temp=temp.next;
        }
        return out;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(!map.containsKey(followerId))map.put(followerId, new int[500]);
        int[] list = map.get(followerId);
        list[followeeId] = 1;
        list[followerId] = 1;
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(!map.containsKey(followerId))return;
        int[] list = map.get(followerId);
        list[followeeId]=0;
    }
}
 