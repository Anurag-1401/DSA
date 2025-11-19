class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Required to skip duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> curr, List<List<Integer>> result) {

        if (target == 0) {                // Found a valid combination
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index == arr.length || target < 0) return;

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates
            if (i > index && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break; // No point in continuing

            curr.add(arr[i]);  // Choose element

            backtrack(i + 1, arr, target - arr[i], curr, result);

            curr.remove(curr.size() - 1); // Backtrack
        }
    }
}
