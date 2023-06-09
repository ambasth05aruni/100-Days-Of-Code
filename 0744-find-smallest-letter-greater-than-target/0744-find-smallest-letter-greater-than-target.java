class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
          int start=0;
        int end=letters.length-1;

        while(start<end){

            int mid=(start+end)/2;

            if(letters[mid]<=target){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        if(letters[start]<=target){
            return letters[0];
        }

        return letters[start];
         
    }
}