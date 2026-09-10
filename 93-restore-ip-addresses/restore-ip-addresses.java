public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> currentSegments, List<String> result) {
        if (currentSegments.size() == 4) {
            if (startIndex == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (startIndex + len > s.length()) {
                break;
            }

            String segment = s.substring(startIndex, startIndex + len);

            if (isValid(segment)) {
                currentSegments.add(segment);
                backtrack(s, startIndex + len, currentSegments, result);
                currentSegments.remove(currentSegments.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}
