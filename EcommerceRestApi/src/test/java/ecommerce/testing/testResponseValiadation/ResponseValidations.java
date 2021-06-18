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
			String xpoweredResponseHeader=header.get("x-powered-by").getValue();
			if (allheader.getName().equals(xpoweredResponseHeader)) {
				log.info(xpoweredResponseHeader.equals("Express")+" : "+xpoweredResponseHeader+" : Verifying | x-powered-by | Response header");
			}
			else {
				log.error("Not verified : "+xpoweredResponseHeader);
			}
		}
		//		String xpoweredResponseHeader=header.get("x-powered-by").getValue();
		//		if (xpoweredResponseHeader.equals("Expressk")) {
		//		log.info(xpoweredResponseHeader.equals("Express")+" : "+xpoweredResponseHeader+" : Verifying | x-powered-by | Response header");
		//		}
		//		else {
		//			log.error("Not verified : "+xpoweredResponseHeader);
		//		}
		/**
		 * {
  "access-control-allow-origin": "*",
  "allow": "GET,POST,PUT,PATCH,DELETE",
  "content-encoding": "gzip",
  "content-type": "application/json; charset=utf-8",
  "date": "Fri, 18 Jun 2021 03:51:20 GMT",
  "etag": "W/\"175b-ahK67GuMia7YzxPW6JneHQxymiA\"",
  "vary": "Accept",
  "x-powered-by": "Express"
}
		 **/
	}

}
