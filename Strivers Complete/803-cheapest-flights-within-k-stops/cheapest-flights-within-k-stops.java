class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;

        for (int i = 0 ; i <= k ; i++) {
            if (!relaxEdge(flights, minPrice)) break;
        }
        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }

    boolean relaxEdge(int[][] flights, int[] minPrice) {
        boolean res = false;
        int[] minCopy = Arrays.copyOf(minPrice, minPrice.length);

        for (int[] f : flights) { 
            int src = f[0];
            int des = f[1];
            int cost = f[2];
            if (minCopy[src] != Integer.MAX_VALUE && cost + minCopy[src] < minPrice[des]) {
                minPrice[des] = cost + minCopy[src];
                res = true;
            }
        }

        return res;
    }
}