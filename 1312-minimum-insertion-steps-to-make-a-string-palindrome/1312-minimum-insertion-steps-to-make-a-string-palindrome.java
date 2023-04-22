class Solution {
    public int minInsertions(String s) {
       StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        
        int [][] dp = new int[s.length()+1][s1.length()+1];
      
        for(int i=1;i<=s.length();i++)
        {
            for(int j =1;j<=s1.length();j++)
            {
                if(s.charAt(i-1) == s1.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return s.length() - dp[s.length()][s1.length()];  
    }
}