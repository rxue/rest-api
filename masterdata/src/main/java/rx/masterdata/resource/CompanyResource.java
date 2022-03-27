package rx.masterdata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import rx.masterdata.company.Company;
import rx.masterdata.company.CompanyService;

@Path("/company")
public class CompanyResource {
  @Inject	
  private CompanyService service;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Company> all() {
    return service.listAll();
  }
  @POST
  public void create(Company company, @QueryParam("apikey") String apiKey) {
	service.create(company, apiKey);
  }
}
