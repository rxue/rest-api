package rx.equity;

import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import rx.config.JaxRsActivator;

@Path("/equity")
@RequestScoped
public class EquityResource {
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Equity getEquity() {
      Client client = ClientBuilder.newBuilder()
            .build();
	WebTarget target = client.target("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=" + JaxRsActivator.API_KEY);
	Invocation webServiceCall = target.request()
			.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
			.buildGet();
	JsonObject responseString = webServiceCall.invoke(JsonObject.class);
    return new Equity.Builder()
    		.setTickerSymbol("FORTUM")
    		.setCompanyName("Fortum Oyj")
    		.setPrice(1660)
    		.build();
  }
}
