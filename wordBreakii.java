class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, dict, memo);
    }

    private List<String> backtrack(String s, Set<String> dict, Map<String, List<String>> memo) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (dict.contains(prefix)) {
                List<String> suffixWays = backtrack(s.substring(i), dict, memo);

                for (String way : suffixWays) {
                    result.add(prefix + (way.isEmpty() ? "" : " ") + way);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
