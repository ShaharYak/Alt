package writers;

import java.util.HashMap;
import java.util.Map;

public class WritersFactory {
    private static WritersFactory instance = null;

    private Map<String, Writer> writers = new HashMap<>();

    public Map<String, Writer> getWriters() {
        return writers;
    }

    private WritersFactory() {
        registerWriter("memory", new MemoryWriter());
        registerWriter("console", new ConsoleWriter());
    }

    public Writer getWriter(String writerName) {
        return writers.get(writerName);
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
