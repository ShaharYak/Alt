package writers;

import java.util.HashMap;
import java.util.Map;

public class WritersFactory {
    private static WritersFactory instance = null;

    Map<String, Writer> writers = new HashMap<>();

    private WritersFactory() {

    }

    public static WritersFactory getInstance()
    {
        if (instance == null)
            instance = new WritersFactory();

        return instance;
    }

    public void registerWriter(String writerName, Writer writer) {
        writers.put(writerName, writer);
    }
}
