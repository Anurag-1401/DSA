class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int freqmap[] = new int[21];
        for (int num: nums)
            freqmap[num+10]++;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        backtrack(res, freqmap, curr, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res,int[] freqmap, List<Integer> curr, int i){
        if (i > 20){
            res.add(new LinkedList(curr));
            return;
        }
        backtrack(res, freqmap, curr, i+1);
        if (freqmap[i] >0){
            curr.add(i-10);
            freqmap[i]--;
            backtrack(res,freqmap, curr, i);
            curr.removeLast();
            freqmap[i]++;
        }
    }

}