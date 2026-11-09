class LRUCache {
    
    int cap;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        Integer i = map.get(key);
        if(i == null) {
            return -1;
        }
        map.remove(key);
        map.put(key,i);
        return i;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key,value);
            return;
        }

        if(cap == map.size()) {
            Integer k = map.firstEntry().getKey();
            map.remove(k);
        }
        map.put(key,value);
    }
}
