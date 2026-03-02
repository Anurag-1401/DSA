class Solution {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[4];

        prev[0] = Math.max(matrix[0][1],matrix[0][2]);
        prev[1] = Math.max(matrix[0][0],matrix[0][2]);
        prev[2] = Math.max(matrix[0][0],matrix[0][1]);
        prev[3] = Math.max(matrix[0][0],Math.max(matrix[0][1],matrix[0][2]));

        for(int day = 1;day<n;day++){
            int[] curr = new int[4];
            for(int last=0;last<4;last++){
                for(int task = 0;task<3;task++){
                    if(task!=last){
                        int point = matrix[day][task]+prev[task];
                        curr[last] = Math.max(curr[last],point);
                    }
                }
            }
            prev = curr;
        }
        return prev[3];
    }
}
