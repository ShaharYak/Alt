package writers;

import logger.Log;

public class ConsoleWriter implements Writer {
    @Override
    public void write(Log log) {
        System.out.println(log.toString());
    }
}
