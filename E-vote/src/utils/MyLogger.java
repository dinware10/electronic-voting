package utils;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;

public class MyLogger {
	
	public  static void initLogging(String nameLogger , String fileName){
		try {
            Logger dataBaseCoonectorLogger = Logger.getLogger(nameLogger);
            File f = new File("logs", fileName);
            FileAppender fapp = new FileAppender(new TTCCLayout("DATE"), f.getAbsolutePath());
            dataBaseCoonectorLogger.addAppender(fapp);
        } catch( IOException e ) {
            System.err.println("Failed to initialize logging for validator");
            return;
        }
	}
}
