class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            // char[] c = str.toCharArray();
            // Arrays.sort(c);

            int[] arr = new int[26];
            for(char c:str.toCharArray()){
                arr[c-'a']++;
            }

            String key = Arrays.toString(arr);

            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
