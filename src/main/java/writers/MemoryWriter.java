package writers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import logger.Log;

public class MemoryWriter implements  Writer {


    public static final String FILE_PATH = "~/alt/memory/logs.txt";

    @Override
    public void write(Log log) {
        try {
            Files.write(Paths.get(FILE_PATH), log.toString().getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
