package rx.equity;

import static rx.config.JaxRsConfiguration.API_KEY;
import static rx.config.JaxRsConfiguration.ENDPOINT_HOST;
import java.time.LocalDate;
import java.util.function.Function;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;


@Stateless
public class DailyTimeSeriesDAO {
	private static final int MAX_GAP_BETWEEN_TWO_DATE = 10;
	private final Client client = ClientBuilder.newBuilder()
            .build();
	public TimeSeriesRequestedDTO<LocalDate> getByTickerSymbol(String tickerSymbol) {
		WebTarget target = client.target(ENDPOINT_HOST + "/query?function=TIME_SERIES_DAILY&apikey="  + API_KEY + "&symbol=" + tickerSymbol);
		Invocation webServiceCall = target.request()
				.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE)
				.buildGet();
		JsonObject responseJson = webServiceCall.invoke(JsonObject.class);
		JsonObject metadata = responseJson.getJsonObject("Meta Data");
		JsonObject timeSeries = responseJson.getJsonObject("Time Series (Daily)");
		Function<String,LocalDate> dateParser = dateString -> {
			String[] splitted = dateString.split(" ");
			return LocalDate.parse(splitted[0]);
		};
		LocalDate lastRefreshed = dateParser.apply(metadata.getString("3. Last Refreshed"));
		TimeSeriesRequestedDTO.Builder<LocalDate> resultBuilder = new TimeSeriesRequestedDTO.Builder<LocalDate>()
				.setInformation(metadata.getString("1. Information"))
				.setSymbol(metadata.getString("2. Symbol"))
				.setLastRefreshed(lastRefreshed)
				.setTimeZone(metadata.getString("5. Time Zone"));
		int gap = 0;
		int i = 0;
		while (gap < MAX_GAP_BETWEEN_TWO_DATE) {
			LocalDate date = lastRefreshed.minusDays(i++);
			JsonObject timeSeriesItem = timeSeries.getJsonObject(date.toString());
			if (timeSeriesItem != null) {
				PriceQuarternity priceQuarternity = new PriceQuarternity.Builder()
						.setClose(timeSeriesItem.getString("4. close"))
						.build();
				resultBuilder.appendPrice(date, priceQuarternity);
				gap = 0;
			} else {
				gap++;
			}
		}
		return resultBuilder.build();
	}

}
