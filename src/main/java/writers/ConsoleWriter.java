package writers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import logger.Log;

public class ConsoleWriter implements Writer {
    private static final String FILE_PATH = "~/alt/console/logs.txt";

    @Override
    public void write(Log log) {
        System.out.println(log.toString());

        try {
            Files.write(Paths.get(FILE_PATH), log.toString().getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getPath() {
        return FILE_PATH;
    }
}
