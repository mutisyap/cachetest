package ke.natujenge;

import ke.natujenge.cache.HashMapCache;
import ke.natujenge.cache.HazelcastCache;
import ke.natujenge.recordproducer.FakeRecordProducer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        HashMapCache hashMapCache = new HashMapCache();
        HazelcastCache hazelcastCache = new HazelcastCache();

        FakeRecordProducer fakeRecordProducer = new FakeRecordProducer(hazelcastCache);

        fakeRecordProducer.generateRecords();
    }
}
