class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 2;

        int[] keys = new int[1024];
        int[] vals = new int[1024];
        int[] seen = new int[1024];
        int stamp = 0;

        for (int i = 0; i < n; i++) {
            if (ans >= n - i) break;

            stamp++;

            int xi = points[i][0];
            int yi = points[i][1];
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - xi;
                int dy = points[j][1] - yi;

                if (dx == 0) {
                    dx = 0;
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                    dy = 0;
                } else {
                    int a = dx < 0 ? -dx : dx;
                    int b = dy < 0 ? -dy : dy;

                    while (b != 0) {
                        int t = a % b;
                        a = b;
                        b = t;
                    }

                    dx /= a;
                    dy /= a;

                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                }

                int key = (dx << 16) | (dy & 0xFFFF);

                int h = (key * 0x9E3779B9) >>> 22;

                while (seen[h] == stamp) {
                    if (keys[h] == key) break;
                    h = (h + 1) & 1023;
                }

                if (seen[h] != stamp) {
                    seen[h] = stamp;
                    keys[h] = key;
                    vals[h] = 0;
                }

                int c = ++vals[h];
                if (c > localMax) localMax = c;
            }

            if (localMax + 1 > ans)
                ans = localMax + 1;
        }

        return ans;
    }
}