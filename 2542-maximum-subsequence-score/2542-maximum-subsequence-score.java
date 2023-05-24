class Solution {
     record Pair(int nums1, int nums2){}
    public long maxScore(int[] nums1, int[] nums2, int k) {
              int n = nums1.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) pairs[i] = new Pair(nums1[i], nums2[i]);
        Arrays.sort(pairs, (x, y) -> y.nums2 - x.nums2);
        Queue<Integer> q = new PriorityQueue<>(k+1);
        long res = 0, sum = 0;
        for (var p : pairs) {
            q.add(p.nums1);
            sum += p.nums1;
            if (q.size() > k) sum -= q.poll();
            if (q.size() == k) res = Math.max(res, sum * p.nums2);
        }
        return res;
  
    }
}