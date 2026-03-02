class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int ele : asteroids) {
            if (ele > 0) {
                stack[++top] = ele;
            } else {
                while (top >= 0 && stack[top] > 0 && stack[top] < Math.abs(ele)) {
                    top--;
                }

                if (top == -1 || stack[top] < 0) {
                    stack[++top] = ele;
                } else if (stack[top] == Math.abs(ele)) {
                    top--;
                }
            }
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}