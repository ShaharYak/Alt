import logger.Logger;
import writers.WritersFactory;

public class main {
    public static void main(String[] args) throws Exception {
        Logger myApp = Logger.registerApp("myApp");
        WritersFactory writersFactory = WritersFactory.getInstance();
        
    }
}
