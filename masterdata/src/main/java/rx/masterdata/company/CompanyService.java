package rx.masterdata.company;

import javax.inject.Inject;

import java.util.List;

import javax.ejb.Stateless;
import static rx.config.JaxRsActivator.API_KEY;

@Stateless
public class CompanyService {
	@Inject
	private CompanyRepository repo;
	public List<Company> findAll() {
		return repo.all();
	}
	public void create(Company company, String apiKey) throws MissingAPIKeyException {
		repo.save(company);
		if (!API_KEY.equals(apiKey))
			throw new MissingAPIKeyException();
	}
	
}
