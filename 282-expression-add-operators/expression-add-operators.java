class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(0, "", 0, 0, num, target, res);
        return res;
    }

    void dfs(int idx, String path, long calc, long tail, String num, int target, List<String> res) {

        // If end of string reached
        if (idx == num.length()) {
            if (calc == target) res.add(path);
            return;
        }

        long curr = 0;
        for (int i = idx; i < num.length(); i++) {

            // Leading zero check
            if (i > idx && num.charAt(idx) == '0') break;

            curr = curr * 10 + (num.charAt(i) - '0');

            if (idx == 0) {
                // First number can't have operator before it
                dfs(i + 1, path + curr, curr, curr, num, target, res);
            } else {
                dfs(i + 1, path + "+" + curr, calc + curr, curr, num, target, res);
                dfs(i + 1, path + "-" + curr, calc - curr, -curr, num, target, res);

                // Multiplication fixes previous operation using tail
                dfs(i + 1, path + "*" + curr, calc - tail + tail * curr, tail * curr, num, target, res);
            }
        }
    }
}
