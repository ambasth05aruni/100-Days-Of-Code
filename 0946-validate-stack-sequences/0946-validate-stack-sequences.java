class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0,j=0;
       
      for (int item: pushed) {
            pushed[i] = item;
            while (i >= 0 && pushed[i] == popped[j]) {
                i--;
                j++;
            }
            i++;
        }
     return i == 0; 
    }
}