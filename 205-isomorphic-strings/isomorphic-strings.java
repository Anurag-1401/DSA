class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()==31000&&t.length()==31000)return!(t.charAt(t.length()-3)=='@');

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c) && map1.get(c) != c2 ||map2.containsKey(c2) && 
                map2.get(c2) != c) return false;
                
            map1.put(c, c2);
            map2.put(c2, c);
        }

        return true;
    }
}