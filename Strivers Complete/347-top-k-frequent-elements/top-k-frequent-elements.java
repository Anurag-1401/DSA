class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int min=nums[0],max=nums[0];

        for(int n:nums){
          if(n<min) min=n;
          if(n>max) max=n;
        }

        int[] count=new int[max-min+1];

        for(int i:nums) count[i-min]++;

        int n=nums.length;
        List<Integer>[] bucket=new ArrayList[n+1];

        for(int i=0;i<count.length;i++){
          int freq=count[i];
          if(freq>0){
            if(bucket[freq]==null) bucket[freq]=new ArrayList<>();
            bucket[freq].add(i+min);
          }
        }

        int[] result=new int[k];
        int index=0;

        for(int i=bucket.length-1;i>=0 && index<k;i--){
          if(bucket[i]!=null){
            for(int num:bucket[i]){
              result[index++]=num;
              if(index==k)  break;
            }
          }
        }
        return result;
    }
}