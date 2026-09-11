class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j== 0 || j == i) row.add(1);
                else row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}


// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> row = new ArrayList<>();

//         long value = 1;

//         for (int i = 0; i <= rowIndex; i++) {
//             row.add((int) value);

//             value = value * (rowIndex - i) / (i + 1);
//         }

//         return row;
//     }
// }