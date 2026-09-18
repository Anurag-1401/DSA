class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();


        for(int i = 0; i < nums.length; i++){
            
            int start = nums[i];
            StringBuffer sb = new StringBuffer();
            sb.append(start);

            while(i < nums.length - 1 && nums[i+1] == nums[i] + 1){
                i++;
            }

            if(start != nums[i]){
                sb.append("->");
                sb.append(nums[i]);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}