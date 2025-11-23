class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // HashMap<Integer,Integer> greater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // for(int num: nums2){
        //     while(!stack.isEmpty() && num > stack.peek()){
        //         greater.put(stack.peek(),num);
        //     }
        //     stack.push(num);
        // }

        // while(!stack.isEmpty()){
        //     greater.put(stack.peek(),-1);
        // }

        int[] next = new int[10001];
        Arrays.fill(next,-1);

        for(int num:nums2){
            while(!stack.isEmpty() && stack.peek() < num){
                next[stack.pop()] = num;
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0;i < nums1.length;i++){
            // ans[i] = greater.get(nums1[i]);
            ans[i] = next[nums1[i]];
        }
        return ans;
    }
}