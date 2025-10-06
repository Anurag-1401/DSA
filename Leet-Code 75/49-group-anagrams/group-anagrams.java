class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> group = new HashMap<>();

        for(String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String key = new String(c);

            if(!group.containsKey(key)){
                group.put(key,new ArrayList<>());
            }
            group.get(key).add(s);
        }
        return new ArrayList<>(group.values());
    }
}