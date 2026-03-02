class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int freq[] = new int[21];
        for (int num: nums)
            freq[num+10]++;

        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, freq, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] freq, List<Integer> curr, int i){
        if (i > 20){
            res.add(new LinkedList(curr));
            return;
        }

        backtrack(res, freq, curr, i+1);

        if (freq[i] >0){
            curr.add(i-10);
            freq[i]--;
            backtrack(res,freq, curr, i);
            curr.removeLast();
            freq[i]++;
        }
    }
}