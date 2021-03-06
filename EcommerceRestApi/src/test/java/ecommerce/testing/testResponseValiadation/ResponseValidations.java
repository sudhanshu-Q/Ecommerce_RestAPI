/**
 * 
 */
package ecommerce.testing.testResponseValiadation;

import org.apache.log4j.Logger;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author sudhanshu
 *
 */
public class ResponseValidations {

	final static Logger log=Logger.getLogger(ResponseValidations.class);

	public void responseValidations(Response getResponse) {

		log.debug("..............Getting response.............");
		log.info("Getting status code: "+getResponse.getStatusCode());
		log.info("Getting status line in response: "+getResponse.getStatusLine());
		log.info("Getting response body: "+getResponse.getBody());
		log.info("Response header :"+getResponse.getHeaders().asList());
		//capturing response headers 
		Headers header = getResponse.headers();
		for (Header allheader: header)
		{
			log.info("key :"+allheader.getName()+" | " +"value: "+allheader.getValue());
		}
	}

}
