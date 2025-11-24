class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long sumMax = 0;
        long sumMin = 0;

        Stack<Integer> st = new Stack<>();

        // ------- Contribution as Maximum --------
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                sumMax += (long) nums[mid] * left * right;
            }
            st.push(i);
        }

        st.clear();

        // ------- Contribution as Minimum --------
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                sumMin += (long) nums[mid] * left * right;
            }
            st.push(i);
        }

        return sumMax - sumMin;
    }
}
