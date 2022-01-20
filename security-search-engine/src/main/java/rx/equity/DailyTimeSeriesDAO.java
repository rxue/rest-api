package rx.equity;

import static rx.config.JaxRsConfiguration.API_KEY;
import static rx.config.JaxRsConfiguration.ENDPOINT_HOST;

import java.math.BigDecimal;
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
	public DailyTimeSeriesRequestedDTO getByTickerSymbol(String tickerSymbol) {
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
		DailyTimeSeriesRequestedDTO.Builder resultBuilder = new DailyTimeSeriesRequestedDTO.Builder(
				metadata.getString("2. Symbol"), 
				lastRefreshed, 
				metadata.getString("5. Time Zone"));
		int gap = 0;
		int i = 0;
		while (gap < MAX_GAP_BETWEEN_TWO_DATE) {
			LocalDate date = lastRefreshed.minusDays(i++);
			JsonObject timeSeriesItem = timeSeries.getJsonObject(date.toString());
			if (timeSeriesItem != null) {
				String closePrice = timeSeriesItem.getString("4. close");
				resultBuilder.addDailyItem(date, new BigDecimal(closePrice));
				gap = 0;
			} else {
				gap++;
			}
		}
		return resultBuilder.build();
	}

}
