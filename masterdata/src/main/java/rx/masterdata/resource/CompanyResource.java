package rx.masterdata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rx.masterdata.company.Company;
import rx.masterdata.company.Repository;

@Path("/company")
public class CompanyResource {
  @Inject	
  private Repository companyRepository;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Company> all() {
    return companyRepository.all();
  }
}
