class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] count = new char[26];
            for(char a : s.toCharArray()) {
                count[a-'a']++;
            }
            String k = new String(count);
            List<String> curr = map.get(k);
            if(curr == null) {
                curr = new ArrayList<>();
                map.put(k, curr);
            }
            curr.add(s);
        }
        return new ArrayList<>(map.values());
    }
}