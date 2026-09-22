class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length+1];
        for(int n:nums){
            if(arr[n]>0) return n;
            arr[n] = 1;
        }
        return -1;
    }
}

// class Solution {
//     public int findDuplicate(int[] nums) {
//       for(int i = 0; i < nums.length; i++){
//             int value = nums[i];
//             int index;

//             if(value < 0){
//                 index = -value;
//             }
//             else{
//                 index = value;
//             }

//             if(nums[index] < 0){
//                 return index;
//             }
           
//             nums[index] = -nums[index];

//       }
//        return -1;
//     }
// }