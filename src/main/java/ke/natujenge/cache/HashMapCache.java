package ke.natujenge.cache;

import java.util.HashMap;
import java.util.Map;

public class HashMapCache implements ICache{
    private final Map<Long, Map> recordMap = new HashMap<>();

    public void addToMap(Long key, Map record) {
        recordMap.put(key, record);
    }
}
