package rx.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import rx.jpaentity.Company;
import rx.jpaentity.Region;
@Path("/company")
@ApplicationScoped
public class CompanyResource {
	@PersistenceContext
	EntityManager entityManager;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(JsonObject companyJson) {
		Company company = new Company();
		company.setCompanyCode("VZ");
		company.setHeadquarter(Region.AMERICA);
		company.setName("Verizon");
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(company);
		et.commit();
	}

}
