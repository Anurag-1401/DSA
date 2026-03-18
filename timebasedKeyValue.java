class TimeMap {

    class Pair {
        int timestamp;
        String value;

        Pair(int t, String v) {
            timestamp = t;
            value = v;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l = 0, r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}
