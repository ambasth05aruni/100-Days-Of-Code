class Solution {
    public String removeStars(String s) {
         StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '*'){
                count++;
                continue;
            }
            if (count > 0) {
                count--;
                continue;
            }
            sb.append(s.charAt(i));

            
            
        }
        return sb.reverse().toString();
    }
}