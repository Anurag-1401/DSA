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
//         Map<Integer,Integer> map = new HashMap<>();
//         int n1 = nums1.length;
//         int n2 = nums2.length;
        
//         int[] st  = new  int[n2];
//         int top = -1;
    
//         for(int n:nums2){
//             while(top>=0 && n>st[top]) map.put(st[top--],n);
//             st[++top] = n;
//         }

//         while(top>=0) map.put(st[top--],-1);

//         int[] ans = new int[n1];

//         for(int i=0;i<n1;i++){
//             ans[i] = map.get(nums1[i]);
//         }

//         return ans;
//     }
// }
