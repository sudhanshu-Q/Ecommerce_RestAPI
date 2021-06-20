/**
 * 
 */
package ecommerce.testing.testcases;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecommerce.testing.testResponseValiadation.ResponseValidations;
import ecommerce.testing.testUtilities.PropertiesFileLoad;
import ecommerce.testing.teststeps.HttpMethods;
import io.restassured.response.Response;

/**
 * @author sudhanshu
 *
 */
public class TC_3_GetServices {
	
	final static Logger log=Logger.getLogger(TC_3_GetServices.class);

	@Test
	public void initiating_TC_3_GetServices() throws IOException
	{
		Reporter.log("Starting TC_3_GetServices");
		Properties porpertiesRead=PropertiesFileLoad.propertyFileLoad("./EnvironmentConfigurations/Env.properties");
		log.debug("Reading propery file :"+porpertiesRead.getProperty("GetServices"));
		HttpMethods httpMethod=new HttpMethods(porpertiesRead);
		log.debug("Requesting get http method request :"+httpMethod.toString());
		Response responseGet=httpMethod.GetRequest("GetServices");
		log.debug("Response captured for get request as Pretty string method:"+responseGet.asPrettyString());
		ResponseValidations validateResponseGet=new ResponseValidations();
		log.debug("capturing response");
		validateResponseGet.responseValidations(responseGet);
		Reporter.log("Executed TC_3_GetServices successfully");
	}

}
