class SnapshotArray {
 List<Map<Integer, Integer>> list;
    int snapID;
    public SnapshotArray(int length) {
      list = new ArrayList();
        for (int i = 0; i < length; i++) list.add(new HashMap());
        snapID = 0;   
    }
    
    public void set(int index, int val) {
         list.get(index).put(snapID, val);
    }
    
    public int snap() {
         return snapID++;
    }
    
    public int get(int index, int snap_id) {
         Map<Integer, Integer> map = list.get(index);
        if (map.containsKey(snap_id)) return map.get(snap_id);
        int last = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() > last && entry.getKey() <= snap_id) last = entry.getKey(); 
        }
        return map.getOrDefault(last, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */