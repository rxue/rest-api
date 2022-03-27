package rx.masterdata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rx.masterdata.company.Company;
import rx.masterdata.company.Repository;

@Path("/company")
public class CompanyResource {
  @Inject	
  private Repository repository;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Company> all() {
    return repository.all();
  }
  @POST
  public void create(Company company) {
	repository.save(company);
  }
}
