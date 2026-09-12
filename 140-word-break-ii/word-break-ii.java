class Solution {
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet);
    }

    private List<String> dfs(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixSentences = dfs(suffix, wordSet);

                for (String sentence : suffixSentences) {
                    result.add(prefix + (sentence.isEmpty() ? "" : " ") + sentence);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}