package ecommerce.testing.teststeps;

import java.util.Properties;

import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author sudhanshu
 *
 */
public class HttpMethods {

	static Properties pr;
	final static Logger log=Logger.getLogger(HttpMethods.class);
	public HttpMethods(Properties pr) {
		this.pr=pr;
	}
	public Response GetRequest(String URI) {
		log.debug("GetRequest Http method");
		Response getResponse=given().contentType(ContentType.JSON).when().get(pr.getProperty(URI));
		log.info("Response captured for Http method GetRequest:"+getResponse);
		return getResponse;
	}
}
