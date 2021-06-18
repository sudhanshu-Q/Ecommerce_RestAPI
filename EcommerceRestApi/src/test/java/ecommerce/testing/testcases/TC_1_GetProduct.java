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
public class TC_1_GetProduct {

	final static Logger log=Logger.getLogger(TC_1_GetProduct.class);

	@Test
	public void initiating_TC_1_GetProduct() throws IOException
	{  
		Reporter.log("Starting TC_1_GetProduct");
		Properties propertiesRead=PropertiesFileLoad.propertyFileLoad("./EnvironmentConfigurations/Env.properties");
		log.debug("Reading property file :"+propertiesRead);
		HttpMethods httpsMethods=new HttpMethods(propertiesRead);
		log.debug("Requesting get http method request :"+httpsMethods.toString());
		Response responseGet=httpsMethods.GetRequest("GetProduct");
		log.debug("Response captured for get request as Pretty string method:"+responseGet.asPrettyString());
		ResponseValidations validateResponseGet=new ResponseValidations();
		log.debug("capturing response");
		validateResponseGet.responseValidations(responseGet);
		Reporter.log("Executed TC_2_GetStores successfully");
	}


}
