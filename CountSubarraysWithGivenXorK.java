class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
      int count =0,xor=0,diff=0;

      HashMap<Integer,Integer> map = new HashMap<>();
      map.put(0,1);
      
      for(int num:nums){
        xor^=num;
        diff = xor ^ k;

        if(map.containsKey(diff)) count+=map.get(diff);

        map.put(xor,map.getOrDefault(xor,0)+1);
      }
      return count;
    }
}
