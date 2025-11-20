class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (Long.valueOf(num) > Integer.MAX_VALUE) return result;
        char[] nums = num.toCharArray();
        char[] path = new char[nums.length * 2 - 1];
        long val = 0;
        for (int i = 0; i < nums.length; i++) {
            val = val * 10 + nums[i] - '0';
            path[i] = nums[i];        
            addOperators(result, target, nums, path, 0, val, i + 1, i + 1);
            if (val == 0) break;
        }
        return result;
    }
    private void addOperators(List<String> result, int target, char[] nums, char[] path, long leftValue, 
long rightValue, int numsPos, int pathPos) {
        if (numsPos == nums.length) {
            if (leftValue + rightValue == target)
            result.add(new String(path, 0, pathPos));
            return;
        }
        long val = 0;
        int j = pathPos + 1;
        for (int i = numsPos; i < nums.length; i++) {
            val = val * 10 + nums[i] - '0';
            path[j++] = nums[i];
            path[pathPos] = '+';
            addOperators(result, target, nums, path, leftValue + rightValue, val, i + 1, j);
            path[pathPos] = '-';
            addOperators(result, target, nums, path, leftValue + rightValue, -val, i + 1, j);
            path[pathPos] = '*';
            addOperators(result, target, nums, path, leftValue, rightValue * val, i + 1, j);
            if (nums[numsPos] == '0') return;
        }
    }
}
