package logger;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import writers.Writer;
import writers.WritersFactory;

public class Logger {
    private static Logger instance = null;
    private String appName;

    private Logger(String name) {
        this.appName = name;
    }

    public void info(String message, Object extraData, Writer writer) {
        writer.write(new Log(message, extraData, Severity.LOW, appName));
    }

    public void warning(String message, Object extraData, Writer writer) {
        writer.write(new Log(message, extraData, Severity.MEDIUM, appName));
    }

    public void error(String message, Object extraData, Writer writer) {
        writer.write(new Log(message, extraData, Severity.HIGH, appName));
    }

    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        WritersFactory.getInstance()
                .getWriters()
                .values()
                .stream().map(Writer::getPath)
                .forEach(path -> readLogs(path, logs));

        return logs;
    }

    private void readLogs(String path, List<Log> logs) {
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);

            while (oi.readObject() != null) {
                logs.add((Log) oi.readObject());
            }

            oi.close();
            fi.close();
        }
        catch (Exception e) {

        }
    }

    public static Logger registerApp(String appName) {
        instance = new Logger(appName);

        return instance;
    }

    public static Logger getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("You should register your app first");
        }

        return instance;
    }
}
