// class Solution {
//     public int splitArray(int[] nums, int k) {
//         int low = 0, high = 0, mid = 0, ans = 0;
//         for (int n : nums) {
//             low = Math.max(low, n);
//             high += n;
//         }

//         while (low <= high) {
//             mid = low + (high - low) / 2;
//             int cnt = 1, sum = 0;

//             for (int n : nums) {
//                 if (sum + n > mid) {
//                     cnt++;
//                     sum = 0;
//                 }
//                 sum += n;
//             }

//             if (cnt <= k) {
//                 ans = mid;
//                 high = mid - 1;
//             } else low = mid + 1;
//         }
//         return ans;
//     }
// }


class Solution {
    boolean canSplit(int []nums, int mid, int k) {
       int p=1,sum=0;
       for(int i=0;i<nums.length;i++)
       {
          if(sum+nums[i]<=mid)
          {
            sum=sum+nums[i];
          }
          else
          {
            p+=1;
            sum=nums[i];
            if(p>k)
            return false;
          }
       }
       return true;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int e=0,s=nums[0];
        for(int i=0;i<n;i++)
        {
             s = Math.max(s, nums[i]);
            e=e+nums[i];
        }
        int ans=s;
        while(s<=e)
        {
           int mid=s+(e-s)/2;
           if(canSplit(nums,mid,k))
            {
                ans=mid;
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return ans;    
    }
}