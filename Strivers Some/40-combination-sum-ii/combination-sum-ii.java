class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int[] freq = new int[51];
        for(int num: candidates) {
            freq[num]++;
        }

        backtrack(freq, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] freq, int target, List<List<Integer>> res, List<Integer> currComb, int idx) {
        if (target < 0)
            return;
        
        if (target == 0) {
            res.add(new ArrayList<>(currComb));
            return;
        }

        for (int i=idx; i<freq.length && i <= target; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                currComb.add(i);
                backtrack(freq, target-i, res, currComb, i);
                currComb.removeLast();
                freq[i]++;
            }
        }
    }
}