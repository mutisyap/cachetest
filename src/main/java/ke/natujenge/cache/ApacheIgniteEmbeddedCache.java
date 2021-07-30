package ke.natujenge.cache;

import ke.natujenge.config.ApacheIgniteConfiguration;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;

import java.util.Map;

public class ApacheIgniteEmbeddedCache implements ICache{
    Ignite igniteInstance = ApacheIgniteConfiguration.getIgniteInstance();
    IgniteCache<Long, Map> cache = igniteInstance.getOrCreateCache(ApacheIgniteEmbeddedCache.class.getName());

    @Override
    public void addToMap(Long key, Map record) {
        cache.put(key, record);
    }
}
