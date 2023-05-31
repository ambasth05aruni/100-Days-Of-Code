class UndergroundSystem {
 Map<Integer, Pair<String, Integer>> checkIns;
    Map<String, List<Integer>> data;  
    public UndergroundSystem() {
       checkIns = new HashMap<>();
        data = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
      checkIns.put(id, new Pair<>(stationName, t));  
    }
    
    public void checkOut(int id, String stationName, int t) {
         String startDest = checkIns.get(id).getKey();
        int startTime = checkIns.get(id).getValue();
        
        String route = getRoute(startDest, stationName);
        int travelTime = t - startTime;
        checkIns.remove(startDest);
        
        List<Integer> tripsTime = data.getOrDefault(route, new ArrayList<>());
        tripsTime.add(travelTime);
        data.put(route, tripsTime);
    }
    
    public double getAverageTime(String startStation, String endStation) {
         String route = getRoute(startStation, endStation);
        
        List<Integer> times = data.get(route);
        Double totalTravelTime = 0.0;
        int trips = times.size();
        
        for(Integer i: times){
            totalTravelTime += i;
        }
        
        Double res = totalTravelTime/trips;
        return res;
    }
    
    public String getRoute(String start, String end){
        return start + "-" + end;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */