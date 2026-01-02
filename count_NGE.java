class Solution {
    public List<Integer> count_NGE(int[] arr, int[] indices) {
        List<Integer> ans = new ArrayList<>();

        int n = arr.length;
    

        for(int j = 0;j<indices.length;j++){
            int idx = indices[j];
            int count = 0;

            for(int i=idx+1;i<n;i++){
                if(arr[i] > arr[idx]) count++;
            }
            ans.add(count);
        }

        return ans;
    }
}
