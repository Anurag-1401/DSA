class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        char[] c;
        String key = "";

        for(String str : strs){
            c = str.toCharArray();
            Arrays.sort(c);
            key = new String(c);
            if(!res.containsKey(key)) res.put(key,new ArrayList<>());
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}