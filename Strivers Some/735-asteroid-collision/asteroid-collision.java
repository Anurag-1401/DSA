class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int ele : asteroids) {
            if (ele > 0) {
                // Peaceful right-mover
                stack[++top] = ele;
            } else {
                // Incoming left-mover... trouble begins
                while (top >= 0 && stack[top] > 0 && stack[top] < Math.abs(ele)) {
                    // Boom! Smaller right-mover destroyed
                    top--;
                }

                if (top == -1 || stack[top] < 0) {
                    // Nobody left or all going left — this guy survives
                    stack[++top] = ele;
                } else if (stack[top] == Math.abs(ele)) {
                    // Equal sizes => both go kaboom
                    top--;
                }
                // If top > Math.abs(ele), the current one explodes silently. RIP.
            }
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}