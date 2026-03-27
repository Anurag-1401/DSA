class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001];

    for (int[] t : trips) {
        changes[t[1]] += t[0];
        changes[t[2]] -= t[0];
    }

    int current = 0;

    for (int i = 0; i < 1001; i++) {
        current += changes[i];

        if (current > capacity) return false;
    }

    return true;
    }
}
