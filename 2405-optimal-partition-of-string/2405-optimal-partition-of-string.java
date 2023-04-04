class Solution {
    public int partitionString(String s) {
      int map = 0;
        int count = 1;
        for(char c : s.toCharArray()){
            if((map & (1<<c)) != 0) {
                count++;
                map = 0;
            }
            map ^= (1<<c);
        }
        return count;   
    }
}