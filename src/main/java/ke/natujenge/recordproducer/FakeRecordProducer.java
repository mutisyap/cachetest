package ke.natujenge.recordproducer;

import ke.natujenge.cache.HashMapCache;
import ke.natujenge.cache.ICache;

import java.util.*;

public class FakeRecordProducer {
    private static final int maxCubeRoot = 150;
    private final Random random = new Random();

    private final ICache cache;


    public FakeRecordProducer(ICache cache) {
        this.cache = cache;
    }

    public void generateRecords() throws InterruptedException {
        long produced = 0;
        try {
            long j = 1;
            for (int i = 1; i < maxCubeRoot; i++) {
                Map record;
                while (j < (i * i * i)) {
                    j++;
                    record = generateRecord();
                    cache.addToMap(j, record);
                    produced++;
                }
                System.out.println("i : " + i + " sleeping. produced : " + produced);
                Thread.sleep(100);

            }
        } catch (OutOfMemoryError error) {
            System.out.println("Run out of memory after writing : " + produced);
        }
    }

    private Map generateRecord() {
        Map<String, Object> record = new HashMap<>();

        record.put("name", getFake());
        record.put("region", getFake());
        record.put("uuid", UUID.randomUUID().toString());
        record.put("doubleValue", random.nextDouble());
        record.put("floatValue", random.nextFloat());
        record.put("longValue", random.nextLong());
        record.put("intValue", random.nextInt());
        record.put("complexString", repeat(getFake(), random.nextInt(10)));

        return record;
    }

    private String repeat(String word, int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            stringBuilder.append(word);
        }

        return stringBuilder.toString();
    }

    private String getFake() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
