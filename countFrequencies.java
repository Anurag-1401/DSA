class Solution {
    public List<List<Integer>> countFrequencies(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Build result
        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());    // element
            pair.add(entry.getValue());  // frequency

            res.add(pair);
        }

        return res;
    }
}
