package rx.equity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/equity")
@RequestScoped
public class EquityResource {
  @Inject	
  private DailyTimeSeriesDAO dao;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public TimeSeriesRequestedDTO getEquity() {
    return dao.getByTickerSymbol("IBM");
  }
}
