package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFile {
    private static final Logger LOGGER= LogManager.getLogger(LoadConfigFile.class);

    public Properties readPropertyValue() throws Exception {
        Properties prop= new Properties();
        InputStream inputStream = null;
        try {
            String propFileName= "config.properties";
            inputStream= getClass().getClassLoader().getResourceAsStream(propFileName); //C:\Users\riyad\IdeaProjects\JavaClass1\src\test\resources\config.properties
            if (inputStream!=null){
                prop.load(inputStream);
            } else {
               throw new FileNotFoundException("Property File " + propFileName + "not found in the class path ");
            }
        } catch (Exception e){
            LOGGER.error("Exception: " + e.getMessage());
        }
        finally {
            inputStream.close();
        }
        return prop;
    }

}
