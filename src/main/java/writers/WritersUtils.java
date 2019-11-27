package writers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import logger.Log;

public class WritersUtils {
    public static void writeLogToFile(String path, Log log) {
        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(log);

            o.close();
            f.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
