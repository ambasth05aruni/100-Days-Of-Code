class Solution {
    public int lengthOfLastWord(String s) {
         int length = 0;
        s = s.trim();
        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) != ' ') {
            length++;
            start--;
        }
        return length;
    }
}