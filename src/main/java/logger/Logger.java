package logger;

import writers.Writer;

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

    public static void registerApp(String appName) {
        instance = new Logger(appName);
    }

    public static Logger getInstance() throws Exception {
        if (instance == null) {
            throw new Exception("You should register your app first");
        }

        return instance;
    }
}
