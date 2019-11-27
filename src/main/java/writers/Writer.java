package writers;

import logger.Log;

public interface Writer {
    void write(Log log);
    String getPath();
}
