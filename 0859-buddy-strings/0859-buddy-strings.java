class Solution {
    public boolean buddyStrings(String s, String goal) {
       if(s.length() != goal.length()) return false;
if(s.length() != goal.length()) return false;

        int n = s.length();

        int [] arrs = new int[26]; //array to fill count of each chars in string s
        int [] arrg = new int[26]; //array to fill count of each chars in string goal

        int diffChar = 0;

        //In this loop we will fill the count of characters in both array and also we will try to find out
        //number of different characters in both the strings
        for(int i = 0; i < n; i++){
            arrs[s.charAt(i)-97]++;
            arrg[goal.charAt(i)-97]++;
            if(s.charAt(i) != goal.charAt(i)) diffChar++;
        }

        //If diffChar is greater than 2 then we can not make the string same by one swap (eg: abc, cba)
        if(diffChar > 2) return false;

        boolean isTwoOrMoreCharsSame = false;

        //Now we know that diffChar is either 0 or 1
        //If we have 0 diffChar then we also have to check whether two elements are same or 
        //not so that we can swap them

        //In the loop we will check whether both the strings have same characters or not, 
        //if(diffChar == 1 then it will not be same)
        //if(diffChar == 2 then it Should be same otherwise 
        //we will return false by Checking arrs[i] != arrg[i])

        for(int i = 0; i < 26; i++){
            if(arrs[i] != arrg[i]) return false; //If diff no of characters return false
            if(!isTwoOrMoreCharsSame && arrs[i] == arrg[i]){
                if(arrs[i] >= 2) isTwoOrMoreCharsSame= true;
            }
        }

        //We are here which means number of character are same
        //if(diffChar == 2) we can swap them
        //if isTwoOrMoreCharsSame = true then we can swap similar elements
        //In both cases we will return false

        if(diffChar == 2 || isTwoOrMoreCharsSame) return true;

        //If character are same and two characters are not same then again there is nothing to swap
        //so return false
        return false;

        /**
            TC- O(n + 26) = O(n) as 26 will not change if we increase or decrease the input size 
            //also it is constant so we can ignore
            SC- O(1) as 26 is a constant and it will not vary if we increase or decrease the input size
         */
      
    }
}