class TimeMap {

    private static class Entry {
        int timestamp;
        String value;
        Entry(int t, String v) {
            timestamp = t;
            value = v;
        }
    }   

    Map<String, List<Entry>> m = new HashMap<>();
    public TimeMap() {

    }
    
    public void set(String key, String value, int timestamp) {
        Entry e = new Entry(timestamp, value);
        m.computeIfAbsent(key, x -> new ArrayList<>()).add(e);
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = m.get(key);
        int l = 0;
        if (list == null || list.isEmpty() || list.get(0).timestamp > timestamp) {
            return "";
        }
        int r = list.size() - 1;


        while(l < r) {
            int mid = (l + r + 1) / 2;
            if(list.get(mid).timestamp <= timestamp) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }

        return list.get(l).value;
    }
}
