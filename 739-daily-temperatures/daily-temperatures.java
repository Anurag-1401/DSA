class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length,prev=0,top=-1;
        int[] ans = new int[n];
        // Stack<Integer> stack = new Stack<>();
        // Deque<Integer> stack = new ArrayDeque<>();
        int[] stack = new int[n];

        for(int i = 0;i < n;i++){
            // while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                while(top>=0 && temperatures[i] > temperatures[stack[top]]){
                prev = stack[top--];
                ans[prev] = i - prev;
            }
            stack[++top] = i;
        }    
        return ans;
    }
}