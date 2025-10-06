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

        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;

        backtrack(res,new StringBuilder(),digits,0);
        return res;
    }
    private void backtrack(List<String> res,StringBuilder current,String digits,int index){
        if(index == digits.length()){
            res.add(current.toString());
            return;
        }

        String letter = KEYPAD[digits.charAt(index) - '0'];
        for(char ch : letter.toCharArray()){
            current.append(ch);
            backtrack(res,current,digits,index+1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}