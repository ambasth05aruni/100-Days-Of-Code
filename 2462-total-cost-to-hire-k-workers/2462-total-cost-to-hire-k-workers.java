class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
          var n = costs.length;
    var queue = new PriorityQueue<int[]>((a, b) ->a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

    // If the number of candidates is equal to or greater than half of the total workers,
    // we add all workers to the priority queue
    if (2 * candidates >= n) {
      for (var i = 0; i < n; i++)
        queue.offer(new int[] { costs[i], 0 });
    } else {
      // Otherwise, we add the first and last candidates to the priority queue
      for (var i = 0; i < candidates; i++) {
        queue.offer(new int[] { costs[i], 0 });
        queue.offer(new int[] { costs[n - 1 - i], 1 });
      }
    }

    int l = candidates, r = n - 1 - candidates;
    var cost = 0L;

    // Iterate k times to hire k workers
    for (var i = 0; i < k; i++) {
      var a = queue.poll();
      cost += a[0];

      if (l > r) continue;

      // If the chosen worker is from the first candidates, add the next worker from the left side
      if (a[1] == 0)
        queue.offer(new int[] { costs[l++], 0 });
      // If the chosen worker is from the last candidates, add the next worker from the right side
      else
        queue.offer(new int[] { costs[r--], 1 });
    }

    return cost;
    }
}