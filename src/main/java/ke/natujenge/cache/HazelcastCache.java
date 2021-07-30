package ke.natujenge.cache;

import com.hazelcast.core.HazelcastInstance;
import ke.natujenge.config.HazelcastConfiguration;

import java.util.Map;

public class HazelcastCache implements ICache{
    private final HazelcastInstance hazelcastInstance = HazelcastConfiguration.getHazelcastInstance();

    public void addToMap(Long key, Map record) {
        hazelcastInstance.getMap(HazelcastCache.class.getName()).set(key, record);
    }
}
