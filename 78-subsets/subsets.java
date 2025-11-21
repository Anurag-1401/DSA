// class Solution {
//     public void subset(int i, int[] arr, List<Integer>ans,List<List<Integer>> fans){
        
//         if(i==arr.length){
//             ArrayList<Integer> list = new ArrayList<>();
//         for(int j=0;j<ans.size();j++){
//           list.add(ans.get(j));
//         }
//             fans.add(list);
//             return;
//         }
        
        
//         subset(i+1,arr,ans,fans);
//         ans.add(arr[i]);
//         subset(i+1,arr,ans,fans);
//         ans.remove(ans.size()-1);

//     }
//     public List<List<Integer>> subsets(int[] arr) {
//         List<Integer> ans = new ArrayList<>();
//         List<List<Integer>> fans = new ArrayList<>();
//          subset(0,arr,ans,fans);
//          return fans;

//     }
// }


import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n; // 2^n
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // check if ith bit in mask is 1
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
