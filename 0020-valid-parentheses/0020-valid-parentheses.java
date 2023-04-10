class Solution {
    public boolean isValid(String s) {
        char[] l=s.toCharArray();
     Stack<Character> stk = new Stack<>();  
     for(int i=0;i<l.length;i++){
         if(l[i]=='{'|| l[i]=='['|| l[i]=='(')
         stk.push(l[i]);
          else if (l[i] == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else if (l[i] == '}' && !stk.isEmpty() && stk.peek() == '{') {
                stk.pop();
            } else if (l[i] == ']' && !stk.isEmpty() &&stk.peek() == '[') {
                stk.pop();
            }
            else
            return false;
     }
     return stk.isEmpty();
    }
}