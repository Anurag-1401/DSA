class Solution {
    public void subset(int i, int[] arr, List<Integer>ans,List<List<Integer>> fans){
        
        if(i==arr.length){
            ArrayList<Integer> list = new ArrayList<>();
        for(int j=0;j<ans.size();j++){
          list.add(ans.get(j));
        }
            fans.add(list);
            return;
        }
        
        
        subset(i+1,arr,ans,fans);
        ans.add(arr[i]);
        subset(i+1,arr,ans,fans);
        ans.remove(ans.size()-1);

    }
    public List<List<Integer>> subsets(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> fans = new ArrayList<>();
         subset(0,arr,ans,fans);
         return fans;

    }
}