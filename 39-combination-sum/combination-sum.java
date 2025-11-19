class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        recursion(0 , ans , new ArrayList<>() , target , candidates);

        return ans;
        
    }

    public void recursion(int index , List<List<Integer>> ans , List<Integer> list, int target , int[] arr){

        if(target == 0){

            ans.add(new ArrayList<>(list));
        }

        for(int i = index ; i < arr.length ; i++){

            if(arr[i] > target) continue;

            list.add(arr[i]);
            recursion(i , ans , list , target-arr[i] , arr);
            list.remove(list.size()-1);
        }
    }
}