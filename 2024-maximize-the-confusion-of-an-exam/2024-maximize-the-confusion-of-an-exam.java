class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
      int ans = 0;
		char[] arr = answerKey.toCharArray();
		int n = arr.length;
		int start = 0, copyK = k;
		// For true row
		for (int end = 0; end < n; end++) {
			if (arr[end] == 'F') {
				k--;
				while (k < 0 && start <= end) {
					if (arr[start] == 'F')
						k++;
					start++;
				}
			}
			ans = Math.max(ans, end-start+1);
		}
		k = copyK;
		start = 0;
		// For false row
		for (int end = 0; end < n; end++) {
			if (arr[end] == 'T') {
				k--;
				while (k < 0 && start <= end) {
					if (arr[start] == 'T')
						k++;
					start++;
				}
			}
			ans = Math.max(ans, end-start+1);
		}
		return ans;  
    }
}