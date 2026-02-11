class Solution {
    public int minInsertions(String text) {

        char[] travel = text.toCharArray();
        int size = travel.length;

        int[] grid = new int[size];

        int diag, temp;

        for (int index = size - 1; index >= 0; index--) {

            diag = 0;
            grid[index] = 1;

            for (int comp = index + 1; comp < size; comp++) {

                temp = grid[comp];

                if (travel[index] == travel[comp]) {
                    grid[comp] = diag + 2;
                } else {
                    grid[comp] = Math.max(grid[comp], grid[comp - 1]);
                }

                diag = temp;
            }
        }

        int lps = grid[size - 1];

        return size - lps;
    }
}
