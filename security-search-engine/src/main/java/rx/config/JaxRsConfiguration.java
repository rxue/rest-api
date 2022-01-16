package rx.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is the Java EE 7 "no XML" approach to activating
 * JAX-RS.
 * 
 * <p>
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath} annotation.
 * </p>
 */
@ApplicationPath("/rest")
public class JaxRsConfiguration extends Application {
	public static final String ENDPOINT_HOST = "https://www.alphavantage.co";
    public static final String API_KEY = System.getProperty("apikey");
}
