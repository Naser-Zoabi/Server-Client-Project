package serverpkg;

import mainpkg.Server;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    private static Logger logger = Logger.getLogger("MyLog");
    private static FileHandler fh = null;

    public synchronized static void log(String msg) {

        try {
            if(fh==null) {
                fh = new FileHandler("mylog.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            }
            logger.log(Level.SEVERE,msg);;



        } catch (Exception e) {
            Server.print(e.getMessage());
        }
    }
}
