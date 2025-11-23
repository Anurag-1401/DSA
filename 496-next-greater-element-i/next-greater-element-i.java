class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arrIdx = new int[10001];

        for(int i = 0;i <n2;i++){
            arrIdx[nums2[i]] = i;
        }

        for(int i = 0;i < n1;i++){
            nums1[i] = findNextgreater(nums2,nums1[i],arrIdx,n2);
        }

        return nums1;
    }

    public int findNextgreater(int[] arr,int greater,int[] arrIdx,int n){

        for(int i = arrIdx[greater] + 1;i < n;i++){
            if(arr[i] > greater){
                return arr[i];
            }
        }

        return -1;
    }
}

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         // HashMap<Integer,Integer> greater = new HashMap<>();
//         Deque<Integer> stack = new ArrayDeque<>();

//         // for(int num: nums2){
//         //     while(!stack.isEmpty() && num > stack.peek()){
//         //         greater.put(stack.peek(),num);
//         //     }
//         //     stack.push(num);
//         // }

//         // while(!stack.isEmpty()){
//         //     greater.put(stack.peek(),-1);
//         // }

//         int[] next = new int[10001];
//         Arrays.fill(next,-1);

//         for(int num:nums2){
//             while(!stack.isEmpty() && stack.peek() < num){
//                 next[stack.pop()] = num;
//             }
//             stack.push(num);
//         }

//         int[] ans = new int[nums1.length];
//         for(int i = 0;i < nums1.length;i++){
//             // ans[i] = greater.get(nums1[i]);
//             ans[i] = next[nums1[i]];
//         }
//         return ans;
//     }
// }