class Solution {
    public boolean isValid(String s) {
        Stack<Character> para = new Stack<>();

        for (char c : s.toCharArray()){
            if(c =='(' || c=='{' || c=='[') para.push(c);
            else {
                if(para.isEmpty()) return false;
                char top = para.pop();
                if(top == '(' && c!=')' || top == '{' && c!='}' || top == '[' && c!=']') return false;
            }
        }
        return para.isEmpty();
    }
}




// class Solution {
//     public boolean isValid(String s) {
//         char[] arr=new char[s.length()];
//         int top=-1;
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch=='(' || ch=='{' || ch=='['){
//                 top++;
//                 arr[top]=ch;
//             }
//             else{
//                 if(top==-1){
//                     return false;
//                 }
//                 char last=arr[top];
//                 top--;
//                 if(ch==')' && last !='('){
//                     return false;
//                 }
//                 if(ch=='}' && last !='{'){
//                     return false;
//                 }
//                 if(ch==']' && last !='['){
//                     return false;
//                 }

//             }
//         }
//         if(top==-1){
//             return true;
//         }
//         else{
//             return false;
//         }
        
//     }
// }