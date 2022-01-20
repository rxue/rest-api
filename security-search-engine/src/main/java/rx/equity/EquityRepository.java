package rx.equity;

import static rx.config.JaxRsConfiguration.API_KEY;
import static rx.config.JaxRsConfiguration.ENDPOINT_HOST;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.inject.Singleton;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
@Singleton
class EquityRepository {
	private ConcurrentMap<String,Equity> equitiesMap = new ConcurrentHashMap<>();
	
	public Equity get(String tickerSymbol) {
		Client client = ClientBuilder.newBuilder()
	            .build();
		WebTarget target = client.target(ENDPOINT_HOST + "/query?function=TIME_SERIES_DAILY&apikey="  + API_KEY + "&symbol=" + tickerSymbol);
		Invocation webServiceCall = target.request()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.buildGet();
		JsonObject responseJson = webServiceCall.invoke(JsonObject.class);
		JsonObject timeSeries = responseJson.getJsonObject("Time Series (Daily)");
		return new Equity.Builder()
	    		.setTickerSymbol("FORTUM")
	    		.setCompanyName("Fortum Oyj")
	    		.setPrice(1660)
	    		.build();
	}
}
