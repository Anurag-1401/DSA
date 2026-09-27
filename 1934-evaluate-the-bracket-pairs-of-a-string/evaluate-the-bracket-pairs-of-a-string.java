import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Store knowledge pairs in a HashMap for O(1) lookups
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Parse string s
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = i + 1;
                // Find closing bracket
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                // Extract key inside brackets
                String key = s.substring(i + 1, j);
                result.append(map.getOrDefault(key, "?"));
                i = j + 1; // Move pointer past ')'
            } else {
                result.append(c);
                i++;
            }
        }

        return result.toString();
    }
}