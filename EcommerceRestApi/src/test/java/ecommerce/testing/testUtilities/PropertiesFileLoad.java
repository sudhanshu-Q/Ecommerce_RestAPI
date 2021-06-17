/**
 * 
 */
package ecommerce.testing.testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author sudhanshu
 *
 */
public class PropertiesFileLoad {

	final static Logger log=Logger.getLogger(PropertiesFileLoad.class);


	public static Properties propertyFileLoad(String path) throws IOException
	{
		File sourceProperties= new File(path);
		FileInputStream readEnv=new FileInputStream(sourceProperties);
		Properties readProperties=new Properties();
		readProperties.load(readEnv);
		return readProperties;

	}

}
