package logger;

import com.google.gson.Gson;

public class Log {

    private String message;
    private Object extraData;
    private Severity severity;
    private String appName;

    private static Gson gson = new Gson();

    public Log(String message, Object extraData, Severity severity, String appName) {
        this.message = message;
        this.extraData = extraData;
        this.severity = severity;
        this.appName = appName;
    }

    public String getMessage() {
        return message;
    }

    public Object getExtraData() {
        return extraData;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getAppName() {
        return appName;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
