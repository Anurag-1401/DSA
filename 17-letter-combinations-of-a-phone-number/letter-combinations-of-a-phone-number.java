class Solution {
    public String[] KEYPAD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;
        check(0,new StringBuilder(),digits,res);
        return res;
    }

    private void check(int i,StringBuilder sb,String digits,List<String> res){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }

        String ch = KEYPAD[digits.charAt(i)-'0'];

        for(char c:ch.toCharArray()){
            sb.append(c);
            check(i+1,sb,digits,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}