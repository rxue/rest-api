package rx.equity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.util.stream.Collectors.toList;

@Path("/equity")
@RequestScoped
public class EquityResource {
  @Inject	
  private DailyTimeSeriesDAO dao;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("{tickerSymbol}")
  public TimeSeriesResponseDTO getEquity(@PathParam("tickerSymbol") String tickerSymbol) {
    TimeSeriesRequestedDTO<LocalDate> requestedDTO = dao.getByTickerSymbol(tickerSymbol);
    List<TimeSeriesResponseDTO.ClosePrice> closePriceSeries = requestedDTO.getPriceSeries().stream()
    		.map(p -> new TimeSeriesResponseDTO.ClosePrice(p.getTimeStamp(), getClosePriceValue(p)))
    		.collect(toList());
    return new TimeSeriesResponseDTO.Builder()
    		.setSymbol(requestedDTO.getSymbol())
    		.setTimeZone(requestedDTO.getTimeZone())
    		.setPrices(closePriceSeries)
    		.build();
  }
 
  private static BigDecimal getClosePriceValue(TimeSeriesRequestedDTO.Price<LocalDate> originalPrice) {
    	String closePriceVal = originalPrice.getPriveQuarternity().getClose();
    	return new BigDecimal(closePriceVal.substring(0, closePriceVal.length()-2));
  }
}
